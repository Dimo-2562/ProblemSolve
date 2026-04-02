package gold.bfs;

import java.io.*;
import java.util.*;

/*
정육면체 주사위 (1 ~ 6)
게임판: 10 * 10 (1 ~ 100)

주사위를 굴려 나온 수만큼 이동
100번칸을 넘어간다면 이동불가.
사다리에 도착한다면 사다리를 타고 올라간다.
뱀에 도착한다면 뱀을 따라서 내려가게 된다.

1번 칸에서 시작하여 100번 칸에 도착.
100번 칸에 도착하기 위해 주사위를 굴려야하는 횟수의 최솟값을 구하라.

<입력>
N, M
- N: 사다리의 수 (1 ~ 15)
- M: 뱀의 수 (1 ~ 15)
x, y (N개 줄)
- 사다리 정보: x번 칸에 도착하면 y번 칸으로 이동
u, v (M개 줄)
- 뱀의 정보: u번 칸에 도착하면 v번 칸으로 이동

<출력>
100번 칸에 도착하기 위해 주사위를 최소 몇 번 굴려야 하는가?

1번 칸에서 시작해서 (도착, 횟수)
 */

public class Problem16928 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] moving = new int[101];
        boolean[] visited = new boolean[101];

        for (int i = 0; i < n+m; i++) {
            st = new StringTokenizer(br.readLine());
            int first = Integer.parseInt(st.nextToken());
            int second = Integer.parseInt(st.nextToken());
            moving[first] = second;
        }

        Deque<int[]> dq = new ArrayDeque<>();
        visited[1] = true;
        dq.add(new int[]{1, 0});

        int answer = 0;
        while (!dq.isEmpty()) {
            int[] cur = dq.pollFirst();
            int curPos = cur[0];
            int curCost = cur[1];

            if (curPos == 100) {
                answer = Math.max(curCost, answer);
                continue;
            }

            for (int i = 1; i <= 6; i++) {
                int nextPos = curPos + i;
                if (nextPos > 100) break;

                if (moving[nextPos] != 0) nextPos = moving[nextPos];

                if (!visited[nextPos]) {
                    visited[nextPos] = true;
                    dq.addLast(new int[]{nextPos, curCost + 1});
                }

            }
        }

        System.out.print(answer);
    }
}
