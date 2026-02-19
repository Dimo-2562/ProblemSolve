package gold.bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
백트래킹으로 depth 4

N, M
- N: 세로 크기
- M: 가로 크기

맵(공백으로 주어짐)

놓인 칸에 쓰인 수들의 합의 최댓값
 */

public class Problem14500 {

    static int n, m;

    static int[][] map;
    static boolean[][] visited;
    static int[] selected = new int[5];
    static int max;

    static int[] dy = {1, -1, 0, 0};
    static int[] dx = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                visited[i][j] = true;
                selected[0] = map[i][j];
                backTracking(i, j, 0);
                visited[i][j] = false;
            }
        }

        checkT();

        System.out.println(max);

    }

    static void backTracking(int y, int x, int depth) {
        if (depth == 3) {
            int sum = 0;
            for (int i = 0; i < 4; i++) {
                sum += selected[i];
            }
            max = Math.max(max, sum);
            return;
        }

        for (int i = 0; i < 4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];
            if (ny >= 0 && ny < n && nx >= 0 && nx < m && !visited[ny][nx]) {
                visited[ny][nx] = true;
                selected[depth + 1] = map[ny][nx];
                backTracking(ny, nx, depth + 1);
                visited[ny][nx] = false;
            }
        }
    }

    static void checkT() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                for (int skip = 0; skip < 4; skip++) {
                    int sum = map[i][j];
                    boolean valid = true;
                    for (int d = 0; d < 4; d++) {
                        if (d == skip) continue;
                        int ny = i + dy[d];
                        int nx = j + dx[d];
                        if (ny < 0 || ny >= n || nx < 0 || nx >= m) {
                            valid = false;
                            break;
                        }
                        sum += map[ny][nx];
                    }
                    if (valid) max = Math.max(max, sum);
                }
            }
        }
    }
}
