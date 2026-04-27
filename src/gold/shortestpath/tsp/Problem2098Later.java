package gold.shortestpath.tsp;

import java.util.*;
import java.io.*;

/*
1번부터 N번까지 번호가 매겨져있는 도시들
간선이 있다.
N개의 도시를 모두 거쳐 다시 원래 도시로 돌아오는 순회 여행 경로
단, 한 번 갔던 도시로는 다시 갈 수 없다. (맨 처음 출발도시로 돌아온느 것은 예외)

간선 : W[i][j]
비용은 비대칭적
모든 도시간의 비용은 양수
가장 적은 비용을 들이는 외판원 순회 여행 경로를 구하라.

<입력>
N
- N: 도시의 수 (2 ~ 16)
W[i][j] (i개의 줄)
- 원소 (1 ~ 10^6)

<출력>
가장 적은 비용을 들이는 외판원 순회 여행 경로

<풀이>
TSP -> 비트마스킹 DP
방문한 도시 상태를 int형 변수로 비트마스크 관리.
 */

public class Problem2098Later {
    static int n;
    static int[][] W;
    static int[][] dp;

    static final int INF = 1_000_000_000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        W = new int[n][n];
        dp = new int[n][1 << n];

        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                int cost = Integer.parseInt(st.nextToken());
                W[i][j] = cost;
            }
        }

        int visited = 1;
        System.out.print(tsp(0, visited));
    }

    static int tsp(int cur, int visited) {
        // 다 돌았을 때
        if (visited == (1 << n) - 1) {
            if (W[cur][0] == 0) return INF;
            return W[cur][0];
        }

        if (dp[cur][visited] != -1) {
            return dp[cur][visited];
        }

        dp[cur][visited] = INF;

        for (int next = 0; next < n; next++) {
            if (W[cur][next] == 0) continue;

            if ((visited & (1 << next)) != 0) continue;

            int nextVisited = visited | (1 << next);
            int cost = W[cur][next] + tsp(next, nextVisited);

            dp[cur][visited] = Math.min(dp[cur][visited], cost);
        }

        return dp[cur][visited];
    }
}