package silver.binarysearch;

import java.util.*;
import java.io.*;

public class Problem2805 {
    public static void main(String[] args) throws IOException {
        // M 미터가 필요.
        // 높이 H를 지정하면 H보다 높이가 높은 나무들이 잘림.
        // 필요한 만큼만 가져가지만 M미터 이상. 즉 H가 가장 크도록 최댓값을 구하기.

        // N: 나무의 수 (1 ~ 10^6)
        // M: 나무의 길이 (1 ~ 10^9)

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] tree = new int[n];
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            tree[i] = Integer.parseInt(st.nextToken());
            max = Math.max(max, tree[i]);
        }

        long ans = parametricSearch(tree, m, max);

        System.out.print(ans);
    }

    private static long parametricSearch(int[] tree, int m, int max) {
        long start = 0;
        long end = max;
        long ans = 0;

        while (start <= end) {
            long mid = (start + end) / 2;

            long sum = 0;
            for (int i = 0; i < tree.length; i++) {
                if (tree[i] > mid)
                    sum += (tree[i] - mid);
            }
            if (sum >= m) {
                ans = mid;
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return ans;
    }
}
