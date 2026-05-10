package later;

import java.util.*;

/*
가로, 세로 길이가 n인 정사각형 체스판
n개의 퀸이 서로를 공격할 수 없도록 배치

<입력>
n
- n: 가로, 세로의 길이 (1 ~ 12)

<출력>
n개의 퀸이 조건에 만족하도록 배치할 수 있는 방법

<풀이>
백트래킹
조건 체크
카운트
*/

class NQueenLater {
    int answer = 0;
    boolean[] visited;
    int[] picked;

    public int solution(int n) {
        picked = new int[n];
        visited = new boolean[n];

        backTracking(0, n);

        return answer;
    }

    void backTracking(int depth, int n) {
        if (depth == n) {
            answer++;

            return;
        }

        for (int i = 0; i < n; i++) {
            if (visited[i]) continue;
            if (!isPossible(depth, i)) continue;

            picked[depth] = i;
            visited[i] = true;
            backTracking(depth + 1, n);
            visited[i] = false;
        }
    }

    boolean isPossible(int row, int col) {
        for (int prevRow = 0; prevRow < row; prevRow++) {
            int prevCol = picked[prevRow];

            if (Math.abs(row - prevRow) == Math.abs(col - prevCol)) return false;
        }

        return true;
    }
}