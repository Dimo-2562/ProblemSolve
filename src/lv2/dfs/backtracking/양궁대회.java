package lv2.dfs.backtracking;

import java.util.*;

/*
라이언과 어피치

어피치가 화살을 n발 다 쏜 후에 라이언이 화살을 n발 쏜다
점수를 계산
점수: 10 ~ 0점
더 많은 화살을 맞힌 선수가 k점을 가져간다.
같은 발 수를 맞히면 어피치가 가져간다.
둘 다 0점인 경우 점수를 가져가지 않는다.
각 선수의 최종 점수를 계산한다.
최종 점수가 같을 경우 어피치를 우승자로 결정

라이언이 가장 큰 점수 차이로 우승하기 위해 n발의 화살을 어떤 과녁 점수에 맞혀야 하는지를
10점부터 0점 순서대로 정수 배열에 담아 return 하라.

<입력>
n
- n: 화살의 개수 (1 ~ 10)
info
- info: 어피치가 맞힌 과녁 점수의 개수 (11)

<출력>
라이언이 가장 큰 점수 차이로 우승하기 위해 n발의 화살을 어떤 과녁 점수에 맞혀야 하는지를
10점부터 0점 순서대로 정수 배열에 담아 return 하라.
- 만약 지거나 비기는 경우 -1을 return

<풀이>
각 화살마다 분기 -> 11^10 (X)
각 점수를 이길지 말지 -> 2^11
백트래킹
만약 발 수가 남으면 0점에 넣기.
각 경우마다 비교하기.
*/

class 양궁대회 {
    int[] info;
    int n;
    int[] answer = new int[]{-1};
    int max = 0;
    int[] picked = new int[11];

    public int[] solution(int n, int[] info) {
        this.info = info;
        this.n = n;

        backTracking(0, n);

        return answer;
    }

    void backTracking(int depth, int last) {
        if (last < 0) return;

        if (depth == 11) {
            picked[10] += last;

            int ryan = 0;
            int apeach = 0;

            for (int i = 0; i <= 10; i++) {
                int score = 10 - i;

                if (picked[i] > info[i]) {
                    ryan += score;
                } else if (info[i] != 0 && picked[i] <= info[i]) {
                    apeach += score;
                }
            }

            if (ryan > apeach && ryan - apeach > max) {
                max = ryan - apeach;
                answer = picked.clone();
            } else if (ryan > apeach && ryan - apeach == max) {
                if (isBetter()) {
                    answer = picked.clone();
                }
            }

            return;
        }

        picked[depth] = 0;
        backTracking(depth + 1, last);
        picked[depth] = info[depth] + 1;
        backTracking(depth + 1, last - picked[depth]);
    }

    boolean isBetter(){
        for (int i = 10; i >= 0; i--) {
            if (answer[i] < picked[i]) return true;
            else if (answer[i] > picked[i]) return false;
        }
        return false;
    }
}