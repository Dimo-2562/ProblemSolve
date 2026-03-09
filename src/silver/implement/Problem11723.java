package silver.implement;

import java.util.*;
import java.io.*;

public class Problem11723 {

    static boolean[] arr = new boolean[21];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int m = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            String com = st.nextToken();
            if (com.equals("add") || com.equals("remove")
                || com.equals("check") || com.equals("toggle")) {
                int val = Integer.parseInt(st.nextToken());

                if (com.equals("add")) {
                    arr[val] = true;
                } else if (com.equals("remove")) {
                    arr[val] = false;
                } else if (com.equals("check")) {
                    if(arr[val]) sb.append('1');
                    else sb.append('0');
                    sb.append('\n');
                } else {
                    arr[val] = !arr[val];
                }
            } else {
                if (com.equals("all")) {
                    Arrays.fill(arr, true);
                } else {
                    Arrays.fill(arr, false);
                }

            }
        }

        System.out.print(sb);
    }
}
