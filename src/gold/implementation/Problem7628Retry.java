package gold.implementation;

import java.io.*;
import java.util.*;

/*
최종 종료 조건 3가지
1. 둘 다 승리 X (X: 5개, O: 4개, 둘 다 승리 X)
2. X 승리 (X = O + 1, X 승리)
3. O 승리 (O = X, O 승리)
 */

public class Problem7628Retry {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();
        while (true) {
            String input = br.readLine();
            if (input.equals("end")) break;

            // 풀이 로직
            char[][] map = new char[3][3];
            int numX = 0, numO = 0;
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    map[i][j] = input.charAt(3 * i + j);
                    if (map[i][j] == 'X') numX++;
                    else if (map[i][j] == 'O') numO++;
                }
            }

            boolean isValid = false;
            boolean oWin = isWin(map, 'O');
            boolean xWin = isWin(map, 'X');

            if (numX == 5 && numO == 4 && !oWin && !xWin) isValid = true;
            else if (numX == numO + 1 && xWin && !oWin) isValid = true;
            else if (numX == numO && !xWin && oWin) isValid = true;

            sb.append(isValid ? "valid" : "invalid").append('\n');
        }

        System.out.print(sb);
    }

    static boolean isWin(char[][] map, char c) {
        boolean isWin = false;

        // 가로, 세로
        for (int i = 0; i < 3; i++) {
            if (map[0][i] == c && map[1][i] == c && map[2][i] == c) isWin = true;
            if (map[i][0] == c && map[i][1] == c && map[i][2] == c) isWin = true;
        }
        // 대각선
        if (map[0][0] == c && map[1][1] == c && map[2][2] == c) isWin = true;
        if (map[0][2] == c && map[1][1] == c && map[2][0] == c) isWin = true;

        return isWin;
    }
}
