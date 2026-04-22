package lv3.shortestpath.bfs;

import java.util.*;

/*
여러 지역에 흩어져 임무 수행
각 지역은 번호로 구분
길의 가중치는 1
지도 정보를 이용하여 최단 경로

모든 정점이 destination까지 이어지는 건 아님.

<입력>
n
- n: 정점의 수 (3 ~ 10^5)
- 각 지역은 1 ~ n까지 번호로 구분됨.
roads
- roads: 연결된 두 지역을 나타냄 (2 ~ 10^5)
- [start, end]로 주어지고, 양방향.
- 동일한 정보는 주어지지 않음.
sources
- sources: 부대원이 위치한 지역 (1 ~ 10^2)
destination
- destination: 강철부대가 복귀해야하는 위치

<출력>
각 부대원이 destination까지 걸리는 최단 시간을 배열로 return
- 단, 복귀가 불가능한 경우 -1

<풀이>
가중치가 1인 최단경로 -> bfs
*/

class 부대복귀 {
    public int[] solution(int n, int[][] roads, int[] sources, int destination) {
        List<Integer>[] graph = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int[] edge: roads) {
            int start = edge[0];
            int end = edge[1];
            graph[start].add(end);
            graph[end].add(start);
        }

        int[] dist = new int[n + 1];
        Arrays.fill(dist, -1);

        Deque<Integer> dq = new ArrayDeque<>();
        dq.addLast(destination);
        dist[destination] = 0;

        while (!dq.isEmpty()) {
            int cur = dq.pollFirst();

            for (int next : graph[cur]) {
                if (dist[next] != -1) continue;

                dist[next] = dist[cur] + 1;
                dq.addLast(next);
            }
        }

        int[] answer = new int[sources.length];
        for (int i = 0; i < sources.length; i++) {
            int goal = sources[i];
            answer[i] = dist[goal];
        }
        return answer;
    }
}