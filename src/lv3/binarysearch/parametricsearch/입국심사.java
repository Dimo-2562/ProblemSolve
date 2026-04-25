package lv3.binarysearch.parametricsearch;

import java.io.*;

/*
n명이 입국심사
입국심사대에 있는 심사관마다 심사하는데 걸리는 시간이 다르다.
처음에 모든 심사대는 비어있다.
한 심사대는 동시에 한 명만 심사 가능
가장 앞에 있는 사람은 비어있는 심사대로 가서 심사를 받을 수 있다.
하지만, 기다렸다가 더 빨리 끝나는 곳으로 가서 심사를 받을 수도 있다.

모든 사람이 심사를 받는데 걸리는 시간을 최소로

<입력>
n
- n: 입국심사를 기다리는 사람 수 (1 ~ 10^9)
times
- times: 각 심사관이 한 명을 심사하는데 걸리는 시간 (1 ~ 10^5)
- 원소 (1 ~ 10^9)

<출력>
모든 사람이 심사를 받는데 걸리는 시간의 최소값

<풀이>
long형
파라미터 서치 -> 시간을 정해놓고 / times[i]의 합이 n이상이 되는가.

*/

class 입국심사 {
    final long INF = 1_000_000_000;

    public long solution(int n, int[] times) {
        long lo = 1;
        long hi = INF * (long) n + 1;
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