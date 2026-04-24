package lv3.mst;

import java.util.*;

/*
n개의 섬 사이에 다리를 건설하는 비용
최소 비용으로 모든 섬이 서로 통행 가능하도록 하는 비용 return

<입력>
n
- n: 섬의 개수 (1 ~ 10^2)
costs
- costs: 주어지는 비용들 (0 ~ 10^4)
- [u, v, cost]
- 같은 연결은 주어지지 않음
- 항상 모두 연결 가능함.

<출력>
최소 비용 return

<풀이>
MST -> 크루스칼 알고리즘
오름차순 기준 정렬
n-1번 간선
*/

class 섬연결하기 {
    static int[] parent;

    public int solution(int n, int[][] costs) {
        parent = new int[n];
        for (int i = 0; i < n; i++) parent[i] = i;

        Arrays.sort(costs, (o1, o2) -> o1[2] - o2[2]);

        int cnt = 0;
        int answer = 0;
        for (int[] cost : costs) {
            int u = cost[0];
            int v = cost[1];
            int c = cost[2];

            if (find(u) != find(v)) {
                union(u, v);
                answer += c;
                cnt++;
            }

            if (cnt == n - 1) break;
        }

        return answer;
    }

    int find(int x) {
        if (x == parent[x]) return x;
        return parent[x] = find(parent[x]);
    }

    void union(int a, int b) {
        int rootA = find(a);
        int rootB = find(b);

        if (rootA != rootB) parent[rootB] = rootA;

    }

}
