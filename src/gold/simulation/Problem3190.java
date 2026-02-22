package gold.simulation;

import java.io.*;
import java.util.*;

/*
뱀
- 사과를 먹으면 길어짐
- 벽이나 몸에 부딪히면 끝
- 시작 지점은 (1, 1)
- 시작 길이는 1
- 처음 방향은 우측

이동
- 머리를 다음 칸으로 이동
- 이동한 칸에 사과가 있으면 꼬리 이동 X
-            사과가 없으면 꼬리가 위치한 칸을 비움.

맵
- N * N
- 사과 존재
- 상하좌우 끝에는 벽


사과의 위치와 뱀의 이동 경로가 주어질 때 게임이 끝나는 시간을 계산


입력
N
- 보드의 크기 (2 ~ 10^2)
K
- 사과의 개수 (0 ~ 10^2)
사과의 위치 (행, 열)
L
- 뱀의 방향 변환 횟수 (1 ~ 10^2)
뱀의 방향 변환 정보 (X, C)
- X초 후에 C 방향으로 90도 회전 (1 ~ 10^4)
- C: L -> 왼쪽, D -> 오른쪽
- 방향 전환 정보는 오름차순으로 주어짐.
 */

public class Problem3190 {

    static int n;
    static int[][] map;

    static Deque<int[]> snake = new ArrayDeque<>();
    static int dir = 0;

    static int[] dy = {0, 1, 0, -1};
    static int[] dx = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 입력 받아서 맵 구성
        n = Integer.parseInt(br.readLine());
        map = new int[n + 2][n + 2];

        // 빈칸은 0, 벽은 -1, 뱀은 1, 사과는 2
        // 벽 채우기
        for (int i = 0; i < n + 2; i++) {
            map[0][i] = -1;
            map[n + 1][i] = -1;
            map[i][0] = -1;
            map[i][n + 1] = -1;
        }

        // 사과 채우기
        int k = Integer.parseInt(br.readLine());
        for (int i = 0; i < k; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int[] apple = new int[2];
            for (int j = 0; j < 2; j++) {
                apple[j] = Integer.parseInt(st.nextToken());
            }
            map[apple[0]][apple[1]] = 2;
        }

        // 뱀 위치
        map[1][1] = 1;
        snake.add(new int[]{1, 1});

        // 방향 변환 정보는 Queue로 넣어두기.
        Deque<Change> q = new ArrayDeque<>();
        int l = Integer.parseInt(br.readLine());
        for (int i = 0; i < l; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int time = Integer.parseInt(st.nextToken());
            char change = st.nextToken().charAt(0);
            q.add(new Change(time, change));
        }

        // 뱀 이동 시작 while 문으로 구성
        int record = 0;
        while (true) {
            record++;

            int[] head = snake.peekFirst();
            int[] tail = snake.peekLast();

            // 뱀 머리 이동(방향 따라)
            int ny = head[0] + dy[dir];
            int nx = head[1] + dx[dir];

            // 해당 위치 체크 (사과, 뱀, 벽)
            if (map[ny][nx] == -1 || map[ny][nx] == 1) {
                break;
            } else if (map[ny][nx] == 0) { // 빈 칸이면
                snake.pollLast();
                map[tail[0]][tail[1]] = 0;
            }

            // 뱀 머리 이동 맵에 반영
            snake.addFirst(new int[] {ny, nx});
            map[ny][nx] = 1;

            // 뱀 머리 방향 전환
            if (!q.isEmpty()) {
                Change first = q.peekFirst();
                if (record == first.time) {
                    if (first.change == 'D') dir = (dir + 1) % 4;
                    else dir = (dir + 3) % 4;
                    q.pollFirst();
                }
            }
        }

        System.out.print(record);
    }

    static class Change {
        int time;
        char change;

        Change(int time, char change) {
            this.time = time;
            this.change = change;
        }
    }
}
