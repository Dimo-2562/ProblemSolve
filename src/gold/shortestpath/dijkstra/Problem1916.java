package gold.shortestpath.dijkstra;

import java.io.*;
import java.util.*;

/*
N개의 도시
M개의 버스
A 도시에서 B 도시까지 가는데 드는 버스 비용을 최소화
도시 번호는 1 ~ N

<입력>
N
- N: 도시의 개수 (1 ~ 10^3)
M
- M: 버스의 개수 (1 ~ 10^5)
출발 도시, 도착 도시, 비용 (M개의 줄)
- 버스 비용: 0 ~ 10^5
구하고자하는 출발 도시 및 도착 도시

<출력>
출발 도시에서 도착 도시까지 가는데 드는 최소비용

<풀이>
가중치가 다양한 최단경로 -> 다익스트라
같은 경로의 버스 여러 개 가능 -> 언급 X (가능으로 생각)
최대 거리: 10^3 * 10^5 = 10^8 -> int형 범위 내.
 */

public class Problem1916 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        List<int[]>[] graph = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }
        int[] dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);

        int m = Integer.parseInt(br.readLine());
        while (m-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            graph[start].add(new int[]{end, cost});
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> Integer.compare(o1[1], o2[1]));
        pq.add(new int[] {start, 0});
        dist[start] = 0;

        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int curPos = cur[0];
            int cost = cur[1];

            if (dist[curPos] < cost) continue;

            for (int[] next : graph[curPos]) {
                int nextPos = next[0];
                int nextCost = next[1];

                if (dist[nextPos] > dist[curPos] + nextCost) {
                    dist[nextPos] = dist[curPos] + nextCost;
                    pq.add(new int[]{nextPos, dist[nextPos]});
                }
            }
        }

        System.out.print(dist[end]);
    }
}