package silver.dp;

import java.io.*;

/*
N번째 피보나치 수를 구하라.

<입력>
T
- T: 테스트 케이스의 개수
N

<출력>
0이 출력되는 횟수와 1이 출력되는 횟수 (공백으로 구분)

<풀이>
dp[2][n]
- 0, 1, 1
- 1, 1, 2
 */

public class Problem1003 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[][] dp = new int[2][41];
        dp[0][0] = 1; dp[1][0] = 0;
        dp[0][1] = 0; dp[1][1] = 1;
        for (int i = 2; i <= 40; i++) {
            dp[0][i] = dp[0][i - 1] + dp[0][i - 2];
            dp[1][i] = dp[1][i - 1] + dp[1][i - 2];
        }

        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            sb.append(dp[0][n]).append(' ').append(dp[1][n]).append('\n');
        }
        System.out.print(sb);
    }
}
