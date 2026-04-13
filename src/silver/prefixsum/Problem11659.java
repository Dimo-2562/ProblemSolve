package silver.prefixsum;

import java.io.*;
import java.util.*;

/*
수 N개가 주어졌을 때, i ~ j까지 수의 합을 구하라.

<입력>
N, M
- N: 수의 개수 (1 ~ 10^5)
- M: 합을 구해야 하는 횟수 (1 ~ 10^5)
수들
- N개
- 값의 범위 (1 ~ 10^3)
i, j (M개의 줄)
- 값을 구해야하는 구간.
- 1 <= i <= j <= N

<출력>
i ~ j 까지 수의 합 (M개의 줄)
 */

public class Problem11659 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] arr = new int[n + 1];
        int[] sum = new int[n + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            sum[i] = sum[i - 1] + arr[i];
        }

        StringBuilder sb = new StringBuilder();
        while (m-- > 0) {
            st = new StringTokenizer(br.readLine());

            int i = Integer.parseInt(st.nextToken());
            int j = Integer.parseInt(st.nextToken());
            sb.append(sum[j] - sum[i - 1]).append('\n');
        }

        System.out.print(sb);
    }
}