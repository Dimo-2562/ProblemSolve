package silver.dp;

import java.io.*;
import java.util.*;

/*
X에 적용할 수 있는 연산 3가지
1. 3으로 나누기
2. 2로 나누기
3. 1을 빼기.
N에서 연산을 통해 1을 만들고자 한다. 이 때 연산을 사용하는 횟수의 최솟값을 출력하라.

<입력>
N
- (1 ~ 10^6)

<출력>
연산을 하는 횟수의 최솟값.

<풀이>

 */

public class Problem1463 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] dp = new int[n+1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[n] = 0;

        for (int i = n; i >= 2; i--) {
            if (i % 3 == 0) {
                dp[i / 3] = Math.min(dp[i / 3], dp[i] + 1);
            } if (i % 2 == 0) {
                dp[i / 2] = Math.min(dp[i / 2], dp[i] + 1);
            }
            dp[i - 1] = Math.min(dp[i - 1], dp[i] + 1);
        }

        System.out.print(dp[1]);
    }
}
