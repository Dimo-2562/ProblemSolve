package gold.dfs;

import java.io.*;
import java.util.*;

/*
세로 두 줄
가로 N개의 칸

첫째 줄: 1 ~ N 순서대로
둘째 줄: 1 ~ N 랜덤하게 (중복 가능)
숫자를 적절히 뽑았을 때 집합이 일치하는 경우 중 제일 큰 것.

<입력>
N
- N: 칸의 개수 (1 ~ 10^2)
정수 (N개의 줄)

<출력>
뽑힌 정수들의 개수
뽑힌 정수들 (개수만큼)

<풀이>
DFS -> 처음 시작이랑 돌아오도록.
 */

public class Problem2668 {
    static int[] arr;
    static boolean[] visited;
    static int answer = 0;
    static List<Integer> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        arr = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        for (int i = 1; i <= n; i++) {
            visited = new boolean[n + 1];
            dfs(i, i);
        }

        list.sort((o1, o2) -> Integer.compare(o1, o2));

        StringBuilder sb = new StringBuilder();
        sb.append(list.size()).append('\n');
        for (int i = 0; i < list.size(); i++) {
            sb.append(list.get(i)).append('\n');
        }
        System.out.print(sb);

    }

    static void dfs(int start, int cur) {
        if (!visited[cur]) {
            visited[cur] = true;
            dfs(start, arr[cur]);
        } else if (cur == start) {
            list.add(start);
        }
    }
}
