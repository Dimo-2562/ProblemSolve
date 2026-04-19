package silver.structure.priorityqueue;

import java.io.*;
import java.util.*;

/*
야근 피로도 = 야근을 시작한 시점에서 남은 일의 작업량을 제곱하여 더한 값
N시간 동안 야근 피로도를 최소화
1시간 동안 작업량 1만큼을 처리 가능

<입력>
N, 각 일에 대한 작업량 works가 주어짐.
- N : 퇴근까지 남은 시간 (1 ~ 10^6)
- works (1 ~ 10^4)
- 각 원소 (1 ~ 10^4)

<출력>
야근 피로도를 최소화한 값을 리턴

<풀이>
제곱이 가능하므로 일단 long.
works 배열의 원소들의 값을 n만큼 줄일 수 있음.

우선순위 큐 -> n만큼 반복 10^6
*/

class 야근지수 {
    public long solution(int n, int[] works) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> o2 - o1);
        for (int i = 0; i < works.length; i++) {
            pq.add(works[i]);
        }

        while (n-- > 0) {
            int cur = pq.poll();
            pq.add(cur-1);
        }

        long sum = 0;
        for (int num : pq) {
            if (num < 0) return 0;

            sum += (num * num);
        }

        return sum;
    }
}