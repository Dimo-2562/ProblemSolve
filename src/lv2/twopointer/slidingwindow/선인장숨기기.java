package lv2.twopointer.slidingwindow;

import java.util.*;

/*
m개의 행, n개의 열
(0, 0) ~ (m - 1, n - 1)
세로 h, 가로 w 크기의 선인장 구역

비구름은 비를 뿌린다.
빗방울이 처음으로 선인장 구역에 포함된 칸에 떨어졌을 때, 그 시점을 비를 맞는 순간으로 기록.
선인장이 비를 늦게 맞도록, 선인장 구역의 위치를 정하자.

아예 안 맞는 곳이 있다면 해당 위치가 우선
여러 개라면, 가장 위쪽 행, 그래도 여러 개면 가장 왼쪽 열에 위치한 구역을 선택

<입력>
m, n
- m: 행 (1 ~ 10^5)
- n: 열 (1 ~ 10^5)
- m * n (1 ~ 10^5)
h, w
- h: 세로 (1 ~ 10^5)
- w: 가로 (1 ~ 10^5)
drops
- drops: 비가 내리는 곳 (1 ~ 10^5)
- [r, c]

<출력>
주어진 조건을 만족하는 선인장 구역에 포함된 가장 왼쪽 위칸의 좌표

<풀이>
1. 초기값을 무한대로 구성
2. 비 내린 곳 적용
3. 2차원 슬라이딩 윈도우 -> 구역의 최솟값 중 최댓값을 구하자.



*/

class 선인장숨기기 {
    final int INF = 1_000_000;

    public int[] solution(int m, int n, int h, int w, int[][] drops) {
        int[][] map = new int[m][n];

        // 1. 초기값 적용
        for (int i = 0; i < m; i++) {
            Arrays.fill(map[i], INF);
        }

        // 2. 비 내린 곳 적용
        for (int i = 0; i < drops.length; i++) {
            int r = drops[i][0];
            int c = drops[i][1];
            map[r][c] = i + 1;
        }

        // 3. 2차원 슬라이딩 윈도우
        int colSize = n - w + 1;
        int[][] rowMin = new int[m][colSize];
        for (int i = 0; i < m; i++) {
            Deque<Integer> dq = new ArrayDeque<>();

            for (int j = 0; j < n; j++) {
                while (!dq.isEmpty() && dq.peekFirst() < j - w + 1) {
                    dq.pollFirst();
                }

                while (!dq.isEmpty() && map[i][dq.peekLast()] > map[i][j]) {
                    dq.pollLast();
                }

                dq.addLast(j);

                if (j >= w - 1) {
                    rowMin[i][j - w + 1] = map[i][dq.peekFirst()];
                }
            }
        }

        int max = -1;
        int answerR = 0;
        int answerC = 0;

        for (int j = 0; j < colSize; j++) {
            Deque<Integer> dq = new ArrayDeque<>();

            for (int i = 0; i < m; i++) {
                while (!dq.isEmpty() && dq.peekFirst() < i - h + 1) {
                    dq.pollFirst();
                }

                while (!dq.isEmpty() && rowMin[dq.peekLast()][j] > rowMin[i][j]) {
                    dq.pollLast();
                }

                dq.addLast(i);

                if (i >= h - 1) {
                    int top = i - h + 1;

                    if (max < rowMin[dq.peekFirst()][j]) {
                        max = rowMin[dq.peekFirst()][j];
                        answerR = top;
                        answerC = j;
                    } else if (max == rowMin[dq.peekFirst()][j]
                               && (answerR > top || (answerR == top && answerC > j))) {
                        answerR = top;
                        answerC = j;
                    }
                }
            }
        }

        return new int[]{answerR, answerC};
    }
}