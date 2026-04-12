package silver.shortestpath.bfs;

import java.io.*;
import java.util.*;

/*
모든 지점에 대해서 목표 지점까지의 거리를 구하여라.

<입력>
n, m
- n: 세로의 크기 (2 ~ 10^3)
- m: 가로의 크기 (2 ~ 10^3)
m개의 숫자 (n개의 줄)
- 0은 갈 수 없음
- 1은 갈 수 있음
- 2는 목표지점.

<출력>
각 지점에서 목표지점까지의 거리를 출력
원래 갈 수 없으면 그대로 0 출력.
0때문에 가로막힌 곳이면 -1 출력.

bfs
 */

public class Problem14940 {

    static int n, m;
    static int[][] map;
    static boolean[][] visited;

    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, -1, 0, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        visited = new boolean[n][m];

        int[] start = new int[2];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 2) {
                    start[0] = i;
                    start[1] = j;
                }
            }
        }

        bfs(start);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 1 && !visited[i][j]) map[i][j] = -1;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                sb.append(map[i][j]).append(' ');
            }
            sb.append('\n');
        }

        System.out.print(sb);
    }

    static void bfs(int[] start) {
        int y = start[0];
        int x = start[1];

        visited[y][x] = true;
        map[y][x] = 0;

        Deque <int[]> dq = new ArrayDeque<>();
        dq.addLast(new int[]{y, x, 0});
        while (!dq.isEmpty()) {
            int[] cur = dq.pollFirst();
            y = cur[0];
            x = cur[1];

            for (int k = 0; k < 4; k++) {
                int ny = y + dy[k];
                int nx = x + dx[k];

                if (ny >= 0 && ny < n && nx >= 0 && nx < m && !visited[ny][nx] && map[ny][nx] == 1) {
                    visited[ny][nx] = true;
                    map[ny][nx] = map[y][x] + 1;
                    dq.addLast(new int[]{ny, nx});
                }
            }
        }
    }
}
