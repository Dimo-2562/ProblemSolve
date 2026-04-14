package gold.dp;

import java.io.*;
import java.util.*;

/*
배낭 문제

N개의 물건
각 물건은 무게 W, 가치 V
K만큼의 무게까지만 가능
가치를 최대로 하도록 담아보자!

<입력>
N, K
- N: 물품의 수 (1 ~ 10^2)
- K: 버틸 수 있는 무게 (1 ~ 10^5)
W, V (N개의 줄)
- W: 물건의 무게 (1 ~ 10^5)
- V: 물건의 가치 (0 ~ 10^3)

<출력>
가치합의 최댓값

<풀이>
2차원 DP
무게 순으로 정렬
dp[i][j] = i번째 물건까지 사용했을 때, j 무게로 가능한 것.
dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j - item[0]] + item[1])
 */

public class Problem12865Retry {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] dp = new int[k + 1];
        List<int[]> itemList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            int w = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            itemList.add(new int[]{w, v});
        }

        for (int i = 1; i <= n; i++) {
            int[] item = itemList.get(i - 1);
            for (int j = k; j >= 1; j--) {
                if (j >= item[0]) dp[j] = Math.max(dp[j], dp[j - item[0]] + item[1]);
            }
        }

        System.out.println(dp[k]);
    }
}
