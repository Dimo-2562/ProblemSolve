package gold.greedy;

import java.io.*;
import java.util.*;

/*
N개의 문제 -> 데드라인 + 보상
받을 수 있는 최대 보상을 구하라.
문제 푸는데 걸리는 시간: 1
데드라인은 N이하의 자연수
각 문제를 풀 때 받는 보상과 최대 보상 모두 int형 범위 내이다.

<입력>
N
- N: 숙제의 개수 (1 ~ 10^5)
데드라인, 컵라면

<출력>
받을 수 있는 최대 컵라면 수를 출력하라.

역순
데드라인 순으로 정렬
컵라면 수를 기준으로 PQ 하나 (역순, 최댓값).
 */

public class Problem1781 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        List<int[]> list = new ArrayList<>();
        while (n-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int day = Integer.parseInt(st.nextToken());
            int reward = Integer.parseInt(st.nextToken());
            list.add(new int[] {day, reward});
        }

        list.sort((o1, o2) -> Integer.compare(o2[0], o1[0]));

        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> Integer.compare(o2[1], o1[1]));
        int day = list.get(0)[0];

        int answer = 0;
        int idx = 0;
        while (day > 0){

            // 가능한 문제를 모두 넣기.
            while (idx < list.size() && list.get(idx)[0] >= day) {
                pq.add(new int[]{list.get(idx)[0], list.get(idx)[1]});
                idx++;
            }

            // 한 문제 풀기.
            if (!pq.isEmpty()) answer += pq.poll()[1];

            // 하루 줄이기.
            day--;
        }

        System.out.print(answer);
    }
}
