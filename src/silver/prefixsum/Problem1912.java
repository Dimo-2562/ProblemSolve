package silver.prefixsum;

import java.io.*;
import java.util.*;

/*
n개의 정수
연속된 몇 개의 수를 택해서 구할 수 있는 합 중 가장 큰 합을 구하라.
단, 수는 1개 이상 선택하라.

<입력>
n
- n: 수열의 원소 개수 (1 ~ 10^5)
수열의 원소
- (-10^3 ~ 10^3)

<출력>
가장 큰 수열의 합.

<풀이>
슬라이딩 윈도우 -> 음수도 섞여있으므로 불가.
누적합

10 6 9 10 15 21 -14 -2 19 18
dp[n] = n번째 항을 반드시 포함할 때 가장 큰 누적합
 */

public class Problem1912 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] prefix = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            prefix[i] = prefix[i - 1] + Integer.parseInt(st.nextToken());
        }

        int minPrefix = 0;
        int answer = Integer.MIN_VALUE;
        for (int i = 1; i <= n; i++) {
            answer = Math.max(prefix[i] - minPrefix, answer);
            minPrefix = Math.min(minPrefix, prefix[i]);
        }

        System.out.print(answer);
    }
}
