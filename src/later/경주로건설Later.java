package later;

import java.io.*;
import java.util.*;

/*
N * N 정사각형
각 칸은 0 or 1 (0은 비어있음, 1은 벽)
(0, 0) -> (N-1, N-1)

이동: 상하좌우
벽이 있는 칸은 당연히 불가.

직선 도로: 100원
코너: 500원

경주로를 건설하는데 필요한 최소 비용을 구하라.

<풀이>
0-1 bfs
이전 이동방향이 어디냐에 따라 가중치가 변함.
이전 이동방향을 Queue에 들고 다니기.
*/

class 경주로건설Later {
    // 0, 1은 세로 / 2, 3은 가로
    static int[] dy = {1, -1, 0, 0};
    static int[] dx = {0, 0, 1, -1};

    public int solution(int[][] board) {
        int n = board.length;
        int[][][] dist = new int[n][n][2];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < 2; k++) {
                    dist[i][j][k] = Integer.MAX_VALUE;
                }
            }
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[3] - o2[3]);
        pq.add(new int[]{0, 0, 0, 0});
        pq.add(new int[]{0, 0, 1, 0});
        dist[0][0][0] = 0;
        dist[0][0][1] = 0;

        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int y = cur[0];
            int x = cur[1];
            int dir = cur[2];
            int cost = cur[3];

            if (cost > dist[y][x][dir]) continue;

            for (int k = 0; k < 4; k++) {
                int ny = y + dy[k];
                int nx = x + dx[k];
                int ncost = cost;
                int ndir = k < 2 ? 0 : 1;

                if (ny < 0 || ny >= n || nx < 0 || nx >= n) continue;
                if (board[ny][nx] == 1) continue;

                if (dir == ndir) ncost += 100;
                else ncost += 600;

                if (dist[ny][nx][ndir] > ncost) {
                    dist[ny][nx][ndir] = ncost;
                    pq.add(new int[]{ny, nx, ndir, ncost});
                }
            }
        }

        return Math.min(dist[n - 1][n - 1][0], dist[n - 1][n - 1][1]);
    }
}