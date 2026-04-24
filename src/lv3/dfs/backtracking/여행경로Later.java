package lv3.dfs.backtracking;

import java.util.*;

/*
항공권을 모두 이용하여 여행 경로를 짜야한다.
ICN에서 출발

<입력>
tickets
- tickets: 항공권 정보
- 공항: 알파벳 대문자 3글자 (3 ~ 10^4)
- [a, b]: a -> b
- 반드시 모두 사용
- 경로가 두 개 이상일 경우 알파벳 순서가 앞서는 경로를 return

<출력>
방문하는 공항 경로

<풀이>
DFS

풀이 봄 -> 간선 기준 백트래킹

*/

class 여행경로Later {
    static boolean[] visited;
    static String[] picked;
    static boolean found = false;

    public String[] solution(String[][] tickets) {
        int n = tickets.length;
        picked = new String[n + 1];
        visited = new boolean[n];

        Arrays.sort(tickets, (o1, o2) -> {
            if (o1[0].equals(o2[0])) return o1[1].compareTo(o2[1]);
            return o1[0].compareTo(o2[0]);
        });

        picked[0] = "ICN";
        dfs(0, "ICN", n, tickets);

        return picked;
    }

    void dfs (int depth, String cur, int n, String[][] tickets) {
        if (found) return;

        if (depth == n) {
            found = true;
            return;
        }

        for (int i = 0; i < n; i++) {
            if (visited[i]) continue;

            String[] ticket = tickets[i];
            if (!ticket[0].equals(cur)) continue;

            visited[i] = true;
            picked[depth + 1] = ticket[1];
            dfs(depth + 1, ticket[1], n, tickets);

            if (found) return;
            visited[i] = false;
        }
    }
}