package lv3.dp;

import java.util.*;

/*
거스름돈 n원을 줄 때 경우의 수를 구하자.

<입력>
n
- n: 거스름돈 (1 ~ 10^5)
money
- money: 화폐의 종류 (1 ~ 10^2)
- 화폐 개수는 무한함

<출력>
경우의 수를 1_000_000_007로 나눈 나머지를 return 하라.

<풀이>
동전 DP (동전을 각각 사용할 때 +하기)
나머지
*/

class 거스름돈 {
    static final int DIV = 1_000_000_007;

    public int solution(int n, int[] money) {
        int[] dp = new int[n + 1];
        dp[0] = 1;

        for (int i = 0; i < money.length; i++) {
            int coin = money[i];
            for (int j = coin; j <= n; j++) {
                dp[j] = (dp[j] + dp[j - coin]) % DIV;
            }
        }

        return dp[n];
    }
}