package gold.dp;

import java.io.*;

/*
정수 n을 1, 2, 3으로 나타내는 방법의 수를 출력하라.
단, 수의 순서만 다른 것은 같은 것으로 친다.

<입력>
T
- T: 테스트 케이스의 개수
n
- n (1 ~ 10^4)

<출력>
n을 1, 2, 3으로 나타내는 방법의 수를 (T개의 줄에 걸쳐) 출력.

<풀이>
동전 문제
 */

public class Problem15989 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());

            int[] dp = new int[n + 1];
            dp[0] = 1;

            for (int i = 1; i <= 3; i++) {
                for (int j = i; j <= n; j++) {
                    dp[j] += dp[j-i];
                }
            }

            sb.append(dp[n]).append('\n');
        }

        System.out.print(sb);
    }
}