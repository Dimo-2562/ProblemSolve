package gold.dp;

import java.io.*;

/*

 */

public class Problem9252 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String strA = br.readLine();
        String strB = br.readLine();

        int n = strA.length();
        int m = strB.length();

        int[][] dp = new int[n + 1][m + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (strA.charAt(i - 1) == strB.charAt(j - 1)) dp[i][j] = dp[i - 1][j - 1] + 1;
                else dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
            }
        }

        StringBuilder sb = new StringBuilder();
        int i = n;
        int j = m;
        while (i >= 1 && j >= 1) {
            if (strA.charAt(i - 1) != strB.charAt(j - 1)) {
                if (dp[i - 1][j] > dp[i][j - 1]) i--;
                else j--;
            } else {
                sb.append(strA.charAt(i - 1));
                i--;
                j--;
            }
        }

        System.out.println(dp[n][m]);
        System.out.print(sb.reverse());
    }
}
