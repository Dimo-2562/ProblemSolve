package silver.dp;

import java.io.*;
import java.util.*;

public class Problem1912 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] dp = new int[n + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        int answer = Integer.MIN_VALUE;
        for (int i = 1; i <= n; i++) {
            int num = Integer.parseInt(st.nextToken());
            dp[i] = Math.max(dp[i - 1] + num, num);
            answer = Math.max(answer, dp[i]);
        }

        System.out.print(answer);
    }
}
