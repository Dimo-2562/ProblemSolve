package silver.binarysearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Problem1654 {
    public static void main(String[] args) throws IOException {
        // N개의 랜선을 만들어야 함
        // 길이가 다른 K개의 랜선
        // N개의 랜선의 길이를 찾는 과정

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int k = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        int[] arr = new int[k];
        for (int i = 0; i < k; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);

        long ans = binarySearch(arr, n);
        System.out.print(ans);
    }

    private static long binarySearch(int[] arr, int n) {
        long start = 1;
        long end = arr[arr.length - 1];
        while (start <= end) {
            long mid = (start + end) / 2;
            long num = 0;
            for (int i = 0; i < arr.length; i++) {
                num += arr[i] / mid;
            }

            if (num < n) end = mid - 1;
            else start = mid + 1;
        }

        return end;
    }
}
