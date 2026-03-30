package gold.dp;

import java.io.*;
import java.util.*;

/*
동전의 종류가 주어질 때 주어진 금액을 만드는 모든 방법을 세는 프로그램을 작성하라.

<입력>
T
- T: 테스트 케이스의 개수 (1 ~ 10)
N
- N: 동전의 종류 (1 ~ 20)
동전들 (N개)
- 공백으로 구분
- 오름차순으로 주어짐.
- 같은 금액의 동전은 주어지지 않음.
M
- M: 만들어야 하는 금액 (1 ~ 10^4)

<출력>
N가지 동전으로 만들 수 있는 경우의 수 (int형)
 */

public class Problem9084 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());

            StringTokenizer st  = new StringTokenizer(br.readLine());
            int[] coins = new int[n];
            for (int i = 0; i < n; i++) {
                coins[i] = Integer.parseInt(st.nextToken());
            }
            int m = Integer.parseInt(br.readLine());

            int[] dp = new int[m+1];
            dp[0] = 1;
            for (int i = 0; i < n; i++) {
                for (int j = coins[i]; j <= m; j++) {
                    dp[j] += dp[j - coins[i]];
                }
            }

            sb.append(dp[m]).append('\n');
        }

        System.out.print(sb);
    }
}
