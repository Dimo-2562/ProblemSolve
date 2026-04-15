package silver.twopointer.slidingwindow;

import java.io.*;
import java.util.*;

/*
연속적인 며칠 동안의 온도의 합이 가장 큰 값
온도 (음수 ~ 양수)

<입력>
N, K
- N: 온도를 측정한 전체 날짜의 수 (2 ~ 10^5)
- K: 합을 구하기 위한 연속적인 날짜의 수 (1 ~ 10 ^5)
온도
- (-10^2 ~ 10^2)

<출력>
K일의 온도의 합이 최대가 되는 값

<풀이>
연속적 -> 슬라이딩 윈도우
 */

public class Problem2559 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];

        int k = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int max = 0;
        for (int i = 0; i < k; i++) {
            max += arr[i];
        }

        int sum = max;
        int left = 0;
        for (int right = k; right < n; right++) {
            sum += arr[right];
            sum -= arr[left++];
            max = Math.max(sum, max);
        }

        System.out.print(max);
    }
}