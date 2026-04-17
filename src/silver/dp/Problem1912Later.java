package silver.dp;

import java.io.*;
import java.util.*;

/*
n개의 정수로 이루어진 임의의 수열
연속된 몇 개의 수를 선택해서 구할 수 있는 합 중 가장 큰 합.

<입력>
n
- n: 정수의 개수 (1 ~ 10^5)
수열
- 숫자의 범위 (-10^3 ~ 10^3)

<출력>
가장 큰 합

<풀이>
int 범위에서 커버됨.

투포인터? -> sum이 단조성을 띠지 않으므로 불가.
풀이 생각해내지 못함 -> DP (i번째 항을 꼭 포함하는 연속된 수열)
 */

public class Problem1912Later {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        int[] dp = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        dp[0] = arr[0];
        int answer = dp[0];

        for (int i = 1; i < n; i++) {
            dp[i] = Math.max(arr[i], dp[i - 1] + arr[i]);
            answer = Math.max(answer, dp[i]);
        }

        System.out.print(answer);
    }
}
