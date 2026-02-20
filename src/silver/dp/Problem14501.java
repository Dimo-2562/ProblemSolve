package silver.dp;

import java.io.*;
import java.util.*;

/*
DP

N
- N: 날짜
Ti, Pi
- Ti: 걸리는 시간
- Pi: 수익

최대 수익을 구하라.
 */

public class Problem14501 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[][] meeting = new int[n + 1][2];
        int[] dp = new int[n + 2];
        for (int i = 1; i <= n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            meeting[i][0] = Integer.parseInt(st.nextToken());
            meeting[i][1] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i <= n; i++) {
            int day = i + meeting[i][0];
            if (day <= n+1) {
                dp[day] = Math.max(dp[i] + meeting[i][1], dp[day]);
            }
            dp[i+1] = Math.max(dp[i+1], dp[i]);
        }

        System.out.print(dp[n+1]);
    }
}
