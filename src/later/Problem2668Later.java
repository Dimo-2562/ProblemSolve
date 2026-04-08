package later;

import java.io.*;
import java.util.*;

/*
N * 2 표
첫 번째 줄: 1 ~ N까지 차례대로 숫자 적혀있음.
두 번째 줄: 1 ~ N까지 숫자가 랜덤하게 들어가 있음 (중복 가능)

첫째 줄에서 적절히 숫자를 뽑으면 그 숫자들이 이루는 집합과
뽑힌 정수들의 바로 밑의 둘째 줄에 들어있는 정수들이 이루는 집합이 일치.

이 조건을 만족시키도록 정수들을 뽑되, 최대한 많이 뽑는 방법을 찾아라.

<입력>
N
- N: 가로 길이 (1 ~ 10^2)
표의 둘째 줄에 들어가는 정수들 (N개의 줄)

<출력>
뽑힌 정수들의 개수
뽑힌 정수들 (오름차순, 줄바꿈)

<풀이>
백트래킹 -> X.

같을 조건
1. 윗줄과 아랫줄이 동일
DFS로 돌면서 다시 복귀하면 됨.
 */

public class Problem2668Later {
    static boolean[] visited;
    static int[] graph;
    static List<Integer> answer = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        graph = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            int end = Integer.parseInt(br.readLine());
            graph[i] = end;
        }

        for (int i = 1; i <= n; i++) {
            visited = new boolean[n + 1];
            dfs(i, i);
        }

        answer.sort((o1, o2) -> Integer.compare(o1, o2));

        StringBuilder sb = new StringBuilder();
        sb.append(answer.size()).append('\n');
        for (int i = 0; i < answer.size(); i++) {
            sb.append(answer.get(i)).append('\n');
        }
        System.out.print(sb);

    }

    public static void dfs(int start, int cur) {
        visited[cur] = true;

        int next = graph[cur];

        if (!visited[next]) {
            dfs(start, next);
        } else {
            if (start == next) {
                answer.add(start);
            }
        }
    }
}
