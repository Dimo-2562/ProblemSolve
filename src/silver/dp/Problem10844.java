package silver.dp;

import java.io.*;

/*
인접한 모든 자리의 차이가 1인 수 = 계단 수
N이 주어질 때 길이가 N인 계단수를 구하라.
단, 0으로 시작하는 수는 계단수가 아니다.

<입력>
N
- N (1 ~ 10^2)

<출력>
정답을 10^9으로 나눈 나머지를 출력하라.

<풀이>
mod를 사용해야 함.

N = 1 -> 1, 2, 3, 4, 5 다 됨
N = 2 ->

dp[k][n] = k자리이면서, n으로 시작하는 or n으로 종료하는 숫자.

1) 시작하는 -> 추적이 힘듦.
dp[1][n] = {0, 1, 1, 1, 1, 1, 1, 1, 1, 1}
dp[2][n] = {0, 2, 2, 2, 2, 2, 2, 2, 2, 2}
dp[3][n] = {0,

2) 종료하는
dp[1][n] = {0, 1, 1, 1, 1, 1, 1, 1, 1, 1}
dp[2][n] = {1, 1, 2, 2, 2, 2, 2, 2, 2, 1}
dp[3][n] = {

dp[k][n] = dp[k-1][n-1] + dp[k-1][n-1] -> 점화식이 나옴!
n이 0일때와 n-1일때 엣지 케이스만 주의하자.
 */

public class Problem10844 {
    static final int DIV = 1_000_000_000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[][] dp = new int[n + 1][10];

        // n은 무조건 1 이상 -> 초기값
        for (int i = 1; i <= 9; i++) dp[1][i] = 1;

        for (int i = 2; i <= n; i++) {
            dp[i][0] = dp[i - 1][1] % DIV;
            for (int j = 1; j <= 8; j++) {
                dp[i][j] = ((dp[i - 1][j - 1] % DIV) + (dp[i - 1][j + 1] % DIV)) % DIV;
            }
            dp[i][9] = dp[i - 1][8] % DIV;
        }

        int answer = 0;
        for (int i = 0; i <= 9; i++) {
            answer = ((answer % DIV) + (dp[n][i] % DIV)) % DIV;
        }
        System.out.println(answer);
    }
}
