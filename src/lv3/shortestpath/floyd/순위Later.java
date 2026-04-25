package lv3.shortestpath.floyd;

/*
n명의 권투선수 (1번 ~ n번)
1:1
A 선수가 B 선수보다 실력이 좋다면 A 선수는 B 선수를 항상 이긴다.
순위를 매기려고 한다.
몇 경기를 분실하여 정확하게 순위를 매길 수 없다

<입력>
n
- n: 선수의 수 (1 ~ 10^2)
results
- results: 경기 결과 (1 ~ 10^3)
- [a, b]: a가 b를 이겼다.

<출력>
정확하게 순위를 매길 수 있는 선수의 수를 return 하라.

<풀이>
위상 정렬
4 -> 3 -> 2
1 -> 2 -> 5

풀이 봄 -> 플로이드-워셜 알고리즘
*/

class 순위Later {
    public int solution(int n, int[][] results) {
        boolean[][] win = new boolean[n + 1][n + 1];

        for (int[] result : results) {
            int a = result[0];
            int b = result[1];
            win[a][b] = true;
        }

        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    if (i == j) continue;
                    if (win[i][k] && win[k][j]) win[i][j] = true;
                }
            }
        }

        int answer = 0;
        for (int i = 1; i <= n; i++) {
            int known = 0;
            for (int j = 1; j <= n; j++) {
                if (i == j) continue;
                if (win[i][j] || win[j][i]) known++;
            }

            if (known == n - 1) answer++;
        }

        return answer;
    }
}