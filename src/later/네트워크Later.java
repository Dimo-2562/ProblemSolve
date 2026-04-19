package later;

import java.io.*;
import java.util.*;

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
유니온 파인드 문제
*/

public class 네트워크Later {
    static int[] parent = new int[201];

    public int solution(int n, int[][] computers) {
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(i == j) continue;

                if(computers[i][j] == 1) {
                    union(i, j);
                }
            }
        }

        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            set.add(find(i));
        }

        return set.size();
    }

    int find(int x) {
        if (parent[x] == x) return x;
        return parent[x] = find(parent[x]);
    }

    void union(int a, int b) {
        int rootA = find(a);
        int rootB = find(b);

        if (rootA != rootB) parent[rootB] = rootA;
    }
}
