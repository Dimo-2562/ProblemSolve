package lv2.dp;

import java.util.*;

/*
n번째 피보나치 수를 1234567로 나눈 나머지를 리턴하라

<입력>
n
- n: 자연수 (2 ~ 10^5)

<출력>
n번째 피보나치 수

<풀이>
DP
*/

class 피보나치수 {
    public int solution(int n) {
        int[] dp = new int[100001];
        dp[0] = 0;
        dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2]) % 1234567;
        }

        return dp[n];
    }
}