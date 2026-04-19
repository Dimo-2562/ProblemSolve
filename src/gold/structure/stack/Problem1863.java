package gold.structure.stack;

import java.io.*;
import java.util.*;

/*
건물은 모두 직사각형
스카이라인만 보고서 건물이 최소 몇 채인지 알아내라.

<입력>
n
- n: 주어지는 스카라인의 개수 (1 ~ 10^4)
x, y
- x (1 ~ 10^6)
- y (0 ~ 10^5)

<출력>
최소 건물 개수를 출력하라.

<풀이>
지금 스택의 높이보다 높으면 넣기.
낮으면? 스택에 있는 걸 빼면서 answer++
0은 건물이 아니므로 넣지 않기.


 */

public class Problem1863 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int answer = 0;
        Deque<Integer> dq = new ArrayDeque<>();

        while (n-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            st.nextToken();
            int y = Integer.parseInt(st.nextToken());

            while (!dq.isEmpty() && dq.peekLast() > y) {
                dq.pollLast();
                answer++;
            }

            if (y == 0) continue;

            if (dq.isEmpty() || dq.peekLast() < y) dq.addLast(y);
        }

        answer += dq.size();

        System.out.print(answer);
    }
}
