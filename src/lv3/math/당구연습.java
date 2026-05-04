package lv3.math;

import java.util.*;

/*
당구공의 위치가 담겨 있다.
같은 위치에서 공을 쳐서 리스트에 담긴 위치로 해야한다.

적어도 벽에 한 번은 맞춘 후 목표 공에 맞히려고 한다.
회마다 머쓱이가 친 공이 굴러간 거리의 최솟값의 제곱을 배열에 담아 return하라.

벽에 맞으면 반대 방향
꼭짓점에 맞으면 그대로 나온다.



<입력>
m, n
- m : 가로 길이 (3 ~ 10^3)
- n : 세로 길이 (3 ~ 10^3)
startX, startY
- startX: 공의 시작점 X좌표
- startY: 공의 시작점 Y좌표
balls
- balls: 매 회마다 목표로 해야하는 공들의 위치 (2 ~ 10^3)
- [a, b]

<풀이>
각 벽으로 가는 거리 중 최솟값
꼭짓점도 보내봐야 하나? -> X

위쪽 벽: (x, 2*n-y)
왼쪽 벽: (-x, y)
오른쪽 벽: (2*m-x, y)
아래쪽 벽: (x, -y)

*/

class 당구연습 {
    final int INF = 1_000_000_000;

    public int[] solution(int m, int n, int startX, int startY, int[][] balls) {
        int[] answer = new int[balls.length];

        int idx = 0;
        for (int[] ball: balls) {
            int x = ball[0];
            int y = ball[1];

            int sum1 = (startX - x) * (startX - x) + (startY - 2 * n + y) * (startY - 2 * n + y);
            if (startX == x && startY < y) sum1 = INF;
            int sum2 = (startX + x) * (startX + x) + (startY - y) * (startY - y);
            if (startX > x && startY == y) sum2 = INF;
            int sum3 = (startX - 2 * m + x) * (startX - 2 * m + x) + (startY - y) * (startY - y);
            if (startX < x && startY == y) sum3 = INF;
            int sum4 = (startX - x) * (startX - x) + (startY + y) * (startY + y);
            if (startX == x && startY > y) sum4 = INF;

            int min1 = Math.min(sum1, sum2);
            int min2 = Math.min(sum3, sum4);
            int min = Math.min(min1, min2);

            answer[idx] = min;
            idx++;
        }

        return answer;
    }
}