package lv3.binarysearch.parametricsearch;

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
파라미터 서치
*/

class 징검다리건너기 {
    public int solution(int[] stones, int k) {
        int lo = 1;
        int hi = 200_000_000;
        int answer = 0;

        while (lo <= hi) {
            int mid = (lo + hi) / 2;

            if (possible(stones, k, mid)) {
                answer = mid;
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }

        return answer;
    }

    boolean possible(int[] stones, int k, int person) {
        int cnt = 0;

        for (int stone: stones) {
            if (stone < person) {
                cnt++;

                if (cnt >= k) return false;
            } else {
                cnt = 0;
            }
        }

        return true;
    }
}
