package lv2.bruteforce;

import java.util.*;

/*
자연수 n, n의 다음 큰 숫자는 아래와 같이 정의
1. n보다 큰 자연수
2. 이진수로 변환했을 때 1의 개수가 같다.
3. 1, 2를 만족하는 수 중 가장 작은 수

<입력>
n
- n: 자연수 (1 ~ 10^6)

<풀이>
1의 개수가 같은 건 금방 나오므로 브루트포스
*/

class 다음큰숫자 {
    public int solution(int n) {
        int cnt1 = 0;
        int tmp = n;
        while (tmp > 0) {
            int r = tmp % 2;
            if (r == 1) cnt1++;

            tmp /= 2;
        }

        int num = n + 1;
        while (true) {
            int cp = num;

            int cnt = 0;
            while (cp > 0) {
                if (cp % 2 == 1) cnt++;
                cp /= 2;
            }

            if (cnt == cnt1) break;

            num++;
        }

        int answer = num;
        return answer;
    }
}