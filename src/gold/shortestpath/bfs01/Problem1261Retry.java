package gold.shortestpath.bfs01;

import java.io.*;
import java.util.*;

/*
N*M 크기
빈 방 or 벽
상하좌우 이동
미로의 밖으로는 이동 불가.

벽을 부술 수 있음.

(1,1) -> (N,M)

<입력>
M, N
- M: 가로 크기 (1 ~ 10^2)
- N: 세로 크기 (1 ~ 10^2)
미로의 상태 (N개의 줄)
- 0: 빈 방
- 1: 벽

<출력>
벽을 최소 몇 개 부수어야 하는가?

가중치가 0과 1인 그래프 탐색 -> 0-1bfs
 */

public class Problem1261Retry {

    static int[] dy = {1, -1, 0, 0};
    static int[] dx = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        int[][] map = new int[n + 1][m + 1];
        boolean[][] visited = new boolean[n + 1][m + 1];

        for (int i = 1; i <= n; i++) {
            String input = br.readLine();
            for (int j = 1; j <= m; j++) {
                char c = input.charAt(j - 1);
                map[i][j] = c - '0';
            }
        }

        Deque<int[]> dq = new ArrayDeque<>();
        dq.addLast(new int[]{1, 1, 0});
        visited[1][1] = true;

        int answer = Integer.MAX_VALUE;
        while (!dq.isEmpty()) {
            int[] cur = dq.pollFirst();
            int y = cur[0];
            int x = cur[1];
            int cost = cur[2];

            if (y == n && x == m) {
                answer = Math.min(answer, cost);
                break;
            }

            for (int k = 0; k < 4; k++) {
                int ny = y + dy[k];
                int nx = x + dx[k];

                if (ny < 1 || ny > n || nx < 1 || nx > m || visited[ny][nx]) continue;

                if (map[ny][nx] == 0) {
                    visited[ny][nx] = true;
                    dq.addFirst(new int[]{ny, nx, cost});
                } else {
                    visited[ny][nx] = true;
                    dq.addLast(new int[]{ny, nx, cost + 1});
                }
            }
        }

        System.out.print(answer);
    }
}
