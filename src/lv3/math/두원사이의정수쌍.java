package lv3.math;

import java.util.*;

/*
r1, r2가 주어질 때 두 원 사이의 공간에 x좌표와 y좌표가 모두 정수인 점의 개수를 구하자.

<입력>
r1, r2
- r1, r2: 반지름의 길이 (1 ~ 10^6)

<출력>
x좌표와 y좌표가 모두 정수인 점

<풀이>
한 사분면만 구한 뒤 * 4
x 범위를 (1 ~ x2까지)
maxY(내림), minY(올림)

x^2 + y^2 >= r1^2
x^2 + y^2 <= r2^2

y^2 >= r1^2 - x^2
*/

class 두원사이의정수쌍 {
    public long solution(int r1, int r2) {
        long sum = 0;
        for (long x = 1; x <= r2; x++) {

            long maxY = (long) Math.floor(Math.sqrt(1L*r2*r2 - x*x));
            long minY = 0;
            if (x < r1) minY = (long) Math.ceil(Math.sqrt(1L*r1*r1 - x*x));

            sum += maxY - minY + 1;
        }

        return sum * 4;
    }
}