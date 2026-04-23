package lv3.math;

/*
자연수 n개로 이루어진 중복 허용 집합(multiset) 중 두 조건을 만족하면 최고의 집합
1. 각 원소의 합이 S
2. 각 원소의 곱이 최대가 되는 집합

<입력>
n, s
- n: 집합의 원소의 개수 (1 ~ 10^4)
- s: 모든 원소들의 합 (1 ~ 10^8)

<출력>
최고의 집합
- 오름차순 정렬
- 1차원 배열
- 존재하지 않을 경우에 크기가 1인 1차원 배열에 -1 즉 answer[0] = -1로 반환

<풀이>
집합의 크기가 2이면 쉬운데...  n인 상황.
완탐으론 못 푼다.

풀이 봄 -> 수학 문제.
최대한 균등할수록 좋다.
s를 n으로 나누기...

*/

class 최고의집합Later {
    public int[] solution(int n, int s) {

        if (n > s) return new int[] {-1};

        int[] answer = new int[n];

        int num = s / n;
        int r = s % n;
        for (int i = 0; i < n - r; i++) {
            answer[i] = num;
        }
        for (int i = n - r; i < n; i++) {
            answer[i] = num + 1;
        }

        return answer;
    }
}