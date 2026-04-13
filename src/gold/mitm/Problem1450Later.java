package gold.mitm;

import java.io.*;
import java.util.*;

/*
N개의 물건, 최대 C만큼의 무게
N개의 물건을 가방에 넣는 방법의 수를 구하라.

<입력>
N, C
- N: 물건의 개수 (1 ~ 30)
- C: 가방의 최대 무게 (0 ~ 10^9)
물건의 무게
- 무게의 범위 (1 ~ 10^9)

<출력>
가방에 넣는 경우의 수

<풀이>
long형으로 sum

접근 방식 몰라서 ai 활용
완탐 -> 2^30은 시간 초과
dp -> 10^9 배열은 불가능
2^15로 두 개를 나눈다면? -> 가능, MITM

1. 두 개로 분할
2. 각각의 케이스를 list에 담기
3. 하나는 고정한 채 하나를 이분탐색
4. 개수 체크.
 */

public class Problem1450Later {
    static int n, c;
    static int[] arr;
    static List<Integer> leftList = new ArrayList<>();
    static List<Integer> rightList = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        arr = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        makeSums(0, n/2, 0, leftList);
        makeSums(n/2, n, 0, rightList);

        rightList.sort((o1, o2) -> Integer.compare(o1, o2));

        long sum = 0;
        for (int num : leftList) {
            int remain = c - num;

            if (remain < 0) continue;

            sum += upperBound(remain, rightList);
        }

        System.out.print(sum);
    }

    public static void makeSums(int start, int end, int sum, List<Integer> list) {
        if (sum > c) return;

        if (start == end) {
            list.add(sum);
            return;
        }

        makeSums(start+1, end, sum, list);
        makeSums(start+1, end, sum + arr[start], list);
    }

    public static int upperBound(int target, List<Integer> list) {
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
