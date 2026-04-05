package silver.binarysearch;

import java.io.*;
import java.util.*;

/*
N개의 정수
X라는 정수가 있는지 알아내라.

<입력>
N
- N: 정수의 개수 (1 ~ 10^5)
정수
- int 범위
M
- M: 주어지는 수들의 개수 (1 ~ 10^5)
정수
- 이 수들이 각각 A안에 존재하는지 체크하는 것
- int 범위

<출력>
M개의 줄에 출력
- 있으면 1
- 없으면 0

<풀이>
정렬, 이분 탐색
 */

public class Problem1920Retry {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] card = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            card[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(card);

        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m; i++) {
            int num = Integer.parseInt(st.nextToken());

            int left = 0;
            int right = card.length - 1;
            int mid;

            boolean flag = false;
            while (left <= right) {
                mid = (left + right) / 2;

                if (card[mid] == num) {
                    flag = true;
                    break;
                } else if (card[mid] > num) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }

            sb.append(flag ? 1 : 0).append('\n');
        }

        System.out.print(sb);
    }
}
