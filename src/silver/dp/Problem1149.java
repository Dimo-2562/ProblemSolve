package silver.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem1149 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[][] dp = new int[n+1][3];
        for (int i = 1; i <= n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++){
                int num = Integer.parseInt(st.nextToken());
                if (j == 0) {
                    dp[i][j] = num + Math.min(dp[i-1][1], dp[i-1][2]);
                } else if (j == 1) {
                    dp[i][j] = num + Math.min(dp[i-1][0], dp[i-1][2]);
                } else {
                    dp[i][j] = num + Math.min(dp[i-1][0], dp[i-1][1]);
                }
            }
        }

        int max = Integer.MAX_VALUE;
        for (int i = 0; i < 3; i++) max = Math.min(max, dp[n][i]);
        System.out.print(max);
    }
}
