package lv3.twopointer;

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
        Arrays.sort(A);
        Arrays.sort(B);

        int answer = 0;
        int a = 0;
        int b = 0;

        while (a < A.length && b < B.length) {
            if (A[a] < B[b]) {
                a++;
                b++;
                answer++;
            } else {
                b++;
            }
        }

        return answer;
    }
}