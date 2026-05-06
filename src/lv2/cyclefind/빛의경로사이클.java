package lv2.cyclefind;

import java.util.*;

/*
각 칸마다 S, L, R이 써져 있는 격자가 있다.
이 격자에서 빛을 쏜다.
격자의 각 칸에는 특이한 성질
L에 도달하면 좌회전
R에 도달하면 우회전
격자의 끝을 넘어가면 반대쪽 끝으로 다시 돌아온다.

경로 사이클의 길이를 알고싶다.

<입력>
grid
- grid: 격자 배열 (1 ~ 10^2)
- grid[i]: 각 문자열 (1 ~ 10^2)
- L, R, S로 구성

<출력>
경로 사이클의 길이들을 배열에 담아 오름차순으로 정렬하여 return

<풀이>
outdegree가 1인 그래프 -> 순환 그래프 찾기
각 방향별 상태를 두기.

*/

class 빛의경로사이클 {
    String[] grid;
    int rows, cols;
    boolean[][][] visited;
    int[] dy = {1, 0, -1, 0};
    int[] dx = {0, 1, 0, -1};

    public int[] solution(String[] grid) {
        this.grid = grid;
        rows = grid.length;
        cols = grid[0].length();
        visited = new boolean[rows][cols][4];

        List<Integer> answerList = new ArrayList<>();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                for (int k = 0; k < 4; k++) {
                    if (visited[i][j][k]) continue;

                    int len = solve(i, j, k);
                    answerList.add(len);
                }
            }
        }

        answerList.sort((o1, o2) -> o1 - o2);
        int[] answer = new int[answerList.size()];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = answerList.get(i);
        }
        return answer;
    }

    int solve(int y, int x, int dir) {
        int cost = 0;

        while (!visited[y][x][dir]) {
            visited[y][x][dir] = true;

            int ny = (y + dy[dir] + rows) % rows;
            int nx = (x + dx[dir] + cols) % cols;
            int ndir = dir;
            cost++;

            char c = grid[ny].charAt(nx);
            if (c == 'L') ndir = (dir + 1) % 4;
            if (c == 'R') ndir = (dir + 3) % 4;

            if (ny == y && nx == x && ndir == dir) {
                return cost;
            }

            y = ny;
            x = nx;
            dir = ndir;
        }

        return cost;
    }
}