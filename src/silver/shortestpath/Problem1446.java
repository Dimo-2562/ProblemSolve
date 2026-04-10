package silver.shortestpath;

import java.io.*;
import java.util.*;

/*
D 킬로미터 고속도로
지름길 (일방통행)
고속도로 역주행은 불가.

운전해야 하는 거리의 최솟값을 구하라.

<입력>
N, D
- N: 지름길의 개수 (1 ~ 12)
- D: 고속도로의 길이 (1 ~ 10^4)
시작 위치, 도착 위치, 지름길의 길이
- 각 위치와 길이 (1 ~ 10^4)
- 시작 위치 < 도착 위치

<출력>
운전해야 하는 거리의 최솟값

<풀이>
각 지점마다 가중치는 1,
지름길의 가중치는 지름길의 길이만큼.
-> 다익스트라
 */

public class Problem1446 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());

        List<int[]>[] graph = new ArrayList[d + 1];
        for (int i = 0; i <= d; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int i = 0; i < d; i++) {
            graph[i].add(new int[]{i + 1, 1});
        }

        int[] dist = new int[d + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            if (end > d || end - start < cost) continue;

            graph[start].add(new int[]{end, cost});
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);
        dist[0] = 0;
        pq.add(new int[]{0, 0});

        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int pos = cur[0];
            int cost = cur[1];

            if (dist[pos] < cost) continue;

            for (int[] num : graph[pos]) {
                int next = num[0];
                int nextCost = num[1];
                if (dist[pos] + nextCost < dist[next]) {
                    dist[next] = dist[pos] + nextCost;
                    pq.add(new int[]{next, dist[next]});
                }
            }
        }

        System.out.println(dist[d]);
    }
}
