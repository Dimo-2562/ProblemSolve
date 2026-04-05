package gold.twopointer;

import java.io.*;
import java.util.*;

/*
산성 용액과 알칼리 용액
산성 (1 ~ 10^9)
알칼리성 (-10^9 ~ -1)

특성값: 혼합에 사용된 각 용액의 특성값의 합.
두 개의 서로 다른 용액을 혼합하여 0에 가까운 용액을 만들고자 함.

<입력>
N
- N: 전체 용액의 수 (2 ~ 10^5)
특성값
- (-10^9 ~ 10^9)

<출력>
0에 가까운 걸 만들어내는 두 용액의 특성값을 출력하라.

<풀이>
정렬, 투 포인터
abs
 */

public class Problem2467 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] liquid = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            liquid[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(liquid);

        int start = 0;
        int end = liquid.length - 1;
        int absMin = Integer.MAX_VALUE;

        int leftIdx = start;
        int rightIdx = end;
        while (start < end) {
            int sum = liquid[start] + liquid[end];

            if (Math.abs(sum) < absMin) {
                absMin = Math.abs(sum);
                leftIdx = start;
                rightIdx = end;
            }

            if (sum > 0) {
                end--;
            } else {
                start++;
            }
        }

        System.out.print(liquid[leftIdx] + " " + liquid[rightIdx]);
    }
}
