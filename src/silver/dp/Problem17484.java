package silver.dp;

import java.io.*;
import java.util.*;

/*
우주선의 이동 방향은 좌측 하단, 하단, 우측 하단.
전에 움직인 방향으로는 움직일 수 없다.
연료를 최대한 아끼도록

<입력>
N, M
- N, M: 행렬의 크기
각 행렬의 원소들

<출력>
최소 연료의 값.

DP -> 3차원 DP [y][x][이전 방향]
 */

public class Problem17484 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] input = new int[n+2][m+2];
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= m; j++) {
                input[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[][][] dp = new int[n+2][m+2][3];
        for (int[][] a : dp)
            for (int[] b : a)
                Arrays.fill(b, Integer.MAX_VALUE);

        for (int j = 1; j <= m; j++) {
            dp[1][j][0] = input[1][j];
            dp[1][j][1] = input[1][j];
            dp[1][j][2] = input[1][j];
        }

        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (j+1 <= m) dp[i][j][0] = Math.min(dp[i-1][j+1][1], dp[i-1][j+1][2]) + input[i][j];
                dp[i][j][1] = Math.min(dp[i-1][j][0] , dp[i-1][j][2]) + input[i][j];
                if (j-1 >= 1) dp[i][j][2] = Math.min(dp[i-1][j-1][0], dp[i-1][j-1][1]) + input[i][j];
            }
        }

        int answer = Integer.MAX_VALUE;
        for (int j = 1; j <= m; j++) {
            for (int k = 0; k <= 2; k++) {
                answer = Math.min(answer, dp[n][j][k]);
            }
        }
        System.out.print(answer);
    }
}
