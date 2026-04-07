package gold.shortestpath.dijkstra;

import java.io.*;
import java.util.*;

/*
만나는 모든 소들에게 여물을 줘야하지만 최소한의 소를 만나고 싶다.
N개의 헛간
M개의 양방향 길
각각의 길은 C마리의 소가 있다.
두 개의 헛간은 하나 이상의 길로 연결되어 있을 수도 있다.

현서: 1에 위치
찬홍: N에 위치

최단거리 문제
<입력>
N, M
- N: 헛간의 개수 (1 ~ 10^4)
- M: 간선의 개수 (1 ~ 10^4)
시작, 종료, 비용 (M개의 줄)

<출력>
현서가 가져가야할 최소 여물(즉 최단거리)

<풀이>
최단거리 탐색 (가중치가 다양한) -> 다익스트라

 */

public class Problem5972 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());

        List<int[]>[] graph = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }
        int[] dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);

        int m = Integer.parseInt(st.nextToken());
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            graph[start].add(new int[]{end, cost});
            graph[end].add(new int[]{start, cost});
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);
        pq.add(new int[]{1, 0});
        dist[1] = 0;

        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int pos = cur[0];
            int cost = cur[1];

            if(dist[pos] < cost) continue;

            for (int[] next: graph[pos]) {
                int nextPos = next[0];
                int nextCost = next[1];
                if (dist[nextPos] > dist[pos] + nextCost) {
                    dist[nextPos] = dist[pos] + nextCost;
                    pq.add(new int[]{nextPos, dist[nextPos]});
                }
            }
        }

        System.out.print(dist[n]);
    }
}
