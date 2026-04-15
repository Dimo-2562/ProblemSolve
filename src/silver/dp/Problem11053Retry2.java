package silver.dp;

import java.io.*;
import java.util.*;

/*
가장 긴 증가하는 부분 수열을 구하라

<입력>
N
- N: 수열 A의 크기 (1 ~ 10^3)
수열의 원소들
- (1 ~ 10^3)

<출력>
가장 긴 증가하는 부분 수열의 길이

<풀이>
dp[i] = i를 끝으로 하는 가장 긴 증가하는 부분 수열
끝 정보가 중요함!


 */

public class Problem11053Retry2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] dp = new int[n];
        int[] arr = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.fill(dp, 1);

        int max = -1;
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[i] > arr[j]) dp[i] = Math.max(dp[i], dp[j] + 1);
            }
            max = Math.max(dp[i], max);
        }

        System.out.print(max);
    }
}
