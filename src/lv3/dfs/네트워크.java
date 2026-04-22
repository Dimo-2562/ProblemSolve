package lv3.dfs;

/*
네트워크 

<입력>
n
- n: 컴퓨터의 개수 (1 ~ 10^2)
computers
- computeres: 연결에 대한 정보
- (0 ~ n-1)
- 연결이 되어있으면 1로 표현

<출력>
네트워크의 개수를 return 하라.

<풀이>
bfs or dfs로 찾기.
*/

import java.util.*;

class 네트워크 {
    static boolean[] visited;
    static List<Integer>[] graph;

    public int solution(int n, int[][] computers) {
        visited = new boolean[n];
        graph = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j) continue;
                if (computers[i][j] == 1) {
                    graph[i].add(j);
                }
            }
        }

        int answer = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (computers[i][j] == 1 && !visited[i] && !visited[j]) {
                    dfs(i);
                    answer++;
                }
            }
        }

        return answer;
    }

    void dfs(int start) {
        if (visited[start]) return;

        visited[start] = true;

        for (int num: graph[start]) {
            dfs(num);
        }
    }
}