package lv3.shortestpath.floyd;

import java.util.*;

/*
n명의 권투선수 (1 ~ n번)
A 선수가 B 선수보다 실력이 좋다면 A 선수는 B 선수를 항상 이긴다.
순위를 매기려 한다.
정확하게 순위를 매길 수 있는 선수의 수를 return 하라.

<입력>
n
- n: 선수의 수 (1 ~ 10^2)
results
- results: 경기 결과 (1 ~ 10^3)
- [a, b]: a가 b를 이겼다.
- 모순은 없다.

<출력>
정확하게 순위를 매길 수 있는 선수의 수

<풀이>
플로이드 워셜
true인 게 n - 1이면 ++
*/

class 순위 {
    public int solution(int n, int[][] results) {
        boolean[][] isWin = new boolean[n + 1][n + 1];

        for (int[] result: results) {
            int a = result[0];
            int b = result[1];
            isWin[a][b] = true;
        }

        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    if (i == j) continue;
                    if (isWin[i][k] && isWin[k][j]) isWin[i][j] = true;
                }
            }
        }

        int answer = 0;
        for (int i = 1; i <= n; i++) {
            int cnt = 0;
            for (int j = 1; j <= n; j++) {
                if (i == j) continue;
                if (isWin[i][j] || isWin[j][i]) cnt++;
            }
            if (cnt == n - 1) answer++;
        }

        return answer;
    }
}
