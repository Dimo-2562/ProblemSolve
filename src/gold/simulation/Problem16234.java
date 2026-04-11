package gold.simulation;

import java.io.*;
import java.util.*;

/*
N*N 크기의 땅
r행 c열에는 A[r][c]명이 거주중.

인구 이동이 없을 때까지 지속.
두 칸 사이의 인구 차: L 이상, R 이하일 때 국경선을 연다.
국경선이 열리면 인구 이동을 시작.
국경선이 열려있어 인접한 칸만을 이용해 이동할 수 있으면, 그 나라를 오늘 하루 동안은 연합.
연합을 이루고 있는 각 칸의 인구수 = 연합의 인구수 / 이루고 있는 칸의 개수 (내림)

<입력>
N, L, R
- N: 땅의 크기 (1 ~ 50)
- L: 국경선이 열리는 최소 차이 (1 ~ 10^2)
- R: 국경선이 열리는 최대 차이 (1 ~ 10^2)
각 나라의 인구수
- 값 (0 ~ 10^2)

<출력>
인구 이동이 며칠 동안 발생하는지 출력하라.

<풀이>
시뮬레이션.
1. visited == false면 특정 지점에서 bfs
2. 차이가 L과 R 사이면 bfs 진행. visited를 true + List에 넣기.
3. List에 있는 것 다 빼서 균등화.
 */

public class Problem16234 {
    static int[] dy = {1, -1, 0, 0};
    static int[] dx = {0, 0, 1, -1};
    static int n, L, R;

    static int[][] map;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        map = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int answer = 0;
        while (true) {
            boolean flag = false;

            visited = new boolean[n + 1][n + 1];
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    if (!visited[i][j]){
                        if(bfs(i, j)) flag = true;
                    }
                }
            }

            if (!flag) break;
            answer++;
        }

        System.out.println(answer);


    }

    static boolean bfs(int startY, int startX) {
        boolean flag = false;

        Deque<int[]> dq = new ArrayDeque<>();
        List<int[]> list = new ArrayList<>();

        dq.addLast(new int[]{startY, startX});
        list.add(new int[]{startY, startX});
        visited[startY][startX] = true;

        while (!dq.isEmpty()) {
            int[] cur = dq.pollFirst();
            int y = cur[0];
            int x = cur[1];

            for (int k = 0; k < 4; k++) {
                int ny = y + dy[k];
                int nx = x + dx[k];

                if (ny < 1 || ny > n || nx < 1 || nx > n) continue;
                if (visited[ny][nx]) continue;

                int diff = Math.abs(map[y][x] - map[ny][nx]);
                if (diff >= L && diff <= R) {
                    visited[ny][nx] = true;
                    dq.addLast(new int[]{ny, nx});
                    list.add(new int[]{ny, nx});
                }
            }
        }

        int sum = 0;
        for (int[] pos : list) {
            int y = pos[0];
            int x = pos[1];
            sum += map[y][x];
        }
        sum /= list.size();

        for (int[] pos : list) {
            int y = pos[0];
            int x = pos[1];
            map[y][x] = sum;
        }

        if (list.size() >= 2) flag = true;
        return flag;
    }
}
