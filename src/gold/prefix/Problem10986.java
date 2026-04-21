package gold.prefix;

import java.io.*;
import java.util.*;

/*
수 N개가 주어진다.
연속된 부분 구간의 합이 M으로 나누어 떨어지는 구간의 개수를 구하라.

<입력>
N, M
- N: 수의 개수 (1 ~ 10^6)
- M: 나누어 떨어져야 하는 숫자 (2 ~ 10^3)
수열의 수들
- (0 ~ 10^9)

<출력>
나누어 떨어지는 구간의 개수

<풀이>
나머지가 같은 누적합 -> 빼면 나누어떨어짐.
int[] count
count[0] = 1로 시작.
 */

public class Problem10986 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] prefix = new int[n + 1];
        int[] cntArr = new int[m + 1];
        cntArr[0] = 1;

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            prefix[i] = (Integer.parseInt(st.nextToken()) % m + prefix[i - 1]) % m;
            cntArr[prefix[i]]++;
        }

        long sum = 0;
        for (int i = 0; i < m; i++) {
            if (cntArr[i] >= 2) {
                sum += (long) cntArr[i] * (cntArr[i] - 1) / 2;
            }
        }

        System.out.print(sum);
    }
}
