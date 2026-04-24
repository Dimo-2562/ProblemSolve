package later;

import java.util.*;

/*
양이 늑대보다 많아야 함.
양을 최대로 모을 수 있는 마리 수를 return 하라

<입력>
info
- info: 각 노드에 있는 양 또는 늑대에 대한 정보 (2 ~ 17)
- 원소: 0(양) or 1(늑대)
- [0]은 항상 0
edges
- edges: 각 노드들의 연결 관계 (1 ~ 16)
- [부모, 자식]
- 중복해서 주어지지 않는다.
- 항상 이진 트리

<출력>
최대로 모을 수 있는 양의 마리 수를 return 하라

<풀이>
풀이 봄 -> 비트마스킹 DP

*/

class 양과늑대Later {
    int[] info;
    List<Integer>[] graph;
    boolean[] visitedState;
    int answer = 0;

    public int solution(int[] info, int[][] edges) {
        this.info = info;
        graph = new ArrayList[info.length];
        visitedState = new boolean[1 << info.length];

        for (int i = 0; i < info.length; i++) {
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
        if (visitedState[state]) return;
        visitedState[state] = true;

        int sheep = 0;
        int wolf = 0;

        for (int i = 0; i < info.length; i++) {
            if ((state & (1 << i)) == 0) continue;

            if (info[i] == 0) sheep++;
            else wolf++;
        }

        if (sheep <= wolf) return;

        answer = Math.max(answer, sheep);

        for (int i = 0; i < info.length; i++) {
            if ((state & (1 << i)) == 0) continue;

            for (int next : graph[i]) {
                if ((state & (1 << next)) != 0) continue;

                dfs(state | (1 << next));
            }
        }
    }
}