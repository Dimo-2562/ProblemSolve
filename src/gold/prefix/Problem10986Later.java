package gold.prefix;

import java.io.*;
import java.util.*;

/*
연속된 부분 구간의 합이 M으로 나누어 떨어지는 구간의 개수를 구하라.

<입력>
N, M
- N: 수의 개수 (1 ~ 10^6)
- M: 나눌 숫자 (2 ~ 10^3)
수들 (0 ~ 10^9)

<출력>
구간의 합이 M으로 나누어 떨어지는 구간의 개수를 출력하라.

<풀이>
연속된 -> 슬라이딩 윈도우? 근데 움직일 동력이 애매함.

풀이 생각 못함 -> 나머지의 성질 이용
나머지가 같은 것들끼리 조합 활용.
 */

public class Problem10986Later {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        long[] cnt = new long[m + 1];
        cnt[0] = 1;

        st = new StringTokenizer(br.readLine());
        int prefix = 0;
        for (int i = 0; i < n; i++) {
            prefix += Integer.parseInt(st.nextToken());
            prefix %= m;
            cnt[prefix]++;
        }

        long answer = 0;
        for (int i = 0; i < m; i++) {
            answer += (cnt[i] * (cnt[i] - 1)) / 2;
        }

        System.out.print(answer);
    }
}
