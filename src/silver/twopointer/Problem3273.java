package silver.twopointer;

import java.io.*;
import java.util.*;

/*
n개의 서로 다른 양의 정수
각 정수 (1 ~ 10^6)

x가 주어졌을 때 두 정수의 합이 x가 되는 것을 만족하는 쌍의 개수를 구하라.
(i < j)

<입력>
n
- n: 수열의 크기 (1 ~ 10^5)
정수들
- (1 ~ 10^6)
X
- 합쳐서 되야하는 값 (1 ~ 10^6)

<출력>
조건을 만족하는 쌍의 개수

<풀이>
int 범위로 해결됨.

O(NlogN)까진 가능.

정렬.
양 끝단에서 투포인터 -> O(N)으로 해결.

 */

public class Problem3273 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int x = Integer.parseInt(br.readLine());

        Arrays.sort(arr);

        int start = 0;
        int end = arr.length - 1;

        int cnt = 0;
        while (start < end) {
            int sum = arr[start] + arr[end];

            if (sum == x) {
                cnt++;
                start++;
                end--;
            } else if(sum > x) {
                end--;
            } else {
                start++;
            }
        }

        System.out.print(cnt);
    }
}
