package later;

import java.util.*;

/*
2진 트리 모양 초원 각 노드에 늑대와 양이 한 마리씩 놓여있다.
루트 노드에서 출발하여 각 노드를 돌아다니며 양을 모으려 한다.

늑대의 수가 양의 수랑 같거나 많아지면 안된다.
최대한 많은 수의 양을 모으자.

노드는 중복 방문 가능.

<입력>
info
- info: 각 노드의 정보 (2 ~ 17)
- 원소 (0 or 1)
- 0: 양, 1: 늑대
- [0]은 항상 0
edges
- edges: info - 1 (트리)
- [부모, 자식]

<풀이>
TSP 느낌 -> 비트마스킹 DP
상태를 int형 변수로 관리.

*/


class 양과늑대Later2 {
    List<Integer>[] graph;
    int[] info;
    boolean[] visited;
    int n;
    int answer = 1;

    public int solution(int[] info, int[][] edges) {
        this.info = info;
        n = info.length;
        visited = new boolean[1 << n];

        graph = new ArrayList[n + 1];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int[] edge: edges) {
            int u = edge[0];
            int v = edge[1];
            graph[u].add(v);
        }

        dfs(1);

        return answer;
    }

    void dfs(int state) {
        if (visited[state]) return;
        visited[state] = true;

        int wolf = 0;
        int sheep = 0;

        for (int i = 0; i < n; i++) {
            if ((state & (1 << i)) == 0) continue;

            if (info[i] == 0) sheep++;
            else wolf++;
        }

        if (wolf >= sheep) return;

        answer = Math.max(answer, sheep);

        for (int cur = 0; cur < n; cur++) {
            if ((state & (1 << cur)) == 0) continue;

            for (int next : graph[cur]) {
                if ((state & (1 << next)) != 0) continue;

                dfs(state | 1 << next);
            }
        }
    }
}