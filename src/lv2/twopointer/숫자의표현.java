package lv2.twopointer;

import java.util.*;

/*
n을 연속한 자연수들로 표현하는 방법

<입력>
n
- n: 자연수

<출력>
연속된 자연수들로 n을 표현하는 방법의 수

<풀이>
연속된 수 -> 투포인터 O(n)


*/

class 숫자의표현 {
    public int solution(int n) {

        int left = 1;
        int right = 1;
        int sum = 0;
        int answer = 0;

        while (left <= n) {
            if (sum < n) {
                sum += right;
                right++;
            } else if (sum == n) {
                answer++;
                sum -= left;
                left++;
            } else {
                sum -= left;
                left++;
            }
        }

        return answer;
    }
}