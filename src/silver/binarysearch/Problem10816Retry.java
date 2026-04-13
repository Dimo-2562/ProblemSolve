package silver.binarysearch;

import java.io.*;
import java.util.*;

/*
숫자 카드 = 정수가 적힌 카드
N개의 카드를 가짐.
M개의 정수가 주어졌을 때, 이 수가 적혀잇는 숫자 카드를 몇 개 가지고 있는가?

<입력>
N
- N: 숫자 카드의 개수 (1 ~ 10^5)
숫자 카드에 적힌 수들
- 값의 범위 (-10^7 ~ 10^7)
M
- M: 주어지는 정수의 개수 (1 ~ 10^5)
주어지는 숫자들
- 숫자들의 범위 (-10^7 ~ 10^7)

<출력>
M개의 수에 대해서 각 수가 적힌 숫자 카드를 몇 개 가지고 있는가?

<풀이>
lowerbound, upperbound의 차로 푸는 문제
N개의 숫자들을 정렬. 이분탐색
 */

public class Problem10816Retry {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] card = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            card[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(card);

        StringBuilder sb = new StringBuilder();
        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            int num = Integer.parseInt(st.nextToken());

            int cnt = upperbound(num, card) - lowerbound(num, card);
            sb.append(cnt).append(' ');
        }

        System.out.print(sb);
    }

    static int upperbound(int target, int[] arr) {
        int lo = 0;
        int hi = arr.length;

        while (lo < hi) {
            int mid = (lo + hi) / 2;

            if (arr[mid] > target) {
                hi = mid;
            } else {
                lo = mid + 1;
            }
        }

        return lo;
    }

    static int lowerbound(int target, int[] arr) {
        int lo = 0;
        int hi = arr.length;

        while (lo < hi) {
            int mid = (lo + hi) / 2;

            if (arr[mid] >= target) {
                hi = mid;
            } else {
                lo = mid + 1;
            }
        }

        return lo;
    }
}
