package later;

import java.util.*;

/*
연속된 자연수들로 n을 표현하는 방법의 수를 return 하라

<입력>
n
- n: 표현하고자 하는 숫자 (1 ~ 10^4)

<출력>
방법의 수

<풀이>
누적합 -> 2중 for문 아닌가..?
슬라이딩 윈도우

*/

class 숫자의표현Later {
    public int solution(int n) {
        int answer = 0;

        int start = 1;
        int end = 1;
        int sum = 0;

        while (start <= n) {
            if (sum == n) {
                answer++;
                sum -= start++;
            } else if (sum < n) {
                sum += end++;
            } else {
                sum -= start++;
            }
        }

        return answer;
    }
}