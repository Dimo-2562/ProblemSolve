package silver.dp;

import java.io.*;
import java.util.*;

/*
a, b, c 셋 중 하나가 0 이하면 1
a, b, c 셋 중 하나가 20 초과면 w(20,20,20)

a < b < c면 w(a, b, c-1) + w(a, b-1, c-1) - w(a, b-1, c)
else
w(a-1, b, c) + w(a-1, b-1, c) + w(a-1, b, c-1) - w(a-1, b-1, c-1)

 */

public class Problem9184Later {
    static int[][][] dp = new int[21][21][21];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();
        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            if (a == -1 && b == -1 && c == -1) break;

            int answer = w(a, b, c);

            sb.append("w(").append(a).append(", ").append(b).append(", ").append(c)
                    .append(") = ").append(answer).append('\n');
        }

        System.out.print(sb);
    }

    static int w(int a, int b, int c) {
        if (a <= 0 || b <= 0 || c <= 0) return 1;
        if (a > 20 || b > 20 || c > 20) return w(20, 20, 20);

        if (dp[a][b][c] != 0) return dp[a][b][c];

        if (a < b && b < c) {
            dp[a][b][c] = w(a, b, c - 1) + w(a, b - 1, c - 1) - w(a, b - 1, c);
        } else {
            dp[a][b][c] = w(a - 1, b, c) + w(a - 1, b - 1, c)
                          + w(a - 1, b, c - 1) - w(a - 1, b - 1, c - 1);
        }
        return dp[a][b][c];
    }
}
