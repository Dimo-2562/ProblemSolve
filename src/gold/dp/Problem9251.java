package gold.dp;

import java.io.*;

/*
LCS
 */

public class Problem9251 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String strA = br.readLine();
        String strB = br.readLine();

        int[][] dp = new int[strA.length() + 1][strB.length() + 1];
        for (int i = 1; i <= strA.length(); i++) {
            for (int j = 1; j <= strB.length(); j++) {
                if (strA.charAt(i - 1) == strB.charAt(j - 1)) dp[i][j] = dp[i-1][j-1] + 1;
                else dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
            }
        }

        System.out.print(dp[strA.length()][strB.length()]);
    }
}
