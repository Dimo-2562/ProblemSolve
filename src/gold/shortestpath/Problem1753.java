package gold.shortestpath;

import java.io.*;
import java.util.*;

public class Problem1753 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int v = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());
        int start = Integer.parseInt(br.readLine());

        List<int[]>[] adj = new ArrayList[v+1];
        for (int i = 1; i <= v; i++) {
            adj[i] = new ArrayList<>();
        }
        int[] dist = new int[v+1];
        Arrays.fill(dist, Integer.MAX_VALUE);

        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            adj[from].add(new int[] {to, cost});
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        pq.add(new int[] {0, start});
        dist[start] = 0;

        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int curCost = cur[0];
            int curNode = cur[1];

            if (dist[curNode] < curCost) continue;

            for (int[] next : adj[curNode]) {
                int nextNode = next[0];
                int nextCost = next[1];
                if (dist[curNode] + nextCost < dist[nextNode]) {
                    dist[nextNode] = dist[curNode] + nextCost;
                    pq.add(new int[] {dist[nextNode], nextNode});
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= v; i++) {
            if(dist[i] == Integer.MAX_VALUE) sb.append("INF");
            else sb.append(dist[i]);
            sb.append('\n');
        }
        System.out.print(sb);

    }
}
