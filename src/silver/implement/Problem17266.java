package silver.implement;

import java.io.*;
import java.util.*;

/*
높이가 H라면 좌우로 H만큼 밝힌다.
N
- 굴다리의 길이 (1 ~ 10^5)
M
- 가로등의 개수 (1 ~ 10^5)
x
- 가로등의 위치

N을 모두 비추기위한 가로등의 최소 높이를 출력하시오.

0, x 그리고 n을 넣은 뒤에 앞 뒤끼리 비교해서 max값만 생각. -> 브루트포스
메모리를 더 아끼려면 이전값만 담아도 되지만 지금도 잘 동작.

이분탐색?
 */

public class Problem17266 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int prev = 0;
        int max = -1;
        for (int i = 0; i < m; i++) {
            int num = Integer.parseInt(st.nextToken());
            if (i == 0) max = Math.max(max, num - prev);
            else max = Math.max(max, (num - prev + 1) / 2);
            prev = num;
        }
        max = Math.max(max, n - prev);

        System.out.print(max);
    }
}
