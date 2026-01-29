package silver.prefixsum;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem11660 {
    public static void main(String[] args) throws IOException {
        /*
        N: 표의 크기 (10^3), M: 합을 구해야 하는 횟수 (10^5)
        2~N: 표에 채워진 수
        M개의 줄: 네 개의 정수 x1, y1, x2, y2
        - x는 행, y는 열
         */

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] arr = new int[n + 1][n + 1];
        int[][] dp = new int[n + 1][n + 1];

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                dp[i][j] = arr[i][j];
            }
        }

        // 각 1행과 1열 값 초기화
        for (int i = 2; i <= n; i++) {
            dp[1][i] += dp[1][i - 1];
            dp[i][1] += dp[i - 1][1];
        }

        for (int i = 2; i <= n; i++) {
            for (int j = 2; j <= n; j++) {
                dp[i][j] = dp[i][j] + dp[i - 1][j] + dp[i][j - 1] - dp[i - 1][j - 1];
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            int row1 = Integer.parseInt(st.nextToken());
            int col1 = Integer.parseInt(st.nextToken());
            int row2 = Integer.parseInt(st.nextToken());
            int col2 = Integer.parseInt(st.nextToken());

            int sum = dp[row2][col2] - dp[row2][col1-1] - dp[row1-1][col2] + dp[row1-1][col1-1];
            sb.append(sum).append('\n');
        }

        System.out.print(sb);
    }
}
