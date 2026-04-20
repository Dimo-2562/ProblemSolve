package lv3.binarysearch;

import java.io.*;
import java.util.*;

/*
2N명의 사원들이 N명씩 팀을 나눠 숫자 게임
- 모든 사원이 무작위로 자연수를 하나씩 부여 받음
- 각 사원은 딱 한 번씩 경기
- 숫자가 큰 쪽이 승리
- 숫자가 같다면 승점 X

A팀이 자연수 순서를 공개했을 때, B팀의 승점이 최대가 되도록.

<입력>
int[] A, int[] B
- A는 출전 순서가 정해짐. 즉 임의로 해도 괜찮음
- B는 A에 맞게
- 길이 (1 ~ 10^5)
- 값 (1 ~ 10^9)

<출력>
최대 승점

<풀이>
int 범위
1 3 5 7
2 2 6 8
*/

class 숫자게임 {
    public int solution(int[] A, int[] B) {
        List<Integer> listA = new ArrayList<>();
        List<Integer> listB = new ArrayList<>();

        for (int i = 0; i < A.length; i++) listA.add(A[i]);
        for (int i = 0; i < B.length; i++) listB.add(B[i]);

        listA.sort((o1, o2) -> o1 - o2);
        listB.sort((o1, o2) -> o1 - o2);

        int answer = 0;
        for (int i = listB.size() - 1; i >= 0; i--) {
            int target = listB.get(i);

            int num = lowerbound(target, listA);
            if (num > 0) {
                listA.remove(num - 1);
                answer++;
            }
        }

        return answer;
    }

    static int lowerbound(int target, List<Integer> list) {
        int lo = 0;
        int hi = list.size();

        while (lo < hi) {
            int mid = (lo + hi) / 2;

            if (list.get(mid) >= target) {
                hi = mid;
            } else {
                lo = mid + 1;
            }
        }

        return lo;
    }
}