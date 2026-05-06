package lv2.greedy;

import java.util.*;

/*
A -> B를 공격
미사일을 요격
x축에 평행한 미사일 (s, e)
y축에 수평이 되도록 미사일을 발사하여 미사일을 요격
단, s와 e에서는 불가능함.
실수인 x좌표에서도 요격 가능.

<입력>
targets
- targets: 미사일 (1 ~ 10^5)
- [s, e]: start, end (0 ~ 10^8) (정수)

<풀이>
e만 가능하다고 여겨도 괜찮음.
끝 지점 기준 정렬
1 4
4 5
3 7
4 8
5 12
11 13
10 14

시작 지점 기준 정렬
1 4
3 7 // 커버가 되고
4 5
4 8 //커버가 되고
5 12
10 14
11 13

[1, 100]을 항상 생각할 것!

*/

class 요격시스템 {
    public int solution(int[][] targets) {
        Arrays.sort(targets, (o1, o2) -> o1[1] - o2[1]);

        int end = 0;
        int answer = 0;
        for (int[] target: targets) {
            int s = target[0];
            int e = target[1];

            if (end <= s) {
                end = e;
                answer++;
            }
        }

        return answer;
    }
}
