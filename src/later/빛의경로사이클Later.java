package later;

import java.util.*;

/*
S, L, R이 적혀있는 격자
S: 직진
L: 좌회전
R: 우회전
빛이 격자의 끝을 넘어갈 경우, 반대쪽 끝으로 다시 돌아온다.

경로 사이클이 몇 개 있고, 각 사이클의 길이가 얼마인지 알고싶다.

<입력>
grid: 격자의 정보 (1 ~ 10^2)
- grid[i] : 문자열 (1 ~ 10^2)
- L, R, S로 구성

<출력>
빛의 경로 사이클의 길이를 오름차순으로 리턴하라.

<풀이>
각 위치의 가능성 250000 (10^5)
각 방향 4개
1000000 -> 10^6

*/

class 빛의경로사이클Later {
    String[] grid;
    boolean[][][] visited;
    int rows, cols;
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
                for (int dir = 0; dir < 4; dir++) {
                    if (visited[i][j][dir]) continue;
                    int len = move(i, j, dir);
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

    int move(int y, int x, int dir) {
        Deque<int[]> dq = new ArrayDeque<>();

        dq.addLast(new int[]{y, x, dir, 0});
        visited[y][x][dir] = true;

        while (!dq.isEmpty()) {
            int[] cur = dq.pollFirst();
            int cy = cur[0];
            int cx = cur[1];
            int cdir = cur[2];
            int cost = cur[3];

            int ny = (cy + dy[cdir] + rows) % rows;
            int nx = (cx + dx[cdir] + cols) % cols;
            int ndir = cdir;

            char next = grid[ny].charAt(nx);
            if (next == 'L') ndir = (cdir + 1) % 4;
            if (next == 'R') ndir = (cdir + 3) % 4;

            if (ny == y && nx == x && ndir == dir) {
                return cost + 1;
            }

            if (visited[ny][nx][ndir]) continue;

            dq.addLast(new int[]{ny, nx, ndir, cost + 1});
            visited[ny][nx][ndir] = true;
        }

        return 0;
    }
}