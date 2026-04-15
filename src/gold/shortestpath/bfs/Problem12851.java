package gold.shortestpath.bfs;

import java.io.*;
import java.util.*;

/*
동생과 숨바꼭질
수빈이 : N
동생 : K
걷거나 순간이동 (비용 1)

위치가 주어졌을 때 동생을 찾을 수 있는 가장 빠른 시간
그리고 그 방법이 몇 가지인지

<입력>
N, K
- N: 수빈이의 위치 (0 ~ 10^5)
- K: 동생의 위치 (0 ~ 10^5)

<출력>
동생을 찾는 가장 빠른 시간
그 시간의 방법의 수

<풀이>
가중치가 모두 1 => BFS
int min
가짓수를 체크해야 하므로 int[] visited를 사용.
 */

public class Problem12851 {
    static final int MAX = 200_000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] visited = new int[MAX + 1];
        int[] cost = new int[MAX + 1];
        Arrays.fill(cost, Integer.MAX_VALUE);

        Deque<int[]> dq = new ArrayDeque<>();
        dq.add(new int[]{n, 0});
        visited[n] = 1;
        cost[n] = 0;

        while (!dq.isEmpty()) {
            int[] cur = dq.pollFirst();
            int pos = cur[0];
            int curCost = cur[1];

            for (int next : new int[]{pos - 1, pos + 1, pos * 2}) {
                if (next < 0 || next >= MAX) continue;

                if (cost[next] > curCost + 1) {
                    cost[next] = curCost + 1;
                    dq.addLast(new int[]{next, cost[next]});
                    visited[next] = visited[pos];
                } else if (cost[next] == curCost + 1) {
                    visited[next] += visited[pos];
                }
            }
        }

        System.out.println(cost[k]);
        System.out.println(visited[k]);
    }
}
