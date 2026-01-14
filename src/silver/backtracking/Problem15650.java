package silver.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem15650 {
    static int n, m;
    static int[] selected;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        selected = new int[m];
        backTracking(0, 1);

        System.out.print(sb);
    }

    static void backTracking(int depth, int start){
        if (depth == m){
            for (int i = 0; i < selected.length; i++) {
                sb.append(selected[i]).append(' ');
            }
            sb.append('\n');
            return;
        }

        for (int i = start; i <= n; i++){
            selected[depth] = i;
            backTracking(depth + 1, i+1);
        }
    }
}
