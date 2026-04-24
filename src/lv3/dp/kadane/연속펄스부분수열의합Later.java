package lv3.dp.kadane;

/*
연속 부분 서열에 같은 길이의 펄스 수열을 각 원소끼리 곱하여 연속 펄스 부분 수열을 만들려고 함.

연속 펄스 부분 수열의 합 중 가장 큰 것을 return하라.

<입력>
sequence
- sequence: 수열 (1 ~ 10^5)
- 원소 (-10^5 ~ 10^5)

<출력>
연속 펄스 부분 수열의 합 중 가장 큰 것

<풀이>
투포인터
두 가지 펄스 수열의 경우를 각자 가지고 있기.

포인터를 어떻게 움직여야 할까?

-> 풀이 봄 (카데인 알고리즘)
*/

class 연속펄스부분수열의합Later {
    public long solution(int[] sequence) {
        int n = sequence.length;

        long[] arr1 = new long[n + 1];
        long[] arr2 = new long[n + 1];

        long max = Integer.MIN_VALUE;

        for (int i = 1; i <= n; i++) {
            long cur1 = i % 2 == 0 ? sequence[i - 1] : -1 * sequence[i - 1];
            long cur2 = i % 2 == 0 ? -1 * sequence[i - 1] : sequence[i - 1];

            arr1[i] = Math.max(arr1[i - 1] + cur1, cur1);
            arr2[i] = Math.max(arr2[i - 1] + cur2, cur2);

            max = Math.max(max, arr1[i]);
            max = Math.max(max, arr2[i]);
        }

        return max;
    }
}