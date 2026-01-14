package silver.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Problem15654 {
    static int n, m;
    static int[] numArr, selected;
    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        numArr = new int[n];
        visited = new boolean[n];
        selected = new int[m];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            numArr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(numArr);

        backTracking(0);

        System.out.print(sb);
    }

    static void backTracking(int depth){
        if (depth == m) {
            for (int i = 0; i < selected.length; i++) {
                sb.append(selected[i]).append(' ');
            }
            sb.append('\n');
            return;
        }

        for (int i = 0; i < numArr.length; i++){
            if (!visited[i]) {
                visited[i] = true;
                selected[depth] = numArr[i];
                backTracking(depth + 1);
                visited[i] = false;
            }
        }
    }
}
