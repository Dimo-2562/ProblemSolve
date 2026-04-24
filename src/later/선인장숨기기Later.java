package later;

import java.util.*;

/*
m개의 행과 n개의 열
(0, 0) ~ (m-1, n-1)

가로 w, 세로 h 크기의 선인장 구역 조성
회전 불가능.

비구름 -> 정해진 순서대로 비를 뿌린다.
처음으로 빗방울이 선인장 구역에 포함된 칸에 떨어졌을 때 그 시점을 비를 맞는 순간으로 기록
가능한 늦게 비를 맞도록 선인장 구역의 위치를 정하자

비를 맞지 않는 경우가 있다면 최우선
가능한 비를 늦게 맞는 후보가 여러 개라면 가장 위쪽, 그리고 가장 왼쪽 열에 위치한 구역

<입력>
m, n
- m : 격자의 행 (1 ~ 10^5)
- n : 격자의 열 (1 ~ 10^5)
h, w
- h : 선인장 구역의 세로 길이 (1 ~ 10^5)
- w : 선인장 구역의 가로 길이 (1 ~ 10^5)
drops
- drops: 빗방울이 떨어지는 칸의 좌표 (1 ~ 10^5)
- [r, c]

<출력>
주어진 조건을 만족하는 선인장 구역에 포함된 가장 왼쪽 위칸의 좌표를 return 하라.

<풀이>
*/

class 선인장숨기기Later {
    public int[] solution(int m, int n, int h, int w, int[][] drops) {

        // 1. 맵 구성하기
        int[][] map = new int[m][n];
        final int INF = drops.length + 1;

        for (int i = 0; i < m; i++) {
            Arrays.fill(map[i], INF);
        }

        for (int i = 1; i <= drops.length; i++) {
            int[] drop = drops[i - 1];
            int y = drop[0];
            int x = drop[1];
            map[y][x] = i;
        }

        // row 별 구간 최솟값 구하기
        int colSize = n - w + 1;
        int[][] rowMin = new int[m][colSize];

        for (int i = 0; i < m; i++) {
            Deque <Integer> dq = new ArrayDeque<>();

            for (int j = 0; j < n; j++) {
                while (!dq.isEmpty() && dq.peekFirst() <= j - w) {
                    dq.pollFirst();
                }

                // 지금 들어오는 값보다 크거나 같은 값은 다 제거
                while (!dq.isEmpty() && map[i][dq.peekLast()] >= map[i][j]) {
                    dq.pollLast();
                }

                dq.addLast(j);

                if (j >= w - 1) {
                    rowMin[i][j - w + 1] = map[i][dq.peekFirst()];
                }
            }
        }

        int best = -1;
        int answerR = 0;
        int answerC = 0;

        for (int j = 0; j < colSize; j++) {
            Deque <Integer> dq = new ArrayDeque<>();

            for (int i = 0; i < m; i++) {
                while (!dq.isEmpty() && dq.peekFirst() <= i - h) {
                    dq.pollFirst();
                }

                while (!dq.isEmpty() && rowMin[dq.peekLast()][j] >= rowMin[i][j]) {
                    dq.pollLast();
                }

                dq.addLast(i);

                if (i >= h - 1) {
                    int top = i - h + 1;
                    int value = rowMin[dq.peekFirst()][j];

                    if (value > best ||
                        (value == best
                         && (top < answerR || (top == answerR && j < answerC)))) {
                        best = value;
                        answerR = top;
                        answerC = j;
                    }
                }
            }
        }

        return new int[] {answerR, answerC};
    }
}