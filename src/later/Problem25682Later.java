package later;

import java.io.*;
import java.util.*;

/*
M * N
색칠 - B or W
경우의 수는 두 가지

K * K로 만들 예정.
다시 칠해야 하는 정사각형의 최소 개수를 구하라.

<입력>
N, M, K
- N: 세로 (1 ~ 10^3)
- M: 가로 (1 ~ 10^3)
- K: 자를 도형의 한 변의 길이 (1 ~ 10^3)
각 변 (N개의 줄)
- B or W

<출력>
K * K가 체스판이 되기 위해 칠해야 하는 정사각형 개수의 최솟값.

<풀이>
브루트포스?
K * K 도형 만드는 비용 N^2
부분 보드 만드는 비용 N^2
N^4 -> 실패.

K * K 대하여 N^2 비용은 어쩔 수 없음.
그럼 부분 보드를 계산할 때 비용을 O(1)로 만들자. -> 누적합
 */

public class Problem25682Later {
    static char[][] originMap;
    static char[][] blackMap, whiteMap;
    static int[][] diffBlack, diffWhite;
    static int[][] sumBlack, sumWhite;
    static int n, m, k;
    static int answer = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        // 입력 받기.
        originMap = new char[n + 1][m + 1];
        for (int i = 1; i <= n; i++) {
            String s = br.readLine();
            for (int j = 1; j <= m; j++) {
                originMap[i][j] = s.charAt(j - 1);
            }
        }

        init();

        diffBlack = calculate(blackMap, originMap);
        diffWhite = calculate(whiteMap, originMap);

        sumBlack = sumMap(diffBlack);
        sumWhite = sumMap(diffWhite);

        solve(sumBlack);
        solve(sumWhite);

        System.out.print(answer);
    }

    static void init() {
        blackMap = new char[n + 1][m + 1];
        whiteMap = new char[n + 1][m + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                blackMap[i][j] = (i + j) % 2 == 0 ? 'B' : 'W';
                whiteMap[i][j] = (i + j) % 2 == 0 ? 'W' : 'B';
            }
        }
    }

    static int[][] calculate(char[][] map, char[][] ori) {
        int[][] tmp = new int[n + 1][m + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                tmp[i][j] = map[i][j] == ori[i][j] ? 0 : 1;
            }
        }

        return tmp;
    }

    static int[][] sumMap(int[][] map) {
        int[][] tmp = new int[n + 1][m + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                tmp[i][j] = map[i][j] + tmp[i - 1][j] + tmp[i][j - 1] - tmp[i - 1][j - 1];
            }
        }
        return tmp;
    }

    static void solve(int[][] sum) {
        int tmp = Integer.MAX_VALUE;
        for (int i = k; i <= n; i++) {
            for (int j = k; j <= m; j++) {
                tmp = Math.min(sum[i][j] - sum[i - k][j] - sum[i][j - k] + sum[i - k][j - k], tmp);
            }
        }
        answer = Math.min(tmp, answer);
    }
}