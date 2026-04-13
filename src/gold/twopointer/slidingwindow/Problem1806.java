package gold.twopointer.slidingwindow;

import java.io.*;
import java.util.*;

/*
10^4이하의 자연수로 이루어진 길이 N짜리 수열.
연속된 수들의 부분합 중에 그 합이 S 이상이 되는 것 중, 가장 짧은 것의 길이를 구하라.

<입력>
N, S
- N: 수열의 길이 (10 ~ 10^5)
- S: 합 (1 ~ 10^8)
수열
- 공백으로 구분
- 값의 범위 (1 ~ 10^4)

<출력>
최소의 길이를 출력, 불가능하다면 0을 출력

<풀이>
연속된 수열 -> 투포인터
right는 for문으로, left는 while문으로
int 범위 안에서 해결.
 */

public class Problem1806 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int left = 0;
        int sum = 0;
        int answer = Integer.MAX_VALUE;
        for (int right = 0; right < n; right++) {
            sum += arr[right];

            while (sum >= s) {
                answer = Math.min(answer, right - left + 1);
                sum -= arr[left];
                left++;
            }
        }

        System.out.print(answer == Integer.MAX_VALUE ? 0 : answer);
    }
}
