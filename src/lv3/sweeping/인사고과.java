package lv3.sweeping;

import java.util.*;

/*
1년 간의 인사고과에 따라 인센티브 지급
근무 태도 점수 + 동료 평가 점수
둘 다 모두 낮은 경우가 한 번이라도 있다면 그 사원은 인센티브를 못 받음.
그렇지 않은 사원들에 대해서 두 점수의 합이 높은 순으로 석차를 내어 석차에 따라 인센티브가 차등 지급
두 점수의 합이 동일한 사원들은 동석차
동석차의 수만큼 다음 석차는 건너 뛴다

각 사원의 근무 태도 + 동료 평가 점수 목록이 주어졌을 때,
완호의 석차를 return 하라.

<입력>
scores
- scores: 점수 목록 (1 ~ 10^5)
- [a, b] (0 ~ 10^5)

<출력>
만약 받지 못하는 경우 -1을 return.

<풀이>
단순히 2중 for문 -> 시간 초과
정렬 후 스위핑
[a] 기준으로 내림차순
[b] 기준으로는 오름차순.

maxB 기준으로 낮으면 continue;

순위는 따로 합으로 별도로 계산.

*/

class 인사고과 {
    public int solution(int[][] scores) {
        int wanhoA = scores[0][0];
        int wanhoB = scores[0][1];

        Arrays.sort(scores, (o1, o2) -> {
            if (o1[0] != o2[0]) return o2[0] - o1[0];
            return o1[1] - o2[1];
        });

        int rnk = 1;
        int maxB = Integer.MIN_VALUE;

        for (int[] score: scores) {
            maxB = Math.max(maxB, score[1]);

            // 제거 로직
            if (score[1] < maxB) {
                if (score[0] == wanhoA && score[1] == wanhoB) return -1;
                continue;
            }

            // 등수 로직
            if (score[0] + score[1] > wanhoA + wanhoB) {
                rnk++;
            }
        }

        return rnk;
    }
}