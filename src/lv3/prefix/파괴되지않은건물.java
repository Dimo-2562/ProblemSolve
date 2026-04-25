package lv3.prefix;

import java.util.*;

/*
N * M 크기의 행렬
내구도를 가진 건물이 각 칸마다 하나씩 있다.
건물은 공격을 받으면 감소
회복 스킬을 사용하여 내구도가 높아짐.

<입력>
board
- board: 건물의 내구도를 나타내는 2차원 정수 배열 (1 ~ 10^6)
- 각 원소 (1 ~ 10^3)
skill
- skill: 공격 or 회복 (1 ~ 10^5)
- [type, r1, c1, r2, c2, degree]
- type: 1(공격) or 2(회복)
- degree (1 ~ 500)

<출력>
파괴되지 않은 건물의 개수

<풀이>
배열의 값은 int로 커버됨.

매번 skill 마다 2중 for문 -> 시간 초과
diff 배열로 나중에 누적합
r1, c1          +
r2 + 1, c1      -
r1, c2 + 1      -
r2 + 1, c2 + 1  -

누적합은 row마다 먼저 돌리고, 그 다음 col 돌리기.
*/

class 파괴되지않은건물 {
    public int solution(int[][] board, int[][] skill) {
        int n = board.length;
        int m = board[0].length;

        int[][] diff = new int[n + 1][m + 1];

        for (int[] s : skill) {
            int type = s[0];
            int r1 = s[1]; int c1 = s[2];
            int r2 = s[3]; int c2 = s[4];
            int degree = type == 1 ? (-1) * s[5] : s[5];

            diff[r1][c1] += degree;
            diff[r2 + 1][c1] -= degree;
            diff[r1][c2 + 1] -= degree;
            diff[r2 + 1][c2 + 1] += degree;
        }

        for (int i = 0; i < n; i++) {
            for (int j = 1; j < m; j++) {
                diff[i][j] += diff[i][j - 1];
            }
        }

        for (int j = 0; j < m; j++) {
            for (int i = 1; i < n; i++) {
                diff[i][j] += diff[i - 1][j];
            }
        }

        int answer = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] + diff[i][j] > 0) answer++;
            }
        }

        return answer;
    }
}