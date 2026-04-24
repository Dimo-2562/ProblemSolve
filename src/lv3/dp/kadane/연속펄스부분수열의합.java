package lv3.dp.kadane;

import java.util.*;

/*
연속 부분 수열에 같은 길이의 펄스 수열을 곱하여 연속 펄스 부분 수열
펄스 부분 수열의 합 중 가장 큰 것을 return 하라

<입력>
sequence
- sequence: 연속 부분 수열 (1 ~ 10^5)
- 원소 (-10^5 ~ 10^5)

<출력>
펄스 부분 수열의 합 중 가장 큰 것

<풀이>
10^10 => long을 sum으로 사용.

단조성이 없으므로 투포인터 X
카데인 알고리즘 (기존 거를 가져갈지, 새로 시작할지)

두 가지 경우 모두 해서 max 때리기

*/

class 연속펄스부분수열의합 {
    public long solution(int[] sequence) {

        long max = 0;

        long[] dpA = new long[sequence.length + 1];
        long[] dpB = new long[sequence.length + 1];

        for (int i = 1; i <= sequence.length; i++) {
            long numA = i % 2 == 0 ? sequence[i - 1] : (-1) * sequence[i - 1];
            dpA[i] = Math.max(dpA[i - 1] + numA, numA);

            long numB = i % 2 == 1 ? sequence[i - 1] : (-1) * sequence[i - 1];
            dpB[i] = Math.max(dpB[i - 1] + numB, numB);

            max = Math.max(dpA[i], max);
            max = Math.max(dpB[i], max);
        }

        return max;
    }
}
