package lv2.simulation;

import java.util.*;

/*
0과 1로 이루어진 문자열 x
1. x의 모든 0을 제거
2. 길이가 c라고 할 때 c를 2진법으로 표현한 문자열로 변경

<입력>
s
- s: 문자열 (1 ~ 10^5)
- 1이 최소 하나 이상 포함되어 있다.

<출력>


<풀이>
for문 돌면서 1만 넣기.
길이 가지고 while문 돌면서 2로 나누기

s가 1이 될 때까지 계속해서 이진 변환
이진 변환의 횟수와 변환 과정에서 제거된 모든 0의 개수를

*/

class 이진변환반복하기 {
    public int[] solution(String s) {

        int transNum = 0;
        int removeNum = 0;
        while (!s.equals("1")) {
            int len = s.length();

            int cnt = 0;
            for (int i = 0; i < len; i++) {
                if (s.charAt(i) == '1') cnt++;
                else removeNum++;
            }

            StringBuilder sb = new StringBuilder();
            while (cnt > 0) {
                sb.append(cnt % 2);
                cnt /= 2;
            }

            String str = sb.reverse().toString();

            s = str;
            transNum++;
        }

        int[] answer = new int[2];
        answer[0] = transNum;
        answer[1] = removeNum;

        return answer;
    }
}