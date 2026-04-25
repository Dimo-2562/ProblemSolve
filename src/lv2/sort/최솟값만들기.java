package lv2.sort;

import java.util.*;

/*
배열 A, B
원소는 자연수로 구성
각각 한 개를 뽑아 두 수를 곱한다.
배열의 길이만큼 반복, 두 수를 곱한 값을 누적하여 더한다.
누적된 값이 최소가 되도록.
오름차순 내림차순

<입력>
A, B
- A, B: 숫자 배열 (1 ~ 10^3)
- 원소 (1 ~ 10^3)

<출력>

<풀이>
int로 커버 가능.
*/

class 최솟값만들기 {
    public int solution(int []A, int []B) {
        List<Integer> listA = new ArrayList<>();
        List<Integer> listB = new ArrayList<>();

        for (int i = 0; i < A.length; i++) {
            listA.add(A[i]);
            listB.add(B[i]);
        }

        listA.sort((o1, o2) -> o1 - o2);
        listB.sort((o1, o2) -> o2 - o1);

        int answer = 0;
        for (int i = 0; i < A.length; i++) {
            int mul = listA.get(i) * listB.get(i);
            answer += mul;
        }

        return answer;
    }
}