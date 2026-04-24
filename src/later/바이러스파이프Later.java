package later;

import java.util.*;

class 바이러스파이프Later {
    static List<int[]>[] graph;
    static int answer = 0;

    public int solution(int n, int infection, int[][] edges, int k) {
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

        boolean[] infected = new boolean[n + 1];
        infected[infection] = true;

        dfs(0, infected, n, k);

        return answer;
    }

    void dfs(int depth, boolean[] infected, int n, int k) {
        if (depth == k) {
            int cnt = 0;
            for (int i = 1; i <= n; i++) {
                if (infected[i]) cnt++;
            }
            answer = Math.max(answer, cnt);

            return;
        }

        for (int i = 1; i <= 3; i++) {
            boolean[] next = spread(i, infected);
            dfs(depth + 1, next, n, k);
        }
    }

    boolean[] spread(int type, boolean[] infected) {
        Deque <Integer> dq = new ArrayDeque<>();
        boolean[] tmp = new boolean[infected.length];

        for (int i = 1; i < infected.length; i++) {
            tmp[i] = infected[i];
            if (tmp[i]) dq.addLast(i);
        }

        while (!dq.isEmpty()) {
            int cur = dq.pollFirst();

            for (int[] edge : graph[cur]) {
                int next = edge[0];
                int t = edge[1];

                if (tmp[next]) continue;
                if (type != t) continue;

                tmp[next] = true;
                dq.addLast(next);
            }
        }

        return tmp;
    }
}