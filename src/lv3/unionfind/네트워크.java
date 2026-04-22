package lv3.unionfind;

import java.io.*;
import java.util.*;

/*
<입력>
n, int[][] computers
- n: 컴퓨터의 개수 (1 ~ 10^2)
- 숫자 (0 ~ n-1)
- computers: 인접 행렬

<출력>
네트워크의 개수를 return 하라

<풀이>
dfs or bfs
유니온 파인드
*/

class 네트워크 {
    static int[] parent;

    public int solution(int n, int[][] computers) {
        parent = new int[n];
        for (int i = 0; i < n; i++) parent[i] = i;

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (computers[i][j] == 1) union(i, j);
            }
        }

        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            set.add(find(i));
        }

        return set.size();
    }

    int find(int x) {
        if (x == parent[x]) return x;
        return parent[x] = find(parent[x]);
    }

    void union (int a, int b) {
        int rootA = find(a);
        int rootB = find(b);

        if(rootA != rootB) parent[rootB] = rootA;
    }
}