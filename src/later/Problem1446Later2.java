package later;

import java.io.*;
import java.util.*;

/*
D킬로미터 고속도로
지름길 (일방통행)
역주행은 불가능
운전해야 하는 거리의 최솟값.

<입력>
N D
- N: 지름길의 개수 (1 ~ 12)
- D: 고속도로의 길이 (1 ~ 10^4)
시작, 도착, 길이 (N개의 줄)
- 각 값 (0 ~ 10^4)
- 시작은 항상 도착보다 작다.

<출력>
운전해야 하는 거리의 최솟값을 구하라.

간선이 기본은 1.
BFS
같은 시작과 도착인 지름길이 여러 개 가능 ->
[시작] (도착, 거리)
 */

public class Problem1446Later2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());

        // 간선의 cost가 1인 간선
        List<int[]>[] graph = new ArrayList[d + 1];
        for (int i = 0; i <= d; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int i = 0; i < d; i++) {
            graph[i].add(new int[]{i + 1, 1});
        }

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            if (end > d || end - start < cost) continue;

            graph[start].add(new int[]{end, cost});
        }

        int[] dist = new int[d+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[0] = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> Integer.compare(o1[1], o2[1]));
        pq.offer(new int[] {0, 0});

        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int curPos = cur[0];
            int curDist = cur[1];

            if (curDist > dist[curPos]) continue;

            for (int[] edge : graph[curPos]) {
                int next = edge[0];
                int nextDist = edge[1];

                if (dist[curPos] + nextDist < dist[next]) {
                    dist[next] = dist[curPos] + nextDist;
                    pq.offer(new int[] {next, dist[next]});
                }
            }
        }

        System.out.print(dist[d]);
    }
}