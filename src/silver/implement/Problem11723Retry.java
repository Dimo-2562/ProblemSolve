package silver.implement;

import java.io.*;
import java.util.*;

public class Problem11723Retry {

    static boolean[] arr = new boolean[21];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int m = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String com = st.nextToken();
            int val = 0;
            if(st.hasMoreTokens()) val = Integer.parseInt(st.nextToken());

            switch (com) {
                case "add": arr[val] = true; break;
                case "remove": arr[val] = false; break;
                case "check": sb.append(arr[val] ? 1 : 0).append('\n'); break;
                case "toggle": arr[val] = !arr[val]; break;
                case "all": Arrays.fill(arr, true); break;
                case "empty": Arrays.fill(arr, false); break;
            }
        }

        System.out.println(sb);

    }
}
