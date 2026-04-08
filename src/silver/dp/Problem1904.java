package silver.dp;

import java.io.*;

/*
0도는 1이 쓰여진 타일
00 타일 or 1타일
N이 주어졌을 때 지원이가 만들 수 있는 가짓수를 세기.

<입력>
N
- N: 크기 (1 ~ 10^6)

<출력>
2진 수열의 개수를 15746으로 나눈 나머지를 출력

<풀이>
dp[1] = 1
dp[2] = 2
dp[3] = 3
dp[4] = 5
 */

public class Problem1904 {
    static final int DIV = 15746;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        if (n == 1) {
            System.out.println(1);
            return;
        }

        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            dp[i] = ((dp[i-1] % DIV) + (dp[i-2] % DIV)) % DIV;
        }

        System.out.print(dp[n]);
    }
}
