package lv3.mst;

import java.util.*;

/*
n개의 섬 사이에 다리를 건설하는 비용이 주어질 때,
최소의 비용으로 모든 섬이 통행 가능하도록 하고 비용을 return 하라

<입력>
n
- n: 섬의 개수 (1 ~ 10^2)
costs
- costs: 간선 비용 (1 ~ 10^4)
- 시작, 종료, 가중치
- 같은 연결은 두번 주어지지 않는다
- 순서가 바뀌더라도 같은 연결로 본다.

<출력>
다 돌 수 있는 최소의 비용

<풀이>
가중치가 다양 -> 다익스트라

풀이 봄

모든 정점을 연결하는 최소 비용 -> MST (크루스칼)
1. 간선 가중치 기준 정렬.
2. 사이클이 안 생기도록 하며 간선 선택
3. n - 1번 반복하면 끝내기.

*/

class 섬연결하기Later {
    static int[] parent;

    public int solution(int n, int[][] costs) {
        parent = new int[n];
        for (int i = 0; i < n; i++) parent[i] = i;

        // 1. 간선 가중치 기준 정렬
        Arrays.sort(costs, (o1, o2) -> o1[2] - o2[2]);

        int answer = 0;
        int cnt = 0;

        for (int[] edge : costs) {
            int a = edge[0];
            int b = edge[1];
            int cost = edge[2];

            if (find(a) != find(b)) {
                union(a, b);
                answer += cost;
                cnt++;
            }

            if (cnt == n-1) break;
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