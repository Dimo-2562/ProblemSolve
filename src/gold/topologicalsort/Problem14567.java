package gold.topologicalsort;

import java.io.*;
import java.util.*;

/*
Z대학
선수과목
한 학기 들을 수 있는 과목 수 제한 X.
모든 과목은 매 학기 개설

모든 과목을 이수하려고 할 때 최소 몇 학기가 걸리는가?

<입력>
N, M
- N: 과목의 수 (1 ~ 10^3)
- M: 선수 조건의 수 (0 ~ 10^5)
A, B (M개의 줄)
- A -> B로 수업을 들어야 함.
- A < B인 입력만 들어옴.

<출력>
1 ~ N까지 과목을 최소 몇 학기에 이수할 수 있는가?

<풀이>
위상 정렬
int[] indegree
graph[s].add(e)
 */

public class Problem14567 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        List<Integer>[] graph = new ArrayList[n + 1];
        int[] indegree = new int[n + 1];
        int[] cost = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        int m = Integer.parseInt(st.nextToken());
        while (m-- > 0) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            graph[s].add(e);
            indegree[e]++;
        }

        Deque<Integer> dq = new ArrayDeque<>();
        for (int i = 1; i <= n; i++) {
            if (indegree[i] == 0) {
                dq.addLast(i);
                cost[i] = 1;
            }
        }

        while (!dq.isEmpty()) {
            int cur = dq.pollFirst();

            for (int next : graph[cur]) {
                cost[next] = Math.max(cost[cur] + 1, cost[next]);
                indegree[next]--;
                if (indegree[next] == 0) {
                    dq.addLast(next);
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            sb.append(cost[i]).append(' ');
        }
        System.out.print(sb);

    }
}
