package silver.bruteforce;

import java.io.*;
import java.util.*;

/*
1. 임의의 한 위치부터 k개의 접시를 연속해서 먹을 경우 할인된 정액 가격
2. 1번 행사에 참여할 경우 쿠폰에 적힌 초밥 하나를 무료로 제공, 만약 벨트에 없을 경우, 직접 만들어 제공

가능한 다양한 종류의 초밥을 먹자.

<입력>
N, d, k, c
- N: 접시의 수 (2 ~ 10^4)
- d: 초밥의 가짓수 (2 ~ 10^3)
- k: 연속해서 먹는 접시의 수 (2 ~ 10^3)
- c: 쿠폰 번호 (1 ~ 10^3)
회전 초밥 (N개의 줄)

<출력>
주어진 회전 초밥 벨트에서 먹을 수 있는 초밥의 가짓수의 최댓값.

브루트포스
 */

public class Problem2531 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int num = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < num; i++) {
            list.add(Integer.parseInt(br.readLine()));
        }

        for (int i = 0; i < num; i++) {
            list.add(list.get(i));
        }

        // 전체 탐색
        int max = -1;
        for (int start = 0; start < num; start++) {
            boolean[] isServed = new boolean[d+1];

            for (int j = start; j < start+k; j++) {
                int s = list.get(j);
                isServed[s] = true;
            }
            isServed[c] = true;

            int cnt = 0;
            for (int j = 1; j <= d; j++) {
                if (isServed[j]) cnt++;
            }

            max = Math.max(cnt, max);
        }

        System.out.print(max);
    }
}
