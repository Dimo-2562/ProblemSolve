package gold.topologicalsort;

import java.io.*;
import java.util.*;

/*
N개의 작업과 각각의 걸리는 시간
선행 관계

<입력>
N
- N: 작업의 개수 (3 ~ 10^4)
걸리는 시간, 선행 작업 개수, 선행 작업 번호들(...) (N개의 줄)
- 걸리는 시간 (1 ~ 10^2)
- 선행 작업 개수 (0 ~ 10^2)

<출력>
모든 작업을 완료하기 위한 최소 시간을 출력하라.

<풀이>
위상 정렬
 */

public class Problem2056 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        List<Integer>[] graph = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }
        int[] indegree = new int[n + 1];
        int[] cost = new int[n + 1];
        int[] answer = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            cost[i] = Integer.parseInt(st.nextToken());
            answer[i] = cost[i];
            int preNum = Integer.parseInt(st.nextToken());
            for (int j = 0; j  < preNum; j++) {
                int pre = Integer.parseInt(st.nextToken());
                graph[pre].add(i);
                indegree[i]++;
            }
        }

        Deque <Integer> dq = new ArrayDeque<>();
        for (int i = 1; i <= n; i++) {
            if (indegree[i] == 0) {
                dq.addLast(i);
            }
        }

        while (!dq.isEmpty()) {
            int cur = dq.pollFirst();

            for (int next: graph[cur]) {
                answer[next] = Math.max(answer[next], answer[cur] + cost[next]);

                indegree[next]--;
                if (indegree[next] == 0) {
                    dq.addLast(next);
                }
            }
        }

        int max = -1;
        for (int i = 1; i <= n; i++) {
            max = Math.max(max, answer[i]);
        }
        System.out.print(max);

    }
}
