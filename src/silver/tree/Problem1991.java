package silver.tree;

import java.io.*;
import java.util.*;

public class Problem1991 {
    static StringBuilder sb = new StringBuilder();

    static int[] left = new int[26];
    static int[] right = new int[26];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int idx = st.nextToken().charAt(0) - 'A';
            int l = st.nextToken().charAt(0) - 'A';
            int r = st.nextToken().charAt(0) - 'A';
            left[idx] = l;
            right[idx] = r;
        }

        preOrder(0);
        sb.append('\n');
        inOrder(0);
        sb.append('\n');
        postOrder(0);
        System.out.print(sb);
    }

    private static void preOrder(int node) {
        if (node + 'A' == '.') return;
        sb.append((char)(node + 'A'));
        preOrder(left[node]);
        preOrder(right[node]);
    }

    private static void inOrder(int node) {
        if (node + 'A' == '.') return;
        inOrder(left[node]);
        sb.append((char)(node + 'A'));
        inOrder(right[node]);
    }

    private static void postOrder(int node) {
        if (node + 'A' == '.') return;
        postOrder(left[node]);
        postOrder(right[node]);
        sb.append((char)(node + 'A'));
    }
}
