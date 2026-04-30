package later;

import java.util.*;

/*
양의 정수 n -> k진수로 변환
아래 조건에 맞는 소수가 몇 개인지 알아보자.
- 0P0
- P0
- 0P
- P

<입력>
n
- n: 자연수 (1 ~ 10^6)
k
- k: k진수로 바꿀 진법 (3 ~ 10)

<출력>
소수의 개수를 return

<풀이>
1. 소수 구해놓기.
2. k진수로 바꾸기
3. 0기준으로 분리하기 (처음, 사이, 끝)
4. 개수 세기 (중복은 별도로)
*/

class k진수에서소수개수구하기Later {
    public int solution(int n, int k) {

        StringBuilder sb = new StringBuilder();
        while (n > 0) {
            int r = n % k;
            sb.append(r);
            n /= k;
        }
        String str = sb.reverse().toString();

        int answer = 0;
        sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) != '0') {
                sb.append(str.charAt(i));
            } else {
                if (sb.length() == 0) continue;

                long num = Long.parseLong(sb.toString());
                if (isPrime(num)) answer++;
                sb.setLength(0);
            }
        }

        if (sb.length() > 0) {
            long num = Long.parseLong(sb.toString());
            if (isPrime(num)) answer++;
        }

        return answer;
    }

    boolean isPrime(long num) {
        if (num < 2) return false;

        for (long i = 2; i * i <= num; i++) {
            if (num % i == 0) return false;
        }

        return true;
    }
}