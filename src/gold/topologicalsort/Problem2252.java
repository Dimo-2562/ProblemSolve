package gold.topologicalsort;

import java.io.*;
import java.util.*;

/*
N명의 학생들을 키 순서대로 줄 세우려고 함.
두 학생간의 선행관계 그것도 일부만.

<입력>
N, M
- N: 학생들의 수 (1 ~ 10^4)
- M: 키 비교 횟수 (1 ~ 10^5)
A, B (M개의 줄)
- A가 B보다 먼저 와야 함.
- 1번부터 N번까지 학생들의 수 존재

<출력>
앞에서부터 줄을 세운 결과를 출력.
 */

public class Problem2252 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] indegree = new int[n + 1];
        List<Integer>[] graph = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        while (m-- > 0) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[a].add(b);
            indegree[b]++;
        }

        Deque<Integer> dq = new ArrayDeque<>();
        for (int i = 1; i <= n; i++) {
            if (indegree[i] == 0) {
                dq.addLast(i);
            }
        }

        StringBuilder sb = new StringBuilder();
        while (!dq.isEmpty()) {
            int cur = dq.pollFirst();
            sb.append(cur).append(' ');

            for (int next : graph[cur]) {

                indegree[next]--;
                if (indegree[next] == 0) dq.addLast(next);
            }
        }

        System.out.print(sb);
    }
}
