package silver.dp;

import java.io.*;
import java.util.*;

/*
재귀 함수 메모이제이션 문제

<입력>
a, b, c
- 모두 다 -1이면 종료
- (-50 ~ 50)

<출력>
w(a, b, c)

<풀이>
재귀 + 메모이제이션

 */

public class Problem9184 {
    static int[][][] dp = new int[51][51][51];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();
        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            if (a == -1 && b == -1 && c == -1) break;

            int num = w(a, b, c);
            sb.append("w(").append(a).append(", ").append(b).append(", ").append(c)
                    .append(") = ").append(num).append('\n');
        }

        System.out.print(sb);
    }

    static int w(int a, int b, int c) {
        if (a <= 0 || b <= 0 || c <= 0) return 1;
        if (a > 20 | b > 20 | c > 20) return w(20, 20, 20);

        if (dp[a][b][c] != 0) return dp[a][b][c];

        if (a < b && b < c) dp[a][b][c] = w(a, b, c - 1) + w(a, b - 1, c - 1) - w(a, b - 1, c);
        else dp[a][b][c] = w(a - 1, b, c) + w(a - 1, b - 1, c) + w(a - 1, b, c - 1) - w(a - 1, b - 1, c - 1);

        return dp[a][b][c];
    }
}
