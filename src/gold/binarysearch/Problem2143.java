package gold.binarysearch;

import java.io.*;
import java.util.*;

/*
연속된 부분 배열의 합이 T가 되는 쌍의 개수를 구하라.

<입력>
T
- T: 합이 되어야 하는 수 (-10^9 ~ 10^9)
n
- n: A 배열의 원소의 개수 (1 ~ 10^3)
A[i]
- 원소의 범위 (-10^6 ~ 10^6)
m
- m: B 배열의 원소의 개수 (1 ~ 10^3)
B[i]

<출력>
가능한 쌍의 개수
- 없을 경우 0을 출력

<풀이>
연속된 부분 수열의 경우의 수를 모두 구하고
이분 탐색
 */

public class Problem2143 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());
        int n = Integer.parseInt(br.readLine());
        int[] numA = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            numA[i] = Integer.parseInt(st.nextToken());
        }

        int m = Integer.parseInt(br.readLine());
        int[] numB = new int[m];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            numB[i] = Integer.parseInt(st.nextToken());
        }

        List<Integer> listA = new ArrayList<>();
        List<Integer> listB = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = i; j < n; j++) {
                sum += numA[j];
                listA.add(sum);
            }
        }
        for (int i = 0; i < m; i++) {
            int sum = 0;
            for (int j = i; j < m; j++) {
                sum += numB[j];
                listB.add(sum);
            }
        }

        listB.sort((o1, o2) -> o1 - o2);

        long answer = 0;
        for (int num : listA) {
            int target = t - num;

            answer += upperbound(target, listB) - lowerbound(target, listB);
        }

        System.out.print(answer);
    }

    static int upperbound(int target, List<Integer> list) {
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

    static int lowerbound(int target, List<Integer> list) {
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
