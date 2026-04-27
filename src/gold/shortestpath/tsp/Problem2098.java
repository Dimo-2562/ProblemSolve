package gold.shortestpath.tsp;

import java.util.*;
import java.io.*;

/*
TSP
1 ~ N번까지 도시
도시들 사이에는 도로
한 도시에서 출발해 N개의 도시를 모두 거쳐 다시 원래의 도시로 돌아오는 순회 여행 경로
단, 한 번 갔던 도시로는 다시 갈 수 없다. (처음 도시로 돌아오는 것은 예외)

최단 경로를 구하라.
도로의 비용은 대칭적이지 않다.

<입력>
N
- N: 도시의 수 (2 ~ 16)
W[i][j] (i개의 줄)
- W[i][j] : 도시 간의 비용 (1 ~ 10^6)
- 갈 수 없는 경우 0이 주어진다.

<출력>
최단 경로

<풀이>
TSP -> 비트마스킹 DP


 */

public class Problem2098 {
    static int[][] w;
    static int[][] dp;
    static int n;

    static final int INF = 1_000_000_000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        w = new int[n][n];
        dp = new int[n][1 << n];

        for (int i = 0; i < n; i++) Arrays.fill(dp[i], -1);

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                w[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        System.out.print(tsp(0, 1));
    }

    static int tsp(int cur, int visited) {
        if (visited == (1 << n) - 1) {
            if (w[cur][0] == 0) return INF;
            return w[cur][0];
        }

        if (dp[cur][visited] != -1) {
            return dp[cur][visited];
        }

        dp[cur][visited] = INF;

        for (int next = 0; next < n; next++) {
            if (w[cur][next] == 0) continue;

            if ((visited & (1 << next)) != 0) continue;

            int nextVisited = visited | (1 << next);
            int cost = w[cur][next] + tsp(next, nextVisited);

            dp[cur][visited] = Math.min(dp[cur][visited], cost);
        }

        return dp[cur][visited];
    }
}
