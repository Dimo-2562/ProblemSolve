package gold.shortestpath;

import java.io.*;
import java.util.*;

public class Problem1504 {
    public static void main(String[] args) throws IOException {
        /*
        1 -> A -> B -> N
        1 -> B -> A -> N
         */

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());

        List<int[]>[] list = new ArrayList[n+1];
        for (int i = 1; i <= n; i++) {
            list[i] = new ArrayList<>();
        }
        int[] dist = new int[n+1];
        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            list[from].add(new int[] {to, cost});
            list[to].add(new int[] {from, cost});
        }

        st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        int answer = dijkstra(1, n, list, dist);
        if (answer == Integer.MAX_VALUE) {
            System.out.print("-1");
            return;
        }

        int answer1 = dijkstra(1, a, list, dist)
                + dijkstra(a, b, list, dist)
                + dijkstra(b, n, list, dist);
        int answer2 = dijkstra(1, b, list, dist)
                + dijkstra(b, a, list, dist)
                + dijkstra(a, n, list, dist);

        System.out.print(Math.min(answer1, answer2));
    }

    static int dijkstra(int start, int end, List<int[]>[] list, int[] dist) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        Arrays.fill(dist, Integer.MAX_VALUE);

        pq.add(new int[] {start, 0});
        dist[start] = 0;
        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int curPos = cur[0];
            int curCost = cur[1];

            if (dist[curPos] < curCost) continue;

            for (int[] neighbor : list[curPos]) {
                int neighborPos = neighbor[0];
                int neighborCost = neighbor[1];
                if (dist[curPos] + neighborCost < dist[neighborPos]) {
                    dist[neighborPos] = dist[curPos] + neighborCost;
                    pq.add(new int[] {neighborPos, dist[neighborPos]});
                }
            }
        }

        return dist[end];
    }
}
