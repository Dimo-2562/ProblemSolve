package later;

import java.io.*;

/*
두 수열이 주어졌을 때, 모두의 부분 수열이 되는 수열 중 가장 긴 것을 찾아라.

<입력>
두 줄에 걸쳐 문자열이 주어짐
- 알파벳 대문자로만 구성
- 길이 (1 ~ 10^3)

<출력>
LCS의 길이를 출력하라.

<풀이>
감이 안 잡혔음.

다차원 DP,

dp[i][j] = A의 앞 i개, B의 앞 j개를 봤을 때 LCS 길이
점화식
- 문자가 같은 경우: dp[i][j] = dp[i-1][j-1] + 1
- 문자가 다른 경우: dp[i][j] = max(dp[i-1][j], dp[i-1][j])

이 두 문자 A[i], B[j]를 포함할지 말지.

 */

public class Problem9251Later {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String a = br.readLine();
        String b = br.readLine();

        int n = a.length();
        int m = b.length();

        int[][] dp = new int[n + 1][m + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (a.charAt(i - 1) == b.charAt(j - 1)) dp[i][j] = dp[i-1][j-1] + 1;
                else dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
            }
        }

        System.out.print(dp[n][m]);
    }
}
