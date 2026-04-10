package silver.dp;

import java.io.*;
import java.util.*;

/*
<입력>
N D
- N: 지름길의 개수 (1 ~ 12)
- D: 고속도로의 길이 (1 ~ 10^4)
시작, 도착, 길이 (N개의 줄)
- 값 (1 ~ 10^4)

<출력>
거리의 최솟값을 구하라.

고속도로 역주행 불가. -> 도착점이 D보다 크면 지름길 제거.
지름길이 아닌 지름길도 존재함. -> 도착 - 시작 < 길이 면 제거.

풀이 방식이 떠오르지 않음..
 */

public class Problem1446Later {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());

        List<int[]>[] shortcuts = new ArrayList[d + 1];
        for (int i = 0; i <= d; i++) shortcuts[i] = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            if (to > d || to - from < cost) continue;

            shortcuts[to].add(new int[]{from, cost});
        }

        int[] dp = new int[d + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        for (int i = 1; i <= d; i++) {
            dp[i] = dp[i-1] + 1;

            for (int[] shortcut: shortcuts[i]) {
                int from = shortcut[0];
                int cost = shortcut[1];
                dp[i] = Math.min(dp[i], dp[from] + cost);
            }
        }

        System.out.print(dp[d]);
    }
}