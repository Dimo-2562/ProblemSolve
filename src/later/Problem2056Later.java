package later;

import java.io.*;
import java.util.*;

/*
수행해야할 작업 N개
각각의 작업마다 걸리는 시간이 주어짐.
선행 관계 -> 위상 정렬

모든 작업을 완료하기 위해 필요한 최소 시간을 구하라.

<입력>
N
- N: 수행해야 할 작업 (3 ~ 10^4)
작업에 걸리는 시간, 선행 관계인 작업들의 개수, 그리고 그 번호
- 작업에 걸리는 시간 (1 ~ 10^2)
- N+1번째 줄이 N번 작업.

<출력>
모든 작업을 완료하기 위한 최소 시간을 출력하라.
 */

public class Problem2056Later {
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
            int num = Integer.parseInt(st.nextToken());
            for (int j = 0; j < num; j++) {
                int prev = Integer.parseInt(st.nextToken());
                graph[prev].add(i);
                indegree[i]++;
            }
        }

        Deque<Integer> dq = new ArrayDeque<>();
        for (int i = 1; i <= n; i++) {
            if (indegree[i] == 0) {
                answer[i] = cost[i];
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
        for (int num: answer) {
            max = Math.max(max, num);
        }
        System.out.print(max);
    }
}
