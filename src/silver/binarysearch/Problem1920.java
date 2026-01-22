package silver.binarysearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Problem1920 {
    public static void main(String[] args) throws IOException {
        // N: 자연수 10^5
        // N개의 정수
        // M: 자연수 10^5
        // O(NlogN) -> 이분탐색

        // 입력 받기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // 정렬
        Arrays.sort(arr);

        // m 입력받고 출력
        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m; i++) {
            int num = Integer.parseInt(st.nextToken());
            sb.append(binarySearch(arr, num)).append('\n');
        }

        System.out.print(sb);
    }

    private static int binarySearch(int[] arr, int num) {
        int start = 0;
        int end = arr.length - 1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (arr[mid] > num) end = mid - 1;
            else if (arr[mid] == num) {
                return 1;
            } else {
                start = mid + 1;
            }
        }

        return 0;
    }
}
