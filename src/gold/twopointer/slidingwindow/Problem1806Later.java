package gold.twopointer.slidingwindow;

import java.io.*;
import java.util.*;

/*
10^4 이하의 자연수로 이루어진 길이 N짜리 수열
연속된 수들의 부분합 중에 그 합이 S 이상이 되는 것 중, 가장 짧은 것의 길이를 구하는 프로그램을 작성.

<입력>
N, S
- N: 수열의 길이 (1 ~ 10^5)
- S: 기준점 (0 ~ 10^9)
수열
- 공백으로 구분
- 값의 범위 (1 ~ 10^4)

<출력>
구하고자 하는 최소의 길이
- 불가능할 경우 0을 출력.

<풀이>
int형 내에서 해결됨.

투포인터.
만약 합이 S를 못 넘기면 right++
합이 S를 넘기면 left++
그리고 그때 시점의 길이를 min이랑 비교.

만약 min이 초기값이면 0을 출력하도록.

구현 방식에서 애를 먹음.
 */

public class Problem1806Later {
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
        int min = Integer.MAX_VALUE;

        for (int right = 0; right < arr.length; right++) {
            sum += arr[right];

            while (sum >= s) {
                min = Math.min(min, right - left + 1);
                sum -= arr[left++];
            }
        }

        System.out.print(min == Integer.MAX_VALUE ? 0 : min);
    }
}
