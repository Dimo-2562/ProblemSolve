package later;

import java.io.*;
import java.util.*;

/*
N개의 문제
데드라인 + 컵라면
최대 컵라면 수를 구하라.
한 문제를 푸는데는 단위 시간 1이 걸리며, 데드라인은 N이하의 자연수.

<입력>
N
- N: 숙제의 개수 (1 ~ 10^5)
데드라인 및 컵라면 (N개의 줄)
- 데드라인 및 컵라면 (1 ~ 2^31)

long 자료형
데드라인 기준으로 내림차순 정렬.
 */

public class Problem1781Later {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        List<int[]> problemList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int deadline = Integer.parseInt(st.nextToken());
            int reward = Integer.parseInt(st.nextToken());
            problemList.add(new int[] {deadline, reward});
        }

        problemList.sort((o1, o2) -> o2[0] - o1[0]);

        long answer = 0;
        int idx = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        int maxTime = problemList.get(0)[0];

        for (int i = maxTime; i > 0; i--) {
            while (idx < n && problemList.get(idx)[0] >= i) {
                pq.add(problemList.get(idx)[1]);
                idx++;
            }

            if (!pq.isEmpty()) answer += pq.poll();
        }

        System.out.print(answer);
    }
}
