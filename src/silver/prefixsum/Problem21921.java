package silver.prefixsum;

import java.io.*;
import java.util.*;

/*
X일동안 가장 많이 들어온 방문자 수와 그 기간들

<입력>
N, X
- N: 시작하고 지난 일수 (1 ~ 10^5)
- X: 문제에서 요구하는 날짜 (1 ~ 10^5)
하루 방문자 수 (0 ~ 10^3)

<출력>
X일 동안 가장 많이 들어온 방문자 수
- 0명이라면 SAD 출력
- 0명이 아닐경우 둘째 줄에 기간이 몇 개인지도 출력.

브루트포스 -> 10^10 (X)
누적합 -> 10^5

 */

public class Problem21921 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());

        int[] sum = new int[n+1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            sum[i] += sum[i-1] + Integer.parseInt(st.nextToken());
        }

        int cnt = 0;
        int max = 0;
        for (int i = x; i <= n; i++) {
            if (max < sum[i] - sum[i-x]) {
                max = sum[i] - sum[i-x];
                cnt = 1;
            } else if (max == sum[i] - sum[i-x]) {
                cnt++;
            }
        }

        if (max == 0) {
            System.out.println("SAD");
            return;
        }

        System.out.println(max + "\n" + cnt);
    }
}
