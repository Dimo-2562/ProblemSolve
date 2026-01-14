package silver.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem15652 {
    static int n, m;
    static int[] numArr;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        numArr = new int[m];

        backTracking(0, 1);

        System.out.print(sb);
    }

    static void backTracking(int depth, int start) {
        if (depth == m) {
            for (int i = 0; i < numArr.length; i++) {
                sb.append(numArr[i]).append(' ');
            }
            sb.append('\n');
            return;
        }

        for (int i = start; i <= n; i++){
            numArr[depth] = i;
            backTracking(depth + 1, i);
        }
    }
}
