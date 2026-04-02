package later;

import java.io.*;
import java.util.*;

/*
N개의 높이가 서로 다른 탑
꼭대기에 레이저를 왼쪽으로 수평하게 발사.
하나의 탑에서 발사된 레이저 신호는 가장 먼저 만나는 단 하나의 탑에서만 수신이 가능.

각각의 탑에서 발사한 레이저 신호를 어느 탑에서 수신하는지를 알아내시오.

<입력>
N
- N: 탑의 수 (1 ~ 10^5)
탑들의 높이 (1 ~ 10^9) -> int형 범위.

<출력>
레이저를 수신한 탑들의 번호를 빈 칸을 사이에 두고 출력.
(없을경우 0)

끝에서부터 max가 갱신될 때 idx를 하면 되지 않을까? -> 실패.

 */

public class Problem2439Later {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] answer = new int[n+1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        Deque<int[]> dq = new ArrayDeque<>();
        for (int i = 1; i <= n; i++) {
            int h = Integer.parseInt(st.nextToken());

            while (!dq.isEmpty() && dq.peekLast()[0] <= h) {
                dq.pollLast();
            }

            if (!dq.isEmpty()) answer[i] = dq.peekLast()[1];

            dq.addLast(new int[] {h, i});
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            sb.append(answer[i]).append(' ');
        }
        System.out.print(sb);
    }
}
