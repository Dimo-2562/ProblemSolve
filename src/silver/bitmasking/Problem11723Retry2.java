package silver.bitmasking;

import java.io.*;
import java.util.*;

public class Problem11723Retry2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int m = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        int S = 0;
        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String com = st.nextToken();
            int val = 0;
            if (st.hasMoreTokens()) val = Integer.parseInt(st.nextToken());
            switch(com) {
                case "add":
                    S |= (1 << val);
                    break;
                case "remove":
                    S &= ~(1 << val);
                    break;
                case "check":
                    sb.append((S >> val) & 1).append('\n');
                    break;
                case "toggle":
                    S ^= (1 << val);
                    break;
                case "all":
                    S = (1 << 21) - 1;
                    break;
                case "empty":
                    S = 0;
                    break;
            }
        }

        System.out.print(sb);
    }
}
