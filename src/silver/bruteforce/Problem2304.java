package silver.bruteforce;

import java.io.*;
import java.util.*;

/*
<입력>
N
- N: 기둥의 개수 (1 ~ 10^3)
L, H (N개의 줄)
- L: 가장 왼쪽 면의 위치 (1 ~ 10^3)
- H: 높이 (1 ~ 10^3)

브루트포스.
1. 첫번째 값 기준으로 오름차순 정렬

2 4
4 6
5 3
8 10
11 4
13 6
15 8
 */

public class Problem2304 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int left = Integer.parseInt(st.nextToken());
            int height = Integer.parseInt(st.nextToken());
            list.add(new int[]{left, height});
        }

        list.sort(Comparator.comparingInt(o -> o[0]));

        int max = 0;
        for (int i = 0; i < n; i++) {
            max = Math.max(max, list.get(i)[1]);
        }

        int maxLeft = -1, maxRight = 0;
        for (int i = 0; i < n; i++) {
            if (list.get(i)[1] == max) {
                if (maxLeft == -1) maxLeft = i;
                maxRight = i;
            }
        }

        int[] prev = list.get(0);
        int sum = 0;
        for (int i = 1; i <= maxLeft; i++) {
            int[] next = list.get(i);

            if (next[1] >= prev[1]) {
                sum += (next[0] - prev[0]) * prev[1];
                prev = next;
            }
        }

        sum += (list.get(maxRight)[0] - list.get(maxLeft)[0] + 1) * max;

        prev = list.get(n-1);
        for (int i = n-2; i >= maxRight; i--) {
            int[] next = list.get(i);

            if (next[1] >= prev[1]) {
                sum += (prev[0] - next[0]) * prev[1];
                prev = next;
            }
        }

        System.out.println(sum);
    }
}
