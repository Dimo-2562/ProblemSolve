package gold.mitm;

import java.io.*;
import java.util.*;

/*
N개의 물건, C만큼의 무게를 담을 수 있는 가방
N개의 물건을 가방에 넣는 방법의 수를 구하라.

<입력>
N, C
- N: 물건의 개수 (1 ~ 30)
- C: 가방이 버티는 무게 (1 ~ 10^9)
물건들의 무게

<출력>
가방에 넣는 방법의 수를 출력.

<풀이>
백트래킹 -> 2^30 (x)
DP -> 10^9 -> (x)
MITM 적용

1. 절반 나눠서 백트래킹
2. 절반 중 하나만 이분탐색.
 */

public class Problem1450 {
    static int n, c;
    static int[] item;
    static List<Integer> leftList = new ArrayList<>();
    static List<Integer> rightList = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        item = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            item[i] = Integer.parseInt(st.nextToken());
        }

        // 1. 백트래킹
        backTracking(0, n / 2, 0, leftList);
        backTracking(n / 2, n, 0, rightList);

        rightList.sort((o1, o2) -> Integer.compare(o1, o2));

        // 2. 이분 탐색
        long sum = 0;
        for (int num : leftList) {
            int remain = c - num;

            if (remain < 0) continue;

            sum += upperbound(remain, rightList);
        }

        System.out.println(sum);
    }

    static void backTracking(int depth, int end, int sum, List<Integer> list) {
        if (sum > c) return;

        if (depth == end) {
            list.add(sum);
            return;
        }

        backTracking(depth + 1, end, sum, list);
        backTracking(depth + 1, end, sum + item[depth], list);
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
}