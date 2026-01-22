package silver.binarysearch;

import java.io.*;
import java.util.*;

public class Problem10816 {
    public static void main(String[] args) throws IOException {
        // 숫자 카드 N개 (10^5)
        // 정수 M개 중 몇 개의 숫자 카드를 가지고 있는가? (10^5)

        // lowerbound, upperbound 쓰는 문제
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] card = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            card[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(card);

        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m; i++) {
            int num = Integer.parseInt(st.nextToken());
            int lower = lowerbound(card, num);
            int upper = upperbound(card, num);
            sb.append(upper - lower).append(' ');
        }

        System.out.print(sb);
    }

    private static int lowerbound(int[] arr, int num) {
        int start = 0;
        int end = arr.length;
        while (start < end) {
            int mid = (start + end) / 2;
            if (arr[mid] >= num) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }
        return start;
    }

    private static int upperbound(int[] arr, int num) {
        int start = 0;
        int end = arr.length;
        while (start < end) {
            int mid = (start + end) / 2;
            if (arr[mid] > num) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }
        return start;
    }
}
