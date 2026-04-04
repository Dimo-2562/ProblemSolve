package gold.topologicalsort;

import java.io.*;
import java.util.*;

/*
1번부터 N번까지 N개의 문제.
문제는 난이도 순서로 출제됨. 1번이 제일 쉽고, N번이 가장 어려움.

문제들 사이의 순서가 존재.
가능하면 쉬운 문제부터.
PriorityQueue를 쓴다면..? (문제 번호)

<입력>
N, M
- N: 문제의 수 (1 ~ 10^4)
- M: 정보의 개수 (1 ~ 10^5)
A, B (M개의 줄)

<출력>
풀어야 하는 순서를 빈칸을 사이에 두고 출력.
 */

public class Problem1766 {
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

        while (m-- > 0) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[a].add(b);
            indegree[b]++;
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int i = 1; i <= n; i++) {
            if (indegree[i] == 0) {
                pq.add(i);
            }
        }

        StringBuilder sb = new StringBuilder();
        while (!pq.isEmpty()) {
            int cur = pq.poll();
            sb.append(cur).append(' ');

            for (int next : graph[cur]) {

                indegree[next]--;
                if (indegree[next] == 0) pq.add(next);
            }
        }

        System.out.print(sb);
    }
}
