package later;

import java.util.*;

/*
N * M 행렬
내구도를 가진 건물이 각 칸마다 있음
건물은 적의 공격을 받으면 내구도 감소, 0이하가 되면 파괴
아군은 회복 스킬을 통해 건물들의 내구도를 높일 수 있다.
건물은 계속 상태를 체크해야 함.

(0, 0) ~ (N - 1, M - 1)

<입력>
board
- board: 건물의 내구도를 나타내는 2차원 배열
- 가로, 세로 (1 ~ 10^3)
- 각 원소 (1 ~ 10^3)
skill
- skill: 공격 or 회복 (1 ~ 10^5)
- [type, r1, c1, r2, c2, degree]
- type == 1 ? 공격 : 회복
- degree: 공격 또는 회복의 정도 (1 ~ 500)

<출력>
파괴되지 않은 건물의 개수

<풀이>
int형으로 커버 가능

브루트포스 -> 시간 초과
skill만큼은 반복해야 함 (10^5)

풀이 봄 -> diff 배열 + 누적합으로 나중에 한 번에
*/

class 파괴되지않은건물Later {
    public int solution(int[][] board, int[][] skill) {
        int n = board.length;
        int m = board[0].length;

        int[][] diff = new int[n + 1][m + 1];

        for (int[] s : skill) {
            int r1 = s[1];
            int c1 = s[2];
            int r2 = s[3];
            int c2 = s[4];

            int degree = s[5];
            if (s[0] == 1) degree *= (-1);

            diff[r1][c1] += degree;
            diff[r1][c2 + 1] -= degree;
            diff[r2 + 1][c1] -= degree;
            diff[r2 + 1][c2 + 1] += degree;
        }

        // 가로 누적
        for (int i = 0; i < n; i++) {
            for (int j = 1; j < m; j++) {
                diff[i][j] += diff[i][j - 1];
            }
        }

        // 세로 누적
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