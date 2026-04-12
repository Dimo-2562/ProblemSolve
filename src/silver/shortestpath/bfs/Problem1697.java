package silver.shortestpath.bfs;

import java.io.*;
import java.util.*;

/*
현재 점 N
동생은 점 K

걷기 or 순간이동
걷기: 1초 후 -> X-1, X+1
순간이동: 1초 후 -> 2*X

동생을 찾을 수 있는 가장 빠른 시간을 구하라.

<입력>
N, K
- N: 수빈이가 있는 위치 (0 ~ 10^5)
- K: 동생이 있는 위치 (0 ~ 10^5)

<출력>
수빈이가 동생을 찾을 수 있는 가장 빠른 시간을 구하라.

간선의 가중치가 모두 1인 그래프 탐색
- BFS
- 다익스트라

 */

public class Problem1697 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        boolean[] visited = new boolean[200002];
        int[] dist = new int[200002];
        Deque<Integer> dq = new ArrayDeque<>();

        dq.addLast(n);
        visited[n] = true;
        dist[n] = 0;

        while (!dq.isEmpty()) {
            int cur = dq.pollFirst();

            int[] next = {cur - 1, cur + 1, cur * 2};

            for (int tmp : next) {
                if (tmp < 0 || tmp > 100000) continue;
                if (visited[tmp]) continue;

                visited[tmp] = true;
                dist[tmp] = dist[cur] + 1;
                dq.addLast(tmp);
            }
        }

        System.out.print(dist[k]);
    }
}
