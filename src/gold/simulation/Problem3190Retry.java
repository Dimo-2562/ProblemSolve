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

public class Problem3190Retry {

    static int[] dy = {0, 1, 0, -1};
    static int[] dx = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        boolean[][] body = new boolean[n + 1][n + 1];
        boolean[][] apple = new boolean[n + 1][n + 1];

        int k = Integer.parseInt(br.readLine());
        for (int i = 0; i < k; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int row = Integer.parseInt(st.nextToken());
            int col = Integer.parseInt(st.nextToken());
            apple[row][col] = true;
        }

        int l = Integer.parseInt(br.readLine());
        Map<Integer, Integer> changes = new HashMap<>();
        for (int i = 0; i < l; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int time = Integer.parseInt(st.nextToken());
            int change = st.nextToken().charAt(0) == 'L' ? 3 : 1;
            changes.put(time, change);
        }

        Deque<int[]> snake = new ArrayDeque<>();
        snake.addLast(new int[]{1, 1});
        body[1][1] = true;
        int dir = 0;
        int answer = 0;

        while (true) {
            answer++;

            // 뱀의 머리 변수로 받기
            int[] head = snake.peekFirst();

            // 다음 머리 위치 계산
            int ny = head[0] + dy[dir];
            int nx = head[1] + dx[dir];

            // 머리가 벽이나 몸에 닿으면 break
            if (ny <= 0 || ny > n || nx <= 0 || nx > n || body[ny][nx]) {
                break;
            }

            // 머리가 빈 칸을 만나면 꼬리 제거
            if (!apple[ny][nx]) {
                int[] tail = snake.pollLast();
                body[tail[0]][tail[1]] = false;
            } else {
                apple[ny][nx] = false;
            }

            // 머리 이동
            snake.addFirst(new int[] {ny, nx});
            body[ny][nx] = true;

            // 방향 전환
            if (changes.containsKey(answer)) {
                dir = (dir + changes.get(answer)) % 4;
            }
        }

        System.out.print(answer);

    }
}
