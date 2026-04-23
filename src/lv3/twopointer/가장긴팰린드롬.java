package later;

import java.util.*;

/*
앞뒤를 뒤집어도 똑같은 문자열을 팰린드롬이라고 한다.
s가 주어질 때 부분문자열 중 가장 긴 팰린드롬의 길이를 return하라.

<입력>
s
- s: 주어지는 문자열 (1 ~ 10^3)
- 알파벳 소문자로만 구성

<출력>
s의 부분문자열 중 가장 긴 팰린드롬의 길이

<풀이>
for문 돌면서 하나 기준점 잡고 투포인터로 체크하기?
10^6
*/

class 가장긴팰린드롬Later {
    public int solution(String s) {
        int answer = 1;

        int len = s.length();
        for (int i = 0; i < len; i++) {
            answer = Math.max(answer, solve(s, i, i));
            answer = Math.max(answer, solve(s, i, i + 1));
        }

        return answer;
    }

    int solve(String s, int left, int right) {
        while (left >= 0 && right < s.length()) {
            if (s.charAt(left) != s.charAt(right)) break;
            right++;
            left--;
        }

        return right - left - 1;
    }
}