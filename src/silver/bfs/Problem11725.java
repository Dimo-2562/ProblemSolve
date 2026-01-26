package silver.bfs;

import java.io.*;
import java.util.*;

public class Problem11725 {
    public static void main(String[] args) throws IOException {
        // 루트가 1이라고 할 때 각 노드의 부모를 구하시오.
        // 양방향

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        List<Integer>[] adj = new ArrayList[n+1];
        for (int i = 0; i < adj.length; i++) {
            adj[i] = new ArrayList<>();
        }

        StringTokenizer st;
        for (int i = 0; i < n-1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            adj[a].add(b);
            adj[b].add(a);
        }

        int[] parent = new int[n+1];
        solve(adj, parent);

        StringBuilder sb = new StringBuilder();
        for (int i = 2; i <= n; i++) {
            sb.append(parent[i]).append('\n');
        }
        System.out.print(sb);
    }

    private static void solve(List<Integer>[] adj, int[] parent) {
        Deque<Integer> q = new ArrayDeque<>();
        q.add(1);
        while (!q.isEmpty()) {
            int cur = q.pollFirst();
            for (int i = 0; i < adj[cur].size(); i++) {
                int child = adj[cur].get(i);
                if (parent[child] == 0) {
                    parent[child] = cur;
                    q.add(child);
                }
            }
        }
    }
}
