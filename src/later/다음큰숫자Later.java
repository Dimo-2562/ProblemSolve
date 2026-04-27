package later;

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

class 다음큰숫자Later {
    public int solution(int n) {

        int c = n;
        int cnt0 = 0, cnt1 = 0;

        while ((c & 1) == 0 && c != 0) {
            cnt0++;
            c = c >> 1;
        }

        while ((c & 1) == 1 && c != 0) {
            cnt1++;
            c = c >> 1;
        }

        int pos = cnt0 + cnt1;
        n |= (1 << pos);
        n &= ~((1 << pos) - 1);
        n |= (1 << (cnt1 - 1)) - 1;

        return n;
    }
}