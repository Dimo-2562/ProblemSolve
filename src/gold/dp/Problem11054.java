package gold.dp;

import java.io.*;
import java.util.*;

/*
단조 증가 + 단조 감소인 수열일 때 바이토닉 수열이라고 함.

수열 A가 주어졌을 때 바이토닉 수열이면서 가장 긴 수열의 길이를 구하라.

<입력>
N
- N: 수열 A의 크기 (1 ~ 10^3)
수열 A의 원소들
- 값의 범위 (1 ~ 10^3)

<출력>
가장 긴 바이토닉 수열의 길이를 구하라.

<풀이>
n이 10^3이므로 2중 for문 가능.

dpUp[i] = i를 끝으로 하는 가장 긴 증가하는 부분 수열
dpDown[i] = i를 끝으로 하는 가장 긴 감소하는 부분 수열 (반대 방향)
 */

public class Problem11054 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int[] dp = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            dp[i] = 1;
            for (int j = 1 ; j < i; j++) {
                if (arr[i] > arr[j]) dp[i] = Math.max(dp[i], dp[j] + 1);
            }
        }

        int[] dpDown = new int[n + 1];
        for (int i = n; i >= 1; i--) {
            dpDown[i] = 1;
            for (int j = i + 1; j <= n; j++) {
                if (arr[i] > arr[j]) dpDown[i] = Math.max(dpDown[i], dpDown[j] + 1);
            }
        }

        int answer = -1;
        for (int i = 1; i <= n; i++) {
            answer = Math.max(dp[i] + dpDown[i] - 1, answer);
        }
        System.out.print(answer);
    }
}
