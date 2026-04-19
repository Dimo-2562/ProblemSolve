package silver.bruteforce;

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

import java.io.*;
import java.util.*;

class 네트워크Retry {
    static boolean[] visited;

    public int solution(int n, int[][] computers) {
        visited = new boolean[n];

        int answer = 0;
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                dfs(i, computers, n);
                answer++;
            }
        }

        return answer;
    }

    void dfs(int now, int[][] computers, int n) {
        visited[now] = true;

        for (int next = 0; next < n; next++) {
            if (!visited[next] && computers[now][next] == 1) {
                dfs(next, computers, n);
            }
        }
    }
}