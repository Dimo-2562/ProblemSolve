package later;

import java.util.*;
import java.io.*;

/*

 */

public class Problem10971Later {
    static int n;
    static int[][] w;
    static int[][] dp;

    static final int INF = 1_000_000_000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        w = new int[n][n];
        dp = new int[n][1 << n];

        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                w[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        System.out.println(tsp(0, 1));
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