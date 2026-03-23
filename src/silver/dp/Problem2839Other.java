package silver.dp;

import java.io.*;
import java.util.*;

public class Problem2839Other {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] dp = new int[n+1];
        Arrays.fill(dp, 5000);
        dp[0] = 0;
        for (int i = 3; i <= n; i++) {
            if (i >= 5) dp[i] = Math.min(dp[i], dp[i-5] + 1);
            dp[i] = Math.min(dp[i], dp[i-3] + 1);
        }

        System.out.print(dp[n] >= 5000 ? -1 : dp[n]);
    }
}
