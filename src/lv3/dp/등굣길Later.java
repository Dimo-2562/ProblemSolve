package lv3.dp;

/*
m = col
n = row

물에 잠긴 지역은 접근 불가.
오른쪽과 아래쪽으로만 움직여 최단 경로의 개수를 1,000,000,007로 나눈 나머지를 return

<입력>
m, n
- m: col (1 ~ 10^2)
- n: row (1 ~ 10^2)
puddles
- 개수 (0 ~ 10)
- 집과 학교는 물에 잠기지 않음.

<출력>
오른쪽과 아래쪽으로만 움직여 최단 경로의 개수를 1,000,000,007로 나눈 나머지를 return

<풀이>
bfs - 개수 체크
int[] visited

*/

class 등굣길Later {
    static final int DIV = 1_000_000_007;

    public int solution(int m, int n, int[][] puddles) {
        int[][] dp = new int[n + 1][m + 1];
        boolean[][] blocked = new boolean[n + 1][m + 1];

        for (int[] pos : puddles) {
            blocked[pos[1]][pos[0]] =  true;
        }

        dp[1][1] = 1;

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (i == 1 && j == 1) continue;
                if (blocked[i][j]) continue;

                dp[i][j] = (dp[i-1][j] % DIV + dp[i][j-1] % DIV) % DIV;
            }
        }

        return dp[n][m];
    }
}