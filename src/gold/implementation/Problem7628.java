package gold.implementation;

import java.io.*;

/*
3*3 격자판
처음에는 비어 있음.
X -> O, 번갈아서
가로, 세로, 대각선 중 3칸을 잇는 데 성공하면 게임 종료.
게임판이 가득차도 게임 종료

게임판의 상태가 주어질 때 틱택토 게임에서 발생할 수 있는 '최종 상태'인지 판별하라.

<입력>
여러 개의 테스트 케이스
1게임
- X
- O
- .: 빈 칸
end가 주어지면 종료.

<출력>
valid or invalid (한 줄마다 출력)

<풀이>
발생할 수 있는 최종 상태가 아닌 조건
1. 개수가 안 맞음
- X가 하나가 더 많거나 같아야함
2. 둘 다 승리조건 충족
3. 게임이 종료되지 않음.

.XX
X.X
OOO
 */

public class Problem7628 {
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

            // 1. 개수 체크
            if (!numCheck(numX, numO)) {
                sb.append("invalid").append('\n');
                continue;
            }

            // 2. 둘 다 승리했는지 체크
            if (isWin(map, 'O') && isWin(map, 'X')) {
                sb.append("invalid").append('\n');
                continue;
            }

            // 3. O가 이겼는데 개수가 많을 때 체크
            if (isWin(map, 'O') && numX > numO) {
                sb.append("invalid").append('\n');
                continue;
            }

            if (isWin(map, 'X') && numX == numO) {
                sb.append("invalid").append('\n');
                continue;
            }

            // 4. 게임이 종료되었는지 체크
            if (numX + numO == 9 || isWin(map, 'O') || isWin(map, 'X')) {
                sb.append("valid").append('\n');
            } else {
                sb.append("invalid").append('\n');
            }
        }

        System.out.print(sb);
    }

    static boolean numCheck(int numX, int numO) {
        if (numX == numO || numX == numO + 1) {
            return true;
        }
        return false;
    }

    static boolean isWin(char[][] map, char c) {
        boolean isWin = false;

        // 가로
        for (int i = 0; i < 3; i++) {
            int cnt = 0;
            for (int j = 0; j < 3; j++) {
                if (map[i][j] == c) cnt++;
            }
            if (cnt == 3) isWin = true;
        }
        // 세로
        for (int i = 0; i < 3; i++) {
            int cnt = 0;
            for (int j = 0; j < 3; j++) {
                if (map[j][i] == c) cnt++;
            }
            if (cnt == 3) isWin = true;
        }
        // 대각선
        if (map[0][0] == c && map[1][1] == c && map[2][2] == c) isWin = true;
        if (map[0][2] == c && map[1][1] == c && map[2][0] == c) isWin = true;

        return isWin;
    }
}
