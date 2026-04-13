package silver.bruteforce;

import java.io.*;
import java.util.*;

/*
M*N 크기의 보드
검은색 or 흰색
체스판은 검은색과 흰색이 번갈아서 칠해져야 함.
맨 왼쪽 위가 흰색 or 검은색 2가지 경우밖에 없음.

특정 부분을 8*8로 잘라서 새로 칠해야 하는 정사각형의 최솟값을 출력하라.

<입력>
N, M
- N: 세로 (8 ~ 50)
- M: 가로 (8 ~ 50)
체스판

<출력>
다시 칠해야 하는 정사각형 개수의 최솟값

<풀이>
2가지 경우 -> 미리 그려놓고 비교하기.
1. 브루트포스로 전부 잘라보기
2. 자른 경우에 2가지 비교

 */

public class Problem1018 {
    static String[] mapBlack = {
            "BWBWBWBW",
            "WBWBWBWB",
            "BWBWBWBW",
            "WBWBWBWB",
            "BWBWBWBW",
            "WBWBWBWB",
            "BWBWBWBW",
            "WBWBWBWB",
    };
    static String[] mapWhite = {
            "WBWBWBWB",
            "BWBWBWBW",
            "WBWBWBWB",
            "BWBWBWBW",
            "WBWBWBWB",
            "BWBWBWBW",
            "WBWBWBWB",
            "BWBWBWBW"
    };
    static char[][] map;
    static int n, m;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new char[n][m];

        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            for (int j = 0; j < m; j++) {
                map[i][j] = str.charAt(j);
            }
        }

        int min = Integer.MAX_VALUE;
        for (int i = 0; i + 8 <= n; i++) {
            for (int j = 0; j + 8 <= m; j++) {
                char[][] part = draw(map, i, j);
                min = Math.min(diff(part, mapBlack), min);
                min = Math.min(diff(part, mapWhite), min);
            }
        }

        System.out.print(min);
    }

    static char[][] draw(char[][] map, int startY, int startX) {
        char[][] tmp = new char[8][8];
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                tmp[i][j] = map[i + startY][j + startX];
            }
        }
        return tmp;
    }

    static int diff(char[][] a, String[] b) {
        int cnt = 0;
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (a[i][j] != b[i].charAt(j)) cnt++;
            }
        }
        return cnt;
    }
}
