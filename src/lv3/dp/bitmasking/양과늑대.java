package lv3.dp.bitmasking;

import java.util.*;

/*
2진 트리 모양에 양과 늑대가 놓여있다.
루트 노드에서 출발하여 양을 모으려 한다.
각 노드를 방문할 때마다 해당 노드에 있던 양과 늑대가 따라온다.
늑대가 양보다 같거나 많아지면 모든 양을 잡아먹힌다.
늑대에게 잡아먹히지 않으며 최대한 많은 수의 양을 모아서 다시 돌아오자.

각 노드를 방문하면서 모을 수 있는 양의 최대 마리 수를 구하라.

<입력>
info
- info: 각 노드에 있는 양 또는 늑대에 대한 정보 (2 ~ 17)
- info[i]: i번 노드에 있는 양 또는 늑대 (0은 양, 1은 늑대)
edges
- edges: 간선의 정보
- [부모, 자식]
- 중복해서 주어지지 않는다
- 항상 하나의 이진 트리 형태로 주어진다.

<출력>
각 노드를 방문하면서 모을 수 있는 양의 최대 마리 수를 구하라.

<풀이>
노드의 개수가 17 -> 비트마스킹 DP
state로 상태 관리
visited[]로 상태 방문 여부 체크
*/

class 양과늑대 {
    int n;
    int answer = 1;
    List<Integer>[] graph;
    boolean[] visited;
    int[] info;

    public int solution(int[] info, int[][] edges) {
        n = info.length;
        this.info = info;
        graph = new ArrayList[n];
        visited = new boolean[1 << n];

        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int[] edge: edges) {
            int p = edge[0];
            int c = edge[1];
            graph[p].add(c);
        }

        solve(1);

        return answer;
    }

    void solve(int state) {
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

        for (int i = 0; i < n; i++) {
            if ((state & (1 << i)) == 0) continue;

            for (int next: graph[i]) {
                if ((state & (1 << next)) != 0) continue;

                solve(state | 1 << next);
            }
        }
    }
}