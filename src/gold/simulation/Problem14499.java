package gold.simulation;

import java.io.*;
import java.util.*;

/*
지도
N * M
(r,c)로 좌표 표현

주사위
(x,y)에 놓여짐
1이 윗면, 3이 동쪽으로
처음에는 모든 면에 0이 적혀져 있음.

주사위를 굴려서 이동한 칸이 0이면, 주사위의 바닥면의 수를 복사함.
0이 아닌 경우에는 칸에 쓰여 있는 수가 바닥면으로 잘라내기됨.

주사위를 놓은 곳의 좌표 + 이동시키는 명령
주사위가 이동할 때마다 상단에 쓰여있는 값을 구하라.
만약 지도의 바깥으로 가려고 하면 명령 무시.

N, M, x, y, K
- N: 세로 크기
- M: 가로 크기
- x, y: 주사위 좌표
- K: 명령의 개수
지도에 쓰여져 있는 수
명령이 순서대로 주어짐
- 동쪽은 1, 서쪽은 2, 북쪽은 3, 남쪽은 4
 */

public class Problem14499 {

    static int[] dy = {0, 0, -1, 1};
    static int[] dx = {1, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        // 입력 받고
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[][] map = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[] dice = new int[7];
        StringBuilder sb = new StringBuilder();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < k; i++) {
            int com = Integer.parseInt(st.nextToken());

            int ny = y + dy[com-1];
            int nx = x + dx[com-1];
            if (ny < 0 || ny >= n || nx < 0 || nx >= m) continue;

            // 주사위 위치 이동
            y = ny;
            x = nx;

            // 주사위 면 회전
            if (com == 1) {
                int tmp = dice[1];
                dice[1] = dice[4];
                dice[4] = dice[6];
                dice[6] = dice[3];
                dice[3] = tmp;
            } else if (com == 2) {
                int tmp = dice[1];
                dice[1] = dice[3];
                dice[3] = dice[6];
                dice[6] = dice[4];
                dice[4] = tmp;
            } else if (com == 3) {
                int tmp = dice[1];
                dice[1] = dice[5];
                dice[5] = dice[6];
                dice[6] = dice[2];
                dice[2] = tmp;
            } else {
                int tmp = dice[1];
                dice[1] = dice[2];
                dice[2] = dice[6];
                dice[6] = dice[5];
                dice[5] = tmp;
            }

            // map이 0인지 여부 체크
            // dice[6]이 아랫면
            if (map[y][x] == 0) {
                map[y][x] = dice[6];
            } else {
                dice[6] = map[y][x];
                map[y][x] = 0;
            }

            sb.append(dice[1]).append('\n');
        }

        System.out.print(sb);
    }
}
