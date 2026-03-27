package silver.twopointer;

import java.io.*;
import java.util.*;

/*
같은 언소가 K개 이하로 들어있는 최장 연속 부분 수열의 길이

<입력>
N K
- N: 수열의 길이
- K: 같은 정수를 K개 이하로 포함.
수열의 원소
- 1 ~ 10^5 사이.

NlogN까지 괜찮.

처음부터 끝까지 탐색.
int[] num으로 숫자 개수 체크

만약에 k보다 커지면?
k인 수열로 시작.
int[] 배열의 값도 특정 숫자는 k로.
 */

public class Problem20922 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] numArr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            numArr[i] = Integer.parseInt(st.nextToken());
        }

        int[] numCnt = new int[100001];
        int max = -1;

        int left = 0;
        for (int right = 0; right < n; right++) {
            numCnt[numArr[right]]++;

            while (numCnt[numArr[right]] > k) {
                numCnt[numArr[left]]--;
                left++;
            }

            max = Math.max(max, right - left + 1);
        }

        System.out.print(max);
    }
}