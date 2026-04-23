package later;

import java.util.*;

/*
1년 간의 인사고과에 따라 인센티브 지급
사원마다 근무 태도 점수, 동료 평가 점수

만약 어떤 사원이 임의의 사원보다 두 점수가 모두 낮은 겨우 한 번이라도 있으면 인센티브를 받을 수 없다.
그렇지 않은 사원들에 대하여 두 점수의 합이 높은 순으로 석차, 석차에 따라 인센티브 지급

합이 동일한 사원은 동석차
동석차의 수만큼 다음 석차는 건너뛴다.

<입력>
scores
- scores: 근무 태도 점수, 동료 평가 점수 (1 ~ 10^5)
- [a, b] (0 ~ 10^5)
- scores[0]: 완호의 점수

<출력>
완호의 석차를 return
- 인센티브를 받지 못하는 경우 -1

<풀이>
완호 점수는 따로 빼두기.
leftMin, rightMin을 두고
boolean leftFlag, rightFlag
인센티브 못 받는 사람들은 제외.

0. 완호 점수 체크
1. leftMin, rightMin 체크
2. 인센티브 못 받는 사람들 제거 -> 이때 완호 있으면 return -1
3. 합이 높은 순으로 정렬
4. 완호 순위 체크

풀이 봄 -> 전체 min으로 인센티브 못 받는게 아니었다.

스위핑으로 푸는 문제.

*/

class 인사고과Later {
    public int solution(int[][] scores) {
        int wanhoA = scores[0][0];
        int wanhoB = scores[0][1];
        int wanhoSum = wanhoA + wanhoB;

        Arrays.sort(scores, (o1, o2) -> {
            if (o1[0] != o2[0]) return o2[0] - o1[0];
            return o1[1] - o2[1];
        });

        // [3, 2], [3, 2], [2, 1], [2, 2], [1, 4]

        int maxB = -1;
        int rank = 1;

        for (int[] score: scores) {
            int a = score[0];
            int b = score[1];

            if (b < maxB) {
                if (a == wanhoA && b == wanhoB) return -1;
                continue;
            }

            if (a + b > wanhoSum) rank++;

            maxB = Math.max(maxB, b);
        }

        return rank;
    }
}