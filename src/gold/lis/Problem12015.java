package gold.lis;

import java.io.*;
import java.util.*;

public class Problem12015 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int[] longArr = new int[n];
        int len = 0;
        for (int num : arr) {
            int pos = lowerbound(longArr, 0, len, num);
            longArr[pos] = num;
            if (pos == len) len++;
        }

        System.out.println(len);
    }

    private static int lowerbound(int[] arr, int start, int end, int num) {
        while (start < end) {
            int mid = (start + end) / 2;
            if (arr[mid] < num) start = mid + 1;
            else end = mid;
        }
        return start;
    }
}
