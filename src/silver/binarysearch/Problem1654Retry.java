package silver.binarysearch;

import java.util.*;
import java.io.*;

public class Problem1654Retry {
    public static void main(String[] args) throws IOException {
        // N개의 랜선을 만들어야 한다. (1 ~ 10^6)
        // K개의 랜선을 가지고 있고, K개로 N개를 만들어야 한다. (1 ~ 10^4)
        // 만들 수 있는 최대 랜선의 길이. 즉 길이의 최댓값을 찾아라.

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int k = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        int[] line = new int[k];
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < k; i++) {
            line[i] = Integer.parseInt(br.readLine());
            max = Math.max(max, line[i]);
        }

        long ans = parametricSearch(line, n, max);
        System.out.print(ans);
    }

    private static long parametricSearch(int[] line, int n, int max) {
        long start = 1;
        long end = max;
        long ans = 0;

        while (start <= end) {
            long mid = (start + end) / 2;

            long sum = 0;
            for (int i = 0; i < line.length; i++) {
                sum += line[i] / mid;
            }

            if (sum >= n){
                ans = mid;
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        return ans;
    }
}
