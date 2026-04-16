package silver.dp;

import java.io.*;

/*
포도주 규칙 2가지
1. 선택하면 다 마시고, 원래 위치에 두기
2. 연속으로 3잔은 마실 수 없다.

1 ~ n번까지 번호가 붙어있는 포도주 n개.
가장 많은 양의 포도주를 마실 수 있도록 하라.

<입력>
n
- n: 포도주 잔의 개수 (1 ~ 10^4)
포도주의 양 (n개의 줄)
- (0 ~ 10^3)

<출력>
가장 많이 마실 수 있는 포도주의 양

<풀이>
가장 많이 마실 수 있는 경우

dp[n] = n번까지 마실 수 있는 가장 많은 양의 포도주.
1. 이번 꺼를 안 마실 때 dp[n-1]
2-1. 이번 꺼를 마시는 경우 dp[n-2] + arr[n]
2-2. 이번 꺼를 마시는 경우 dp[n-3] + arr[n-1] + arr[n]
 */

public class Problem2156 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        int[] dp = new int[n + 1];
        dp[1] = arr[1];
        if (n >= 2) dp[2] = arr[1] + arr[2];
        if (n >= 3) dp[3] = Math.max(Math.max(arr[1] + arr[3], arr[2] + arr[3]), dp[2]);

        for (int i = 4; i <= n; i++) {
            dp[i] = dp[i - 1];
            dp[i] = Math.max(dp[i], dp[i - 2] + arr[i]);
            dp[i] = Math.max(dp[i], dp[i - 3] + arr[i - 1] + arr[i]);
        }

        System.out.print(dp[n]);
    }
}
