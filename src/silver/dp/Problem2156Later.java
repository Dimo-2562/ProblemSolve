package silver.dp;

import java.io.*;

/*
포도주 시식
1. 포도주 잔 선택 시 모든 것을 마시고, 다시 놔둘 것
2. 연속으로 놓여있는 잔을 3잔 마실 수는 없음.

<입력>
n
- n: 포도주 잔의 개수 (1 ~ 10^4)
포도주의 양(n개의 줄)
- 값의 범위 (0 ~ 10^3)

<출력>
포도주의 최댓값을 구하라.

<풀이>
dp[1] = arr[1]
dp[2] = arr[1] + arr[2]
dp[3] = max(arr[1] + arr[3], arr[2] + arr[3])

dp[n] = max(dp[i-2] + arr[i], dp[i-3] + arr[i-1] + arr[i]) -> 점화식!
= n을 꼭 마시면서 최댓값.

마지막 걸 마시지 않아도 되므로 최댓값을 for문 돌면서 찾기.

-> 점화식이 성립하지 않음.
dp[n] = max(
    dp[n-1],
    max(dp[n-2] + arr[i], dp[n-3] + arr[i-1] + arr[i])
= n까지의 최댓값.

 */

public class Problem2156Later {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        int[] dp = new int[n + 1];
        // 초기값 설정 (n은 1이상)
        dp[1] = arr[1];
        if (n >= 2) dp[2] = arr[1] + arr[2];
        if (n >= 3) dp[3] = Math.max(dp[2],
                Math.max(arr[1] + arr[3], arr[2] + arr[3]));

        // 점화식 기반으로 채워나가기.
        for (int i = 4; i <= n; i++) {
            dp[i] = Math.max(dp[i - 1],
                    Math.max(dp[i - 2] + arr[i], dp[i - 3] + arr[i - 1] + arr[i]));
        }

        System.out.print(dp[n]);
    }
}
