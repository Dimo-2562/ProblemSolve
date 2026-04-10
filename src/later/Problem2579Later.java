package later;

import java.io.*;

/*
1계단 or 2계단
연속된 3개의 계단을 모두 밟아서는 안 된다.
마지막껀 반드시 밟아야 한다.

<입력>
n
- n: 계단의 개수 (1 ~ 10^2)
계단의 점수 (n개 줄)
- (1 ~ 10^4)

<출력>
총 점수의 최댓값

<풀이>
dp[i-1]은 상태가 확정 X.
dp[i] = dp[i-2] + arr[i]
dp[i] = dp[i-3] + arr[i-1] + arr[i]

 */

public class Problem2579Later {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[301];
        int[] dp = new int[301];
        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        dp[1] = arr[1];
        dp[2] = arr[1] + arr[2];
        dp[3] = Math.max(arr[1] + arr[3], arr[2] + arr[3]);

        for (int i = 4; i <= n; i++) {
            dp[i] = Math.max(dp[i - 3] + arr[i - 1] + arr[i], dp[i - 2] + arr[i]);
        }

        System.out.print(dp[n]);
    }
}