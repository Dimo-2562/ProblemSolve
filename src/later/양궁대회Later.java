package later;

import java.util.*;

/*
어피치가 n발을 다 쏜 후 라이언이 n발을 쏜다.
점수를 계산
- 더 많은 개수로 맞힌 사람이 득점
- 같은 개수로 맞혔으면 어피치가 득점
- 아무도 맞히지 못한경우 득점 X.
- 최종 점수가 더 높은 선수가 승리

<입력>
n
- n: 화살의 개수 (1 ~ 10)
info
- info: 어피치가 맞힌 과녁 점수의 개수 (11)
- 10점 ~ 0점 순으로 원소가 주어진다.

<출력>
가장 큰 점수 차이로 우승하기 위해 n발의 화살을 어느 과녁 점수에 맞혀야 하는지를 배열에 담아 return
- 무조건 지거나 비기는 경우 [-1]을 return

<풀이>
특정 점수에 대해 이길지 말지 결정
2 ^ 11
- 이길경우: 어피치 개수 + 1
- 질경우: 0
최댓값인 시점을 배열로 찍기.

백트래킹

*/

class 양궁대회Later {
    int max = -1;

    int[] answer = new int[11];

    public int[] solution(int n, int[] info) {
        int[] ryan = new int[11];
        backTracking(0, info, n, ryan);

        if (max == -1) return new int[]{-1};
        return answer;
    }

    void backTracking(int depth, int[] info, int left, int[] ryan) {
        if (left < 0) return;

        if (depth == 11) {
            ryan[10] += left;

            int ryanSum = 0;
            int apeachSum = 0;
            for (int i = 0; i <= 10; i++) {
                int score = 10 - i;

                if (ryan[i] == 0 && info[i] == 0) continue;

                if (ryan[i] > info[i]) {
                    ryanSum += score;
                } else {
                    apeachSum += score;
                }
            }

            int diff = ryanSum - apeachSum;

            if (diff > 0) {
                if (diff > max || diff == max && isBetter(ryan, answer)){
                    max = diff;
                    answer = ryan.clone();
                }
            }

            ryan[10] -= left;
            return;
        }

        ryan[depth] = info[depth] + 1;
        backTracking(depth + 1, info, left - ryan[depth], ryan);
        ryan[depth] = 0;
        backTracking(depth + 1, info, left, ryan);
    }

    boolean isBetter(int[] cur, int[] best) {
        for (int i = 10; i >= 0; i--) {
            if (cur[i] > best[i]) return true;
            if (cur[i] < best[i]) return false;
        }
        return false;
    }
}