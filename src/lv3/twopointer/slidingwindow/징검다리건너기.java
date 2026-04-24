package lv3.twopointer.slidingwindow;

import java.util.*;

/*
징검다리는 일렬, 디딤돌에는 모두 숫자가 적혀있다.
디딤돌은 한 번 밟을 때마다 1씩 줄어든다.
디딤돌의 숫자가 0이 되면 더 이상 밟을 수 없으며 이때는 그 다음 디딤돌로 여러 칸을 뛸 수 있다

<입력>
stones
- stones: 디딤돌에 적힌 숫자 (1 ~ 10^5)
- 원소 (1 ~ 10^8)
k
- k: 한 번에 건너뛸 수 있는 디딤돌의 최대 칸수 (1 ~ 10^5)

<출력>
몇 명까지 징검다리를 건널 수 있는가

<풀이>
k 길이의 구간의 최댓값 중 최솟값.

단조 감소 수열 (인덱스를 넣기)

2
4
5
5 3
5 3 2
3 2 1
4
4 2
5
5 1
*/

class 징검다리건너기 {
    public int solution(int[] stones, int k) {

        Deque <Integer> dq = new ArrayDeque<>();

        int min = Integer.MAX_VALUE;
        for (int i = 0; i < stones.length; i++) {
            // 그 길이를 넘으면 빼기
            while (!dq.isEmpty() && dq.peekFirst() <= i - k) {
                dq.pollFirst();
            }

            // 단조 감소 수열 만들기
            while (!dq.isEmpty() && stones[dq.peekLast()] < stones[i]) {
                dq.pollLast();
            }

            dq.addLast(i);

            if (i >= k - 1) {
                min = Math.min(min, stones[dq.peekFirst()]);
            }
        }

        return min;
    }
}