package silver.backtracking;

import java.io.*;
import java.util.*;

/*
순열 풀이(백트래킹)
이전 값은 나오지 않도록. -> 정렬 후 prev 변수 이용.

N, M
- N: 자연수의 개수
- M: 길이

N개의 수 (1 ~ 10^4)
 */

public class Problem15663 {

    static int n, m;
    static int[] arr, selected;
    static boolean[] visited;

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n];
        selected = new int[m];
        visited = new boolean[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        // 백트래킹
        backTracking(0);

        System.out.print(sb);
    }

    static void backTracking(int depth) {
        if (depth == m) {
            for (int i = 0; i < m; i++) {
                sb.append(selected[i]).append(' ');
            }
            sb.append('\n');
            return;
        }

        int prev = -1;
        for (int i = 0; i < n; i++) {
            if (!visited[i] && prev != arr[i]) {
                visited[i] = true;
                selected[depth] = arr[i];
                prev = arr[i];
                backTracking(depth+1);
                visited[i] = false;
            }
        }
    }
}
