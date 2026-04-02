package gold.structure.stack;

import java.io.*;
import java.util.*;

/*
크기가 N인 수열 A
오큰수: 오른쪽에 있으면서 Ai보다 큰 수 중에서 가장 왼쪽에 있는 수.
그러한 수가 없다면 오큰수는 -1

<입력>
N
- N: 수열 A의 크기 (1 ~ 10^6)
수열 A의 원소 (1 ~ 10^6)

<출력>
N개의 오큰 수를 공백으로 구분해서 출력.

단조 감소 수열
3
 */

public class Problem17298 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] answer = new int[N];
        Arrays.fill(answer, -1);

        Deque <int[]> dq = new ArrayDeque<>();
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(st.nextToken());

            while (!dq.isEmpty() && dq.peekLast()[0] < num) {
                int[] tmp = dq.pollLast();
                answer[tmp[1]] = num;
            }

            dq.addLast(new int[]{num, i});
        }

        StringBuilder sb = new StringBuilder();
        for (int tmp : answer) {
            sb.append(tmp).append(' ');
        }
        System.out.print(sb);
    }
}
