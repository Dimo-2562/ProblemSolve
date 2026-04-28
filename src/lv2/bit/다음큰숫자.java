package lv2.bit;

import java.util.*;

/*
n이 주어졌을 때, n의 다음 큰 숫자는 다음과 같이 정의한다.
n보다 큰 자연수
이진수로 변환했을 때 1의 갯수가 같다.
1, 2를 만족하는 수 중 가장 작은 수

<입력>
n
- n: 자연수 (1 ~ 10^6)

<출력>
n의 다음 큰 숫자

<풀이>
비트마스킹
*/

class 다음큰숫자 {
    public int solution(int n) {

        int tmp = n;
        int c0 = 0, c1 = 0;
        while (tmp > 0 && (tmp & 1) == 0) {
            c0++;
            tmp >>= 1;
        }

        while (tmp > 0 && (tmp & 1) == 1) {
            c1++;
            tmp >>= 1;
        }

        int sum = c0 + c1;
        n &= ~((1 << sum) - 1);
        n |= 1 << sum;
        n |= (1 << (c1 - 1)) - 1;

        return n;
    }
}