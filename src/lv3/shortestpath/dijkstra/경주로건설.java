package lv3.shortestpath.dijkstra;

import java.util.*;

/*
N*N크기의 정사각형 형태
0(빈 칸) or 1(벽)
(0, 0) ~ (N-1, N-1)

직선 도로: 100원
코너: 500원 + 100원 = 600원

경주로를 건설하는 데 필요한 최소 비용을 계산

<입력>
borad
- board: 경주로 부지 (25 * 25)
- 각 원소의 값 (0 or 1)

<출력>
경주로를 건설하는데 필요한 최소 비용

<풀이>
상하[0] 좌우[1]
가중치가 다름 -> 다익스트라

*/

class 경주로건설 {
    int[][][] dist;
    int[] dy = {1, -1, 0, 0};
    int[] dx = {0, 0, 1, -1};

    final int INF = Integer.MAX_VALUE;

    public int solution(int[][] board) {
        int n = board.length;
        dist = new int[n][n][2];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                Arrays.fill(dist[i][j], INF);
            }
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[2] - o2[2]);
        dist[0][0][0] = 0;
        dist[0][0][1] = 0;
        pq.add(new int[]{0, 0, 0, 0});
        pq.add(new int[]{0, 0, 0, 1});

        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int y = cur[0];
            int x = cur[1];
            int cost = cur[2];
            int dir = cur[3];

            if (cost > dist[y][x][dir]) continue;

            for (int k = 0; k < 4; k++) {
                int ny = y + dy[k];
                int nx = x + dx[k];

                if (ny < 0 || ny >= n || nx < 0 || nx >= n) continue;
                if (board[ny][nx] == 1) continue;

                int nDir = (k <= 1) ? 0 : 1;
                int nCost = (dir == nDir) ? 100 : 600;

                if (dist[ny][nx][nDir] > dist[y][x][dir] + nCost) {
                    dist[ny][nx][nDir] = dist[y][x][dir] + nCost;
                    pq.add(new int[]{ny, nx, dist[ny][nx][nDir], nDir});
                }
            }
        }

        return Math.min(dist[n-1][n-1][0], dist[n-1][n-1][1]);
    }
}