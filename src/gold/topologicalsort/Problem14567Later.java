package gold.topologicalsort;

import java.io.*;
import java.util.*;

/*
선수과목을 들어야 특정 과목을 들을 수 있음.
1. 한 학기에 들을 수 있는 과목 수에는 제한 X.
2. 모든 과목은 매 학기 항상 개설됨.

모든 과목을 이수하려면 최소 몇 학기가 걸리는 지 계산하라.

<입력>
N, M
- N: 선수 과목의 수 (1 ~ 10^3)
- M: 선수 조건의 수 (0 ~ 10^5)
A, B
- A번 과목이 B과목의 선수 과목.
 */

public class Problem14567Later {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        List<Integer>[] graph = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        int[] indegree = new int[n + 1];
        int[] semester = new int[n + 1];
        Arrays.fill(semester, 1);

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[a].add(b);
            indegree[b]++;
        }

        Deque <Integer> dq = new ArrayDeque<>();
        for (int i = 1; i <= n; i++) {
            if (indegree[i] == 0) dq.addLast(i);
        }

        while (!dq.isEmpty()) {
            int cur = dq.pollFirst();

            for (int next: graph[cur]) {
                semester[next] = Math.max(semester[next], semester[cur] + 1);

                indegree[next]--;
                if (indegree[next] == 0) dq.addLast(next);
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            sb.append(semester[i]).append(' ');
        }
        System.out.print(sb);

    }
}
