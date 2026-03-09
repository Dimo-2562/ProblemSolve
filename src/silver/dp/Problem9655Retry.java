package silver.dp;

import java.io.*;
import java.util.*;

public class Problem9655Retry {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        boolean[] dp = new boolean[1001];
        dp[1] = true;
        dp[2] = false;
        for (int i = 3; i <= 1000; i++) {
            dp[i] = !dp[i-1] || !dp[i-3];
        }
        System.out.println(dp[n] ? "SK" : "CY");
    }
}
