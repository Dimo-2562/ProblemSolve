package gold.prefix;

import java.io.*;
import java.util.*;

/*
M * N 크기의 보드
K * K 체스판으로 만들려고 함.

검은색, 흰색이 번갈아 나오도록
경우의 수는 2가지.

지민이가 체스판을 만들기 위해 다시 칠해야 하는 정사각형의 최소 개수를 구하라.

<입력>
N, M, K
- N: 세로 (1 ~ 10^3)
- M: 가로 (1 ~ 10^3)
- K: 체스판의 한 변의 길이

<출력>
K*K보드가 체스판이 되기 위해 칠해야하는 정사각형의 최소 개수.

<풀이>
다른 경우를 1로 체크.
총 몇 개가 다른지를 누적합으로 체크.
 */

public class Problem25682 {
    static char[][] map;
    static char[][] blackMap, whiteMap;
    static int[][] blackDiffMap, whiteDiffMap;
    static int[][] blackSumMap, whiteSumMap;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        map = new char[n + 1][m + 1];
        blackMap = new char[n + 1][m + 1]; whiteMap = new char[n + 1][m + 1];
        blackDiffMap = new int[n + 1][m + 1]; whiteDiffMap = new int[n + 1][m + 1];
        blackSumMap = new int[n + 1][m + 1]; whiteSumMap = new int[n + 1][m + 1];

        for (int i = 1; i <= n; i++) {
            String str = br.readLine();
            for (int j = 1; j <= m; j++) {
                map[i][j] = str.charAt(j - 1);
            }
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                blackMap[i][j] = (i + j) % 2 == 0 ? 'B' : 'W';
                whiteMap[i][j] = (i + j) % 2 == 0 ? 'W' : 'B';
            }
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (map[i][j] != blackMap[i][j]) blackDiffMap[i][j] = 1;
                if (map[i][j] != whiteMap[i][j]) whiteDiffMap[i][j] = 1;
            }
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                blackSumMap[i][j] = blackDiffMap[i][j] + blackSumMap[i][j - 1] + blackSumMap[i - 1][j] - blackSumMap[i - 1][j - 1];
                whiteSumMap[i][j] = whiteDiffMap[i][j] + whiteSumMap[i][j - 1] + whiteSumMap[i - 1][j] - whiteSumMap[i - 1][j - 1];
            }
        }

        int answer = Integer.MAX_VALUE;
        for (int i = k; i <= n; i++) {
            for (int j = k; j <= m; j++) {
                int sumBlack = blackSumMap[i][j] - blackSumMap[i - k][j] - blackSumMap[i][j - k] + blackSumMap[i - k][j - k];
                int sumWhite = whiteSumMap[i][j] - whiteSumMap[i - k][j] - whiteSumMap[i][j - k] + whiteSumMap[i - k][j - k];
                answer = Math.min(answer, sumBlack);
                answer = Math.min(answer, sumWhite);
            }
        }

        System.out.print(answer);
    }
}
