package lv3.dfs.backtracking;

import java.io.*;
import java.util.*;

/*
주어진 항공권을 모두 이용하여 여행경로를 짜려고 한다.
항상 ICN에서 출발

<입력>
tickets
- tickets: 항공권 정보 (3 ~ 10^4)
- [a, b]: a -> b
- 반드시 모두 사용해야 한다.
- 경로가 2개 이상일 경우 알파벳 순서가 앞서는 경로로 return
- 모든 도시는 반드시 방문할 수 있다.

<출력>
방문하는 공항 경로를 배열에 담아 return 하라.

<풀이>
종점 기준 정렬해놓기.

백트래킹(간선 기준)

*/

class 여행경로 {
    static boolean[] used;
    static String[] picked;
    static boolean flag = false;

    public String[] solution(String[][] tickets) {
        used = new boolean[tickets.length];
        picked = new String[tickets.length + 1];

        Arrays.sort(tickets, (o1, o2) -> {
            if (!o1[1].equals(o2[1])) return o1[1].compareTo(o2[1]);
            return o1[0].compareTo(o2[0]);
        });

        picked[0] = "ICN";
        dfs(0, "ICN", tickets);

        return picked;
    }

    void dfs(int depth, String cur, String[][] tickets) {
        if (flag) return;

        if (depth == tickets.length) {
            flag = true;
            return;
        }

        for (int i = 0; i < tickets.length; i++) {
            if (used[i]) continue;
            if (!tickets[i][0].equals(cur)) continue;

            String next = tickets[i][1];

            used[i] = true;
            picked[depth + 1] = next;

            dfs(depth + 1, next, tickets);

            if (flag) return;

            used[i] = false;
        }
    }
}