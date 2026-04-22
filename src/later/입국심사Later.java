package later;

import java.io.*;
import java.util.*;

/*
n명이 입국심사를 위해 줄을 서서 기다리고 있음.
각 심사관마다 걸리는 시간은 다르다.

모든 심사대는 처음에 비어있다.
한 심사대는 동시에 한 명만 심사 가능.
가장 앞에 서 있는 사람은 비어있는 곳으로 가서 심사를 받을 수도 있지만,
더 빨리 끝나는 심사대가 있다면 기다렸다가 그곳으로 갈 수도 있다.

모든 사람이 심사를 받는데 걸리는 시간을 최소로 하고 싶다.

<입력>
n
- n: 입국 심사를 기다리는 사람 수 (1 ~ 10^9)
times
- times: 한 명을 심사하는데 걸리는 시간 배열 (1 ~ 10^5)
- 값 (1 ~ 10^9)

<출력>
모든 사람이 심사를 받는데 걸리는 시간의 최솟값.

<풀이>
시간 관련 자료형은 long으로

사람 수가 10^9 -> O(NlogN 이하)

시간을 0 ~ long 끝까지 중 하나 잡고
이 시간으로 times 배열 돌면서 나누기
값이 n 이상이면 OK.
*/

class 입국심사Later {
    public long solution(int n, int[] times) {
        long lo = 0;
        long hi = Long.MAX_VALUE;

        long answer = 0;
        while (lo <= hi) {
            long mid = lo + (hi - lo) / 2;

            long sum = 0;
            for (int i = 0; i < times.length; i++) {
                sum += mid / (long) times[i];
                if (sum >= n) break;
            }

            if (sum >= n) {
                answer = mid;
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }

        return answer;
    }
}