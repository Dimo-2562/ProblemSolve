package silver.dp;

import java.io.*;
import java.util.*;

/*
수열 A가 주어졌을 때, 가장 긴 증가하는 부분 수열을 구하라.

<입력>
N
- N: 수열 A의 크기 (1 ~ 10^3)
수열의 숫자들
(1 ~ 10^3)

<출력>
가장 긴 증가하는 부분 수열의 길이를 출력

<풀이>
N^2 풀이가 가능.

dp[i] = i번째까지 가장 긴 증가하는 부분 수열

-> 풀이 생각 못함.

dp[i] = i번째를 반드시 포함하는 가장 긴 증가하는 부분 수열
why? 그 정보가 있어야 다음 거랑 비교가 가능함.
 */

public class Problem11053Later {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int[] dp = new int[n + 1];
        int answer = -1;
        for (int i = 1; i <= n; i++) {
            dp[i] = 1;
            for (int j = 1; j < i; j++) {
                if (arr[i] > arr[j]) dp[i] = Math.max(dp[i], dp[j] + 1);
            }
            answer = Math.max(answer, dp[i]);
        }

        System.out.print(answer);
    }
}
