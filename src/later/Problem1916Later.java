package later;

import java.io.*;
import java.util.*;

public class Problem1916Later {
    /*
    최단 경로 알고리즘

    인접 리스트 만들어서

    입력
    N: 도시의 개수 (10^3)
    M: 버스의 개수 (10^5)
     */
    static class Node implements Comparable<Node> {
        int city;
        int cost;

        Node(int city, int cost) {
            this.city = city;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o) {
            return this.cost - o.cost;
        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        List<Node>[] graph = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            graph[start].add(new Node(end, cost));
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        int[] dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[start] = 0;

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(start, 0));

        while (!pq.isEmpty()) {
            Node node = pq.poll();
            int curCity = node.city;
            int curCost = node.cost;

            if (curCost > dist[curCity]) continue;

            for (Node next: graph[curCity]) {
                int nextCity = next.city;
                int nextCost = curCost + next.cost;

                if (nextCost < dist[nextCity]) {
                    dist[nextCity] = nextCost;
                    pq.add(new Node(nextCity, nextCost));
                }
            }
        }

        System.out.print(dist[end]);

    }
}
