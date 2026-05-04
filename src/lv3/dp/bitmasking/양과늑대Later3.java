package lv3.dp.bitmasking;

import java.util.*;

/*
양과 늑대
노드를 돌아다니며 양을 모으려 한다.
늑대가 양의 수보다 많거나 같으면 안된다.
최대한 많은 수의 양을 모으자.

<입력>
info
- info: i번 노드에 있는 양 또는 늑대의 정보 (2 ~ 17)
- 0은 양, 1은 늑대
edges
- edges: 간선의 정보 (info - 1 == 트리)
- [부모, 자식]
- 동일한 간선에 대한 정보는 중복으로 주어지지 않는다.
- 항상 이진 트리 형태로 주어지며, 잘못된 데이터는 주어지지 않는다.

<출력>
가장 많이 양을 모았을 때 최대 몇 마리인지 return 하라.

<풀이>
n의 범위가 17 -> TSP처럼 상태 관리를 비트로.
전체 방문 정보 -> visited 변수
각 방문 정보 -> isVisited[]
*/


class 양과늑대Later3 {
    int answer = 0;
    int n;
    boolean[] isVisited;
    int[] info;
    List<Integer>[] graph;

    public int solution(int[] info, int[][] edges) {
        n = info.length;
        this.info = info;
        isVisited = new boolean[1 << n];

        graph = new ArrayList[n + 1];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int[] edge: edges) {
            int p = edge[0];
            int c = edge[1];
            graph[p].add(c);
        }

        dfs(1);

        return answer;
    }

    void dfs(int state) {
        if (isVisited[state]) return;
        isVisited[state] = true;

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

            for (int next : graph[i]) {
                if ((state & (1 << next)) != 0) continue;

                dfs(state | (1 << next));
            }
        }

    }
}