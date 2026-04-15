package gold.shortestpath.bfs;

import java.io.*;
import java.util.*;

/*
N -> K
걷기: 1초 후 (-1 or +1)
순간이동: 1초 후 (2*X)

가장 빠른 내에 찾을 수 있는 시간이 몇 초 후인지, 그리고 그 방법이 몇 개인지.

<입력>
N, K
- N: 수빈이의 위치 (0 ~ 10^5)
- K: 동생의 위치 (0 ~ 10^5)

<출력>
가장 빠른 시간
방법의 수

가중치가 모두 1 -> BFS
int[] visited 배열
int[] dist
 */

public class Problem12851Later2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] visited = new int [200002];
        int[] dist = new int[200002];
        Arrays.fill(dist, Integer.MAX_VALUE);

        Deque<Integer> dq = new ArrayDeque<>();
        dq.addLast(n);
        dist[n] = 0;
        visited[n] = 1;

        while (!dq.isEmpty()) {
            int cur = dq.pollFirst();

            int[] ways = {cur + 1, cur - 1, cur * 2};

            for (int next: ways) {
                if (next < 0 || next > 100000) continue;

                if (dist[next] == dist[cur] + 1) {
                    visited[next] += visited[cur];
                } else if (dist[next] > dist[cur] + 1) {
                    dist[next] = dist[cur] + 1;
                    visited[next] = visited[cur];
                    dq.addLast(next);
                }
            }
        }

        System.out.println(dist[k]);
        System.out.print(visited[k]);
    }
}
