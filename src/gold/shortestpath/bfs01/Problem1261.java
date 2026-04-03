package gold.shortestpath.bfs01;

import java.io.*;
import java.util.*;

/*
미로는 N*M
빈 방 or 벽
벽은 부술 수 있음.
(1,1)에서 시작 -> (N, M)

<입력>
M, N
- M: 가로 크기 (1 ~ 10^2)
- N: 세로 크기 (1 ~ 10^2)
미로의 상태 (N개의 줄)
- 0: 빈 방
- 1: 벽

<출력>
(N,M)으로 이동하기 위해 부숴야하는 벽의 개수

벽을 부수는 건 가중치가 1
벽이 없는건 가중치가 0
0-1 BFS
 */

public class Problem1261 {
    static int[] dy = {1, -1, 0, 0};
    static int[] dx = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        int[][] map = new int[n + 1][m + 1];
        for (int i = 1; i <= n; i++) {
            String input = br.readLine();
            for (int j = 1; j <= m; j++) {
                map[i][j] = input.charAt(j - 1) - '0';
            }
        }

        int[][] dist = new int[n + 1][m + 1];
        for (int i = 1; i <= n; i++)
            for (int j = 1; j <= m; j++) dist[i][j] = Integer.MAX_VALUE;

        Deque<int[]> dq = new ArrayDeque<>();
        dq.add(new int[]{1, 1, 0});
        dist[1][1] = 0;

        while (!dq.isEmpty()) {
            int[] cur = dq.pollFirst();
            int y = cur[0];
            int x = cur[1];
            int cost = cur[2];

            if (cost > dist[y][x]) continue;

            for (int k = 0; k < 4; k++) {
                int ny = y + dy[k];
                int nx = x + dx[k];

                if (ny < 1 || ny > n || nx < 1 || nx > m) continue;

                int ncost = cost + map[ny][nx];
                if (ncost < dist[ny][nx]) {
                    dist[ny][nx] = ncost;
                    if (map[ny][nx] == 0) dq.addFirst(new int[]{ny, nx, ncost});
                    else dq.addLast(new int[]{ny, nx, ncost});
                }
            }

        }
        System.out.print(dist[n][m]);
    }
}