package silver.lis;

import java.io.*;
import java.util.*;

public class Problem11053 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        // 입력 받고
        int[] input = new int[n];
        int[] dp = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            input[i] = Integer.parseInt(st.nextToken());
            dp[i] = 1;
        }

        // 1차원 배열 초기값 1. 얘를 포함하는 가장 긴 증가하는 부분 수열의 길이
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++){
                if (input[j] < input[i] && dp[j] <= dp[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }

        int max = dp[0];
        for (int i = 1; i < n; i++) {
            max = Math.max(max, dp[i]);
        }
        System.out.print(max);

    }
}
