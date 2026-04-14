package gold.shortestpath.dijkstra;

import java.io.*;
import java.util.*;

/*
도둑 루피: 소지한 루피가 감소됨.
도둑 루피만 가득찬 곳.
N * N 맵
처음 시작: [0][0]
도착지: [N-1][N-1]
잃는 금액을 최소로 하도록.

<입력>
N
- N: 동굴의 크기 (2 ~ 10^2)
- N이 0이 주어지면 종료.
도둑 루피의 크기 (N개의 줄)
- 값 (0 ~ 9)

<출력>
Problem X : 비용 (줄 바꿈)

<풀이>
가중치가 다양한 최단경로 -> 다익스트라.
처음 시작점도 비용에 포함.

 */

public class Problem4485 {
    static int[] dy = {1, -1, 0, 0};
    static int[] dx = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();
        int idx = 1;
        while (true) {
            int n = Integer.parseInt(br.readLine());

            if (n == 0) break;

            int[][] map = new int[n][n];
            for (int i = 0; i < n; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < n; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            int[][] dist = new int[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    dist[i][j] = Integer.MAX_VALUE;
                }
            }

            PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> Integer.compare(o1[2], o2[2]));
            dist[0][0] = map[0][0];
            pq.add(new int[]{0, 0, dist[0][0]});

            while (!pq.isEmpty()) {
                int[] cur = pq.poll();
                int y = cur[0];
                int x = cur[1];
                int cost = cur[2];

                if (dist[y][x] < cost) continue;

                for (int k = 0; k < 4; k++) {
                    int ny = y + dy[k];
                    int nx = x + dx[k];
                    if (ny < 0 || ny >= n || nx < 0 || nx >= n) continue;

                    int nCost = map[ny][nx];

                    if (dist[ny][nx] > dist[y][x] + nCost) {
                        dist[ny][nx] = dist[y][x] + nCost;
                        pq.add(new int[]{ny, nx, dist[ny][nx]});
                    }

                }
            }

            sb.append("Problem ").append(idx).append(": ").append(dist[n-1][n-1]).append('\n');
            idx++;
        }

        System.out.print(sb);
    }
}
