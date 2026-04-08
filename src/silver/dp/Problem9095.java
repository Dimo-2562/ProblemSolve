package silver.dp;

import java.io.*;

/*
n을 1, 2, 3의 합으로 나타내는 방법의 수를 구하라.

<입력>
T
- T: 테스트 케이스의 수
n
- (1 ~ 11)

<출력>
n을 1, 2, 3의 합으로 나타내는 방법의 수

<풀이>
dp[1] = 1
dp[2] = 2
dp[3] = 4
dp[n] = dp[n-1] + dp[n-2] + dp[n-3];
 */

public class Problem9095 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] dp = new int[12];
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;
        for (int i = 4; i <= 11; i++) {
            dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3];
        }

        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            sb.append(dp[n]).append('\n');
        }
        System.out.print(sb);
    }
}
