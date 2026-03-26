package silver.bfs;

import java.io.*;
import java.util.*;

/*
DFS, BFS

<입력>
N, M, V
- N: 정점의 개수 (1 ~ 10^3)
- M: 간선의 개수 (1 ~ 10^4)
- V: 탐색을 시작할 정점의 번호
두 정점의 번호 (M개의 줄)
- 여러 개의 간선이 있을 수도 있음. (중복은 제거)

<출력>
DFS 결과 (첫째 줄)
BFS 결과 (둘째 줄)
V부터 방문한 점을 순서대로 출력.

중복은 상관 x. -> visited로 처리됨.

boolean[] visited
List[]
 */

public class Problem1260 {

    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();
    static List<Integer>[] listArr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int v = Integer.parseInt(st.nextToken());

        listArr = new ArrayList[n+1];
        for (int i = 1; i <= n; i++) {
            listArr[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            listArr[start].add(end);
            listArr[end].add(start);
        }

        for (int i = 1; i <= n; i++) {
            listArr[i].sort(Comparator.comparingInt(o -> o));
        }

        // DFS
        visited = new boolean[n+1];
        dfs(v);
        sb.append('\n');

        // BFS
        Arrays.fill(visited, false);
        bfs(v);

        System.out.print(sb);
    }

    static void dfs(int start) {
        visited[start] = true; // 함수 시작할 때
        sb.append(start).append(' ');

        for (int next: listArr[start]) {
            if (!visited[next]) {
                dfs(next);
            }
        }
    }

    static void bfs(int start) {
        Deque<Integer> dq = new ArrayDeque<>();
        dq.addLast(start);
        visited[start] = true; // 처음 시작

        while(!dq.isEmpty()) {
            int now = dq.pollFirst();
            sb.append(now).append(' ');

            for (int next : listArr[now]) {
                if (!visited[next]) {
                    visited[next] = true; // 큐에 넣을 때
                    dq.addLast(next);
                }
            }
        }
    }
}
