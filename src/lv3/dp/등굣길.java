package lv3.dp;

import java.io.*;
import java.util.*;

/*
m * n 크기의 지도
(1, 1) ~ (m, n)

이동: 오른쪽과 아래쪽만
최단경로의 개수를 1_000_000_007로 나눈 나머지를 return 하라.

<입력>
m, n
- m: 가로 (1 ~ 10^2)
- n: 세로 (1 ~ 10^2)
int[][] puddles
- puddles: 물이 잠긴 지역
- 개수 (0 ~ 10)

<출력>
최단경로의 개수를 1_000_000_007로 나눈 나머지를 return 하라.

<풀이>
모든 경로가 최단경로임.
DP의 사용
dp[i][j] = (dp[i-1][j] % DIV + dp[i][j-1] % DIV) % DIV
*/

class 등굣길 {
    static int[][] map;
    static int[][] dp;

    static final int DIV = 1_000_000_007;

    public int solution(int m, int n, int[][] puddles) {
        map = new int[n + 1][m + 1];
        dp = new int[n + 1][m + 1];

        for (int[] puddle : puddles) {
            int x = puddle[0];
            int y = puddle[1];
            map[y][x] = -1;
        }

        dp[1][1] = 1;

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (i == 1 && j == 1) continue;
                if (map[i][j] == -1) continue;

                dp[i][j] = (dp[i - 1][j] + dp[i][j - 1]) % DIV;
            }
        }

        return dp[n][m];
    }
}