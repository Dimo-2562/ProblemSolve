package silver.binarysearch;

import java.io.*;
import java.util.*;

/*
모든 요청이 배정될 수 있으면 그대로 배정
배정될 수 없으면 상한액을 계산하여 그 이상의 요청에는 상한액을 배정.

이분 탐색

N
- N: 지방의 수 (3 ~ 10^4)
N개의 정수
- 지방의 예산 요청 (1 ~ 10^5)
M
- M: 총 에산 (1 ~ 10^9)
 */

public class Problem2512 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] req = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            req[i] = Integer.parseInt(st.nextToken());
        }
        int m = Integer.parseInt(br.readLine());

        Arrays.sort(req);

        int left = 0;
        int right = req[n-1];
        int answer = 0;

        while (left <= right) {
            int mid = (left + right) / 2;

            int sum = 0;
            for (int i = 0; i < n; i++) {
                if (req[i] <= mid) sum += req[i];
                else sum += mid;
            }

            if (sum <= m) {
                left = mid + 1;
                answer = mid;
            } else {
                right = mid -1;
            }
        }

        System.out.print(answer);
    }
}
