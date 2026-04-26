package later;

import java.util.*;

/*
n * m 격자 미로
(x, y) -> (r, c)
조건 3가지
1. 격자 바깥으로 나갈 수 없다.
2. 총 거리가 k여야 한다. (같은 격자를 두 번 이상 방문해도 괜찮다)
3. 탈출한 경로를 문자열로 나타냈을 때, 문자열이 사전 순으로 가장 빠른 경로로 탈출해야 한다.
이동 경로
l, r, u, d
d, l, r, u (아래, 왼쪽, 오른쪽, 위 경로로 탈출)

<입력>
n, m
- n, m: 격자 크기 (2 ~ 50)
x, y
- x, y: 출발 위치
r, c
- r, c: 탈출 지점
k
- k: 탈출까지 이동해야 하는 거리 (1 ~ 2500)

<출력>
미로를 탈출하기 위한 경로를 return
- 단 탈출할 수 없으면 impossible을 return

<풀이>
S에서 E까지 최단경로를 구하고, k랑 홀,짝이 맞아야 가능.
최단 경로를 구하고
dll

du
lr
rl
ud 순으로 넣기.
그럼 어디에 넣어야 하나?
만약 du가 됐다면 ddull을 했어야 함.
d
l
r
u
4개의 큐를 두고 그 뒤에 꽂아넣자.
그리고 합치기.

풀이방향 전혀 틀림..
-> 그리디.
*/

class 미로탈출명령어Later {
    static char[] dirChar = {'d', 'l', 'r', 'u'};
    static int[] dy = {1, 0, 0, -1};
    static int[] dx = {0, -1, 1, 0};

    public String solution(int n, int m, int y, int x, int r, int c, int k) {
        int[][] map = new int[n + 1][m + 1];

        int minDist = Math.abs(y - r) + Math.abs(x - c);
        if (k < minDist) return "impossible";
        if (k % 2 != minDist % 2) return "impossible";

        StringBuilder sb = new StringBuilder();
        for (int step = 1; step <= k; step++) {
            for (int dir = 0; dir < 4; dir++) {

                int ny = y + dy[dir];
                int nx = x + dx[dir];

                if (ny < 1 || ny > n || nx < 1 || nx > m) continue;

                int remain = k - step;
                int dist = Math.abs(ny - r) + Math.abs(nx - c);

                if ((dist > remain) || (remain % 2 != dist % 2)) continue;

                sb.append(dirChar[dir]);
                y = ny;
                x = nx;
                break;
            }
        }

        return sb.toString();
    }
}