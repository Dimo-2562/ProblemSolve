package gold.simulation;

import java.io.*;
import java.util.*;

/*
i번 칸의 내구도는 Ai
1번 칸의 위치를 올리는 위치
N번 칸이 있는 위치를 내리는 위치

로봇은 올리는 위치에만 올릴 수 있다.
내리는 위치에 도달하면 그 즉시 내린다.

로봇
- 스스로 이동 가능
- 올리는 위치에 올리거나 어떤 칸으로 이동 시 내구도는 즉시 1만큼 감소

1. 벨트가 각 칸위에 있는 로봇과 함께 한 칸 회전
2. 가장 먼저 올라간 로봇부터, 회전하는 방향으로 이동할 수 있다면 이동
-> 이동하려는 칸에 로봇이 없고, 내구도 1이상 남아있어야 함.
3. 올리는 칸의 내구도가 0이 아니면 로봇을 올린다.
4. 내구도가 0인 칸의 개수가 k개 이상이라면 과정 종료.

<입력>
N, K
- N: 벨트 한 줄의 길이 (1 ~ 10^2)
- K: 종료 조건 (1 ~ 10^2)
각 칸의 내구도
- 1 ~ 10^3

<출력>
몇 번째 단계가 진행중일 때 종료되었는지 출력

브루트포스
 */

public class Problem20055 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] belt = new int[n * 2 + 1];
        boolean[] robot = new boolean[n * 2 + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= 2 * n; i++) {
            belt[i] = Integer.parseInt(st.nextToken());
        }

        int round = 0;
        while (true) {
            round++;

            // 1. 벨트가 로봇과 함께 이동
            belt[0] = belt[2 * n];
            robot[0] = false;
            for (int i = 2 * n; i >= 1; i--) {
                belt[i] = belt[i - 1];
                robot[i] = robot[i - 1];
            }

            // 1-1. 로봇이 N에 도착하면 내리기.
            if (robot[n]) robot[n] = false;

            // 2. 로봇의 이동
            for (int i = n - 1; i >= 1; i--) {
                if (belt[i + 1] >= 1 && robot[i + 1] == false && robot[i]) {
                    belt[i + 1]--;
                    robot[i + 1] = true;
                    robot[i] = false;
                }
            }

            // 2-1. 로봇이 N에 도착하면 내리기.
            if (robot[n]) robot[n] = false;

            // 3. 올리는 칸의 내구도가 0이 아니면 로봇을 올린다.
            if (belt[1] != 0) {
                belt[1]--;
                robot[1] = true;
            }

            // 4. 종료 조건 체크
            int cnt = 0;
            for (int i = 1; i <= 2 * n; i++) {
                if (belt[i] == 0) cnt++;
            }
            if (cnt >= k) break;
        }

        System.out.print(round);
    }
}
