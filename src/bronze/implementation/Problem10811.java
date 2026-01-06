package bronze.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Problem10811 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] bucket = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            bucket[i] = i;
        }

        Deque<Integer> stack = new ArrayDeque<>();
        for (int k = 0; k < m; k++) {
            st = new StringTokenizer(br.readLine());
            int i = Integer.parseInt(st.nextToken());
            int j = Integer.parseInt(st.nextToken());
            for (int q = i; q <= j; q++) {
                stack.push(bucket[q]);
            }
            for (int q = i; q <= j; q++) {
                bucket[q] = stack.pop();
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++){
            if (i > 1) sb.append(" ");
            sb.append(bucket[i]);
        }
        System.out.println(sb);

    }
}