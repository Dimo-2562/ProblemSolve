package lv2.dfs.backtracking;

import java.util.*;

/*
1 ~ n번까지 번호가 붙은 n개의 배양체를 n-1개의 파이프로 이어 하나의 트리 모양을 만들었다.
각 파이프는 A ~ C 3개의 종류 중 하나로 초기에 모든 파이프는 닫혀 있다.

배양체 중 하나는 바이러스에 감염되어 있다.
바이러스에 감염된 배양체는 열린 파이프를 통해 다른 인접한 배양체를 감염시킨다.

파이프를 열었다 닫는 행동을 최대 k번 반복해 최대한 많은 배양체에 바이러스를 감염

<입력>
n
- n: 배양체의 개수 (2 ~ 10^2)
infection
- infection: 감염된 배양체의 노드 번호
edges
- edges: 파이프의 정보 (n - 1)
- [x, y, type]: x와 y 사이에 type 종류 파이프로 연결됨
- type: 1, 2, 3
k
- k: 파이프를 열고 닫는 횟수

<출력>
감염된 배양체 개수의 최댓값

<풀이>
백트래킹 -> 파이프를 열고 닫는 것 지정.
재귀 돌 때마다 퍼트리기. -> visited 배열로 관리.

*/

class 바이러스파이프 {
    int answer = 1;
    List<int[]>[] graph;
    int n;

    public int solution(int n, int infection, int[][] edges, int k) {
        this.n = n;

        graph = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            int type = edge[2];
            graph[u].add(new int[]{v, type});
            graph[v].add(new int[]{u, type});
        }

        boolean[] visited = new boolean[n + 1];
        visited[infection] = true;

        backTracking(0, visited, k);

        return answer;
    }

    void backTracking(int depth, boolean[] visited, int k) {
        if (depth == k) {
            int cnt = 0;
            for (int i = 1; i <= n; i++) {
                if (visited[i]) cnt++;
            }

            answer = Math.max(answer, cnt);
            return;
        }

        for (int i = 1 ; i <= 3; i++) {
            boolean[] nextVisited = spread(i, visited);
            backTracking(depth + 1, nextVisited, k);
        }
    }

    boolean[] spread(int type, boolean[] visited) {
        Deque<Integer> dq = new ArrayDeque<>();
        boolean[] tmp = new boolean[visited.length];

        for (int i = 1; i <= n; i++) {
            tmp[i] = visited[i];
            if (visited[i]) dq.addLast(i);
        }

        while (!dq.isEmpty()) {
            int cur = dq.pollFirst();

            for (int[] next : graph[cur]) {
                int nextPos = next[0];
                int t = next[1];

                if (type != t) continue;
                if (tmp[nextPos]) continue;

                tmp[nextPos] = true;
                dq.addLast(nextPos);
            }
        }

        return tmp;
    }
}
