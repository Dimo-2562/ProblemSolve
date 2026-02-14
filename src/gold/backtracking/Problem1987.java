package gold.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem1987 {

    static int answer = 0;
    static int r, c;
    static char[][] arr = new char[30][30];

    static boolean[] visitedAlphabet = new boolean[26];

    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        for (int i = 0; i < r; i++) {
            arr[i] = br.readLine().toCharArray();
        }

        visitedAlphabet[arr[0][0] - 'A'] = true;
        solve(0, 0, 1);

        System.out.print(answer);
    }

    static void solve(int y, int x, int depth) {
        answer = Math.max(answer, depth);

        for (int i = 0; i < 4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];
            if (ny >= 0 && ny < r && nx >= 0 && nx < c) {
                if (!visitedAlphabet[arr[ny][nx] - 'A']) {
                    visitedAlphabet[arr[ny][nx] - 'A'] = true;
                    solve(ny, nx, depth + 1);
                    visitedAlphabet[arr[ny][nx] - 'A'] = false;
                }
            }
        }
    }
}
