package gold.simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem14503 {
    static int[] dy = {0, 1, 0, -1};
    static int[] dx = {-1, 0, 1, 0};

    public static void main(String[] args) throws IOException {
        /**
         * 청소하는 영역의 개수를 구하라.
         *
         * 방: N*M (3 ~ 10^1)
         * - 벽 or 빈 칸
         * - (r,c)로 표현
         * - (0,0) ~ (N-1, M-1)
         *
         * 청소기: 방향 존재 (동, 서, 남, 북)
         * 1. 현재 칸이 청소되지 않으면 현재 칸 청소
         * 2. 현재 칸의 주변 4칸 중 청소되지 않은 빈 칸이 없는 경우,
         *  2-1. 방향 유지한채로 한 칸 후진할 수 있으면 후진 후 1번으로 복귀
         *  2-2. 방향 유지한채로 후진할 수 없으면 종료
         * 3. 현재 칸의 주변 4칸 중 청소되지 않는 빈 칸이 있는 경우
         *  3-1. 반시계 방향으로 90도 회전 (서 -> 남 -> 동 -> 북)
         *  3-2. 바라보는 방향 기준으로 앞쪽이 청소되지 않은 빈칸이면 한 칸 전진
         *  3-3. 1번으로 복귀
         *
         *  입력
         *  - N, M
         *  - (r,c), d (0이면 북, 1이면 동, 2이면 남, 3이면 서)
         *  - N개의 줄에 걸쳐 각 장소 상태 입력
         *      (0이면 빈칸, 1이면 벽)
         */

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] room = new int[n][m];

        st = new StringTokenizer(br.readLine());
        Cleaner cleaner = new Cleaner();
        cleaner.y = Integer.parseInt(st.nextToken());
        cleaner.x = Integer.parseInt(st.nextToken());
        cleaner.dir = 3 - Integer.parseInt(st.nextToken());

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                room[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 작동 시작
        int ans = 0;
        while (true) {
            // 1. 자기 위치를 청소
            if (room[cleaner.y][cleaner.x] == 0){
                room[cleaner.y][cleaner.x] = 2;
                ans++;
            }

            // 2. 주변 4칸 중 빈 칸 탐색
            boolean isEmpty = false;
            for (int k = 0; k < 4; k++) {
                int y = cleaner.y + dy[k];
                int x = cleaner.x + dx[k];

                if (room[y][x] == 0) isEmpty = true;
            }

            // 빈 칸 체크
            if (!isEmpty) {
                // 3. 빈 칸이 없다면
                int y = cleaner.y + dy[(cleaner.dir + 2) % 4];
                int x = cleaner.x + dx[(cleaner.dir + 2) % 4];
                // 후진할 수 있으면 후진
                if (room[y][x] != 1) {
                    cleaner.y = y;
                    cleaner.x = x;
                } else {
                    break;
                }
            } else {
                // 4. 빈 칸이 있다면
                cleaner.dir = (cleaner.dir + 1) % 4;
                int y = cleaner.y + dy[cleaner.dir];
                int x = cleaner.x + dx[cleaner.dir];
                if (room[y][x] == 0) {
                    cleaner.y = y;
                    cleaner.x = x;
                }
            }
        }

        System.out.print(ans);

    }
}

class Cleaner {
    public int y;
    public int x;
    public int dir;
}
