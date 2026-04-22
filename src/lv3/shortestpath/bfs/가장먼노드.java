package lv3.shortestpath.bfs;

import java.io.*;
import java.util.*;

/*
n개의 노드 (1 ~ n번)
1번 노드에서 가장 멀리 떨어진 노드의 갯수를 구하라.
가장 멀리 떨어진 노드 = 최단경로 시 간선의 개수가 많은 노드.

1번 노드로부터 가장 멀리 떨어진 노드가 몇 개인지를 return 하라

<입력>
n
- n: 노드의 개수 (2 ~ 10^4)
edge
- edge: 간선 (1 ~ 10^4)
- 양방향

<출력>
1번 노드로부터 가장 멀리 떨어진 노드가 몇 개인지를 return 하라.

<풀이>
BFS로 최단 경로 구한 뒤에
MAX 값 기준으로 cnt 체크.
*/

class 가장먼노드 {
    public int solution(int n, int[][] edge) {
        List<Integer>[] graph = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int[] e : edge) {
            int u = e[0];
            int v = e[1];
            graph[u].add(v);
            graph[v].add(u);
        }

        int[] dist = new int[n + 1];
        Arrays.fill(dist, -1);

        Deque<Integer> dq = new ArrayDeque<>();
        dq.addLast(1);
        dist[1] = 0;

        while (!dq.isEmpty()) {
            int cur = dq.pollFirst();

            for (int next : graph[cur]) {
                if (dist[next] != -1) continue;

                dist[next] = dist[cur] + 1;
                dq.addLast(next);
            }
        }

        int max = Integer.MIN_VALUE;
        int cnt = 0;
        for (int i = 1; i <= n; i++) {
            if (max < dist[i]) {
                max = dist[i];
                cnt = 1;
            } else if (max == dist[i]) {
                cnt++;
            }
        }

        return cnt;
    }
}