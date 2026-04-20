package gold.binarysearch;

import java.io.*;
import java.util.*;

/*
두 수열이 주어졌을 때
두 부분 수열의 합이 T가 되는 것의 쌍의 개수를 구하라.

<입력>
T
- T: 합이 되어야 하는 숫자 (-10^9 ~ 10^9)
n
- n: A 수열의 원소 개수 (1 ~ 10^3)
A 수열의 원소
- (-10^6 ~ 10^6)
m
- m: B 수열의 원소 개수 (1 ~ 10^3)
B 수열의 원소
- (-10^6 ~ 10^6)

<출력>
개수를 출력하라.

<풀이>
하나의 부분수열의 합의 cnt 세기. (N^2)

B에서는 이분 탐색.
1 4 5 7
1 4 6
 */

public class Problem2143Later {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());
        int n = Integer.parseInt(br.readLine());
        int[] arrA = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arrA[i] = Integer.parseInt(st.nextToken());
        }

        int m = Integer.parseInt(br.readLine());
        int[] arrB = new int[m];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            arrB[i] = Integer.parseInt(st.nextToken());
        }

        List<Integer> listA = new ArrayList<>();
        List<Integer> listB = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = i; j < n; j++) {
                sum += arrA[j];
                listA.add(sum);
            }
        }
        for (int i = 0; i < m; i++) {
            int sum = 0;
            for (int j = i; j < m; j++) {
                sum += arrB[j];
                listB.add(sum);
            }
        }

        listA.sort((o1, o2) -> o1 - o2);

        long answer = 0;
        for (int num : listB) {
            int target = t - num;

            answer += upperbound(listA, target) - lowerbound(listA, target);
        }

        System.out.print(answer);
    }

    static int upperbound(List<Integer> list, int target) {
        int lo = 0;
        int hi = list.size();

        while (lo < hi) {
            int mid = (lo + hi) / 2;

            if (list.get(mid) > target) {
                hi = mid;
            } else {
                lo = mid + 1;
            }
        }
        return lo;
    }

    static int lowerbound(List<Integer> list, int target) {
        int lo = 0;
        int hi = list.size();

        while (lo < hi) {
            int mid = (lo + hi) / 2;

            if (list.get(mid) >= target) {
                hi = mid;
            } else {
                lo = mid + 1;
            }
        }
        return lo;
    }
}
