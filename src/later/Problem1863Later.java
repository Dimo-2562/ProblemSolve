package later;

import java.io.*;
import java.util.*;

/*
건물들의 윤고가 = 스카이라인
건물은 모두 직사각형 모양.
건물이 최소 몇 채인지 알아내라.

<입력>
n
- n: 들어오는 입력의 개수 (1 ~ 10^4)
x, y
- x: x좌표 (1 ~ 10^6)
- y: y좌표 (0 ~ 10^5)

<출력>
건물의 최소 개수를 출력하라.

<풀이>
바뀌기 전까진 최대한 y가 같아야 한 건물로 가능.

stack 써서 풀기.
기존 것보다 낮아진게 나오면 건물 1개로 취급해야 함.
1 2

answer = 5

1
 */

public class Problem1863Later {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        Deque<Integer> dq = new ArrayDeque<>();
        int answer = 0;

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            st.nextToken();

            int y = Integer.parseInt(st.nextToken());

            while (!dq.isEmpty() && dq.peekLast() > y) {
                dq.pollLast();
                answer++;
            }

            if (y != 0 && (dq.isEmpty() || dq.peekLast() < y)) {
                dq.addLast(y);
            }
        }

        answer += dq.size();

        System.out.print(answer);
    }
}
