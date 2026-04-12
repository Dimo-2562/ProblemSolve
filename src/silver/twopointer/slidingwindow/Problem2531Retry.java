package silver.twopointer.slidingwindow;

import java.io.*;
import java.util.*;

/*
1. k개의 접시를 연속해서 먹을 경우 할인된 가격으로 제공
2. 1번 행사에 참여할 경우 쿠폰에 적힌 초밥 하나를 무료로 제공.

<입력>
N, d, k, c
- N: 접시의 수 (2 ~ 10^4)
- d: 초밥의 가짓수 (2 ~ 10^3)
- k: 연속해서 먹는 접시의 수 (2 ~ 10^3)
- c: 쿠폰 번호 (1 ~ 10^3)

<출력>
회전 초밥 벨트에서 먹을 수 있는 초밥의 가짓수의 최댓값

슬라이딩 윈도우
int[] 배열
 */

public class Problem2531Retry {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        int[] dish = new int[n];
        for (int i = 0; i < n; i++) {
            dish[i] = Integer.parseInt(br.readLine());
        }

        int[] sushi = new int[d+1];
        int cnt = 0;
        for (int i = 0; i < k; i++) {
            if (sushi[dish[i]] == 0) cnt++;
            sushi[dish[i]]++;
        }

        if (sushi[c] == 0) cnt++;
        sushi[c]++;

        int max = cnt;
        for (int i = 1; i < n; i++) {
            if (sushi[dish[i-1]] == 1) cnt--;
            sushi[dish[i-1]]--;

            if (sushi[dish[(k + i - 1) % n]] == 0) cnt++;
            sushi[dish[(k + i - 1) % n]]++;

            max = Math.max(max, cnt);
        }

        System.out.print(max);
    }
}
