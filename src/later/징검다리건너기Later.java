package later;

import java.io.*;
import java.util.*;

/*
징검다리 건너기
징검다리는 일렬로 놓여 있고, 각 디딤돌에는 숫자가 적혀 있으며, 밟으면 1씩 줄어듬.
디딤돌의 숫자가 0이 되면 밟을 수 없으며, 건너뛰어야 함.

개울의 왼쪽에서 오른쪽 건녀편으로 가려고 함.
한 번에 한 명씩, 한 친구가 모두 건넌 후 다음 친구가 건넌다.

친구들의 수는 무제한

<입력>
stones
- stones: 디딤돌에 적힌 숫자가 있는 배열 (1 ~ 10^5)
- 원소 (1 ~ 10^8)
k
- k: 한 번에 건너뛸 수 있는 최대 칸 수. (1 ~ 10^5)

<출력>
최대 몇 명까지 징검다리를 건널 수 있는지

<풀이>
브루트포스 -> 10^8 * 10^5 (X)
정렬 X

연속이 핵심...
길이가 k인 구간의 최댓값 중 최솟값.

최댓값을 계속 체크해야 함.
매번 길이 k만큼 체크하면 시간초과

풀이 봄 -> 인덱스를 활용한 단조 Deque
*/

class 징검다리건너기Later {
    public int solution(int[] stones, int k) {

        int answer = Integer.MAX_VALUE;

        Deque<Integer> dq = new ArrayDeque<>();
        for (int i = 0; i < stones.length; i++) {
            while (!dq.isEmpty() && dq.peekFirst() <= i - k) {
                dq.pollFirst();
            }

            while (!dq.isEmpty() && stones[dq.peekLast()] < stones[i]) {
                dq.pollLast();
            }

            dq.addLast(i);

            if (i >= k - 1) {
                answer = Math.min(answer, stones[dq.peekFirst()]);
            }
        }

        return answer;
    }
}