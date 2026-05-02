package lv2.math;

import java.util.*;

/*
0이 적힌 블록들에 다른 숫자가 적힌 블록들을 설치하고자 함.
n이 적혀있을 때, n * 2, n * 3, ... 위치에 설치.

1부터 설치
길이가 10^9
10^7까지의 숫자가 적힌 블록들을 이용해 위의 규칙대로 모두 설치
특정 구간에 어떤 블록이 깔려 있는지 궁금하다.

<입력>
begin, end
- begin, end: 구간 (1 ~ 10^9)
- 둘의 차 (1 ~ 10^3)

<출력>
그 구간에 깔려 있는 블록의 숫자 배열

<풀이>
자기 자신을 제외한 약수의 최댓값이 그 블럭에 깔리게 된다.
1 ~ sqrt(num) 까지 나머지가 0인 지점
그 몫이 반대 숫자.
*/

class 숫자블록 {
    final int LIMIT = 10_000_000;

    public int[] solution(long begin, long end) {
        int len = (int)(end - begin) + 1;

        int[] answer = new int[len];

        for (long i = begin; i <= end; i++) {
            answer[(int)(i - begin)] = solve(i);
        }

        return answer;
    }

    int solve(long num) {
        if (num == 1) return 0 ;

        int answer = 1;
        for (int i = 2; i * i <= num; i++) {
            if (num % i == 0) {
                long d = num / i;

                if (d <= LIMIT) {
                    return (int)d;
                }

                if (i > answer) {
                    answer = i;
                }
            }
        }

        return answer;
    }
}