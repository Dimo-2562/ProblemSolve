package lv2.twopointer.slidingwindow;

import java.util.*;

/*
m개의 행과 n개의 열
(0, 0) ~ (m-1, n-1)

w, h 크기의 선인장 구역을 조성하려 한다.
연속되며, 회전할 수 없다.
- 선인장이 비를 맞지 않는 구간이 있다면 해당 위치가 가장 우선됨
- 가능한 늦게 비를 맞는 선인장 구역 후보가 여러 개라면 그중 가장 위, 왼쪽으로

<입력>
m, n
- m, n: 격자의 크기 (1 ~ 10^5)
h, w
- h, w: 선인장 구역의 크기 (1 ~ 10^5)
drops
- drops: 빗방울이 떨어지는 순서대로 칸의 좌표를 담은 2차원 배열 (1 ~ 10^5)
- [r, c]

<풀이>
연속된 구간의 최솟값 중 최댓값인 구간을 찾자.

1. 기본값 -> INF로 설정
2. 비 맞은 구간은 따로 표시
3. 2차원 슬라이딩 윈도우

*/

class 선인장숨기기Later2 {
    final int INF = 1_000_000;

    public int[] solution(int m, int n, int h, int w, int[][] drops) {
        int[][] map = new int[m][n];
        for (int i = 0; i < m; i++) Arrays.fill(map[i], INF);

        int idx = 1;
        for (int[] drop : drops) {
            int y = drop[0];
            int x = drop[1];
            map[y][x] = idx++;
        }

        int[][] rowMin = new int[m][n - w + 1];
        for (int i = 0; i < m; i++) {
            Deque <Integer> dq = new ArrayDeque<>();

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

        int max = Integer.MIN_VALUE;
        int answerR = 0;
        int answerC = 0;

        for (int j = 0; j < n - w + 1; j++) {
            Deque <Integer> dq = new ArrayDeque<>();

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
                    int value = rowMin[dq.peekFirst()][j];

                    if (value > max ||
                        (value == max
                         && (top < answerR || (top == answerR && j < answerC)))) {
                        max = value;
                        answerR = top;
                        answerC = j;
                    }
                }
            }
        }

        return new int[]{answerR, answerC};
    }
}