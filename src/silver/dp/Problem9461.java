package silver.dp;

import java.io.*;

/*
첫 삼각형은 변의 길이가 1
1 1 1 2 2 3 4 5 7 9
ㅇ      ㅇ

<입력>
T
- T: 테스트 케이스 개수
N
- N: N번째 삼각형 (1 ~ 10^2)

<출력>
N번째 변의 길이를 줄마다 출력.

<풀이>
dp[i] = dp[i - 1] + dp[i - 5];
 */

public class Problem9461 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        long[] dp = new long[101];
        dp[1] = dp[2] = dp[3] = 1;
        dp[4] = dp[5] = 2;
        for (int i = 6; i <= 100; i++) {
            dp[i] = dp[i - 1] + dp[i - 5];
        }

        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            sb.append(dp[n]).append('\n');
        }

        System.out.print(sb);
    }
}