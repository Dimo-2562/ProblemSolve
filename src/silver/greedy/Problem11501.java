package silver.greedy;

import java.io.*;
import java.util.*;

/*
3가지 행동 중 하나
1. 주식 사기
2. 원하는만큼 주식을 팔기
3. 휴식

최대 이익을 구하라.

<입력>
T
- T: 테스트 케이스의 수 (모름)
N
- N: 날의 수 (2 ~ 10^6)
주가

<출력>
각 테스트케이스 별로 최대 이익을 나타내는 정수 하나를 출력 (long형)

역순 -> 어떻게?
 */

public class Problem11501 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());

            int[] stocks = new int[n+1];
            for (int i = 1; i <= n; i++) {
                stocks[i] = Integer.parseInt(st.nextToken());
            }

            long max = -1;
            long sum = 0;
            for (int i = n; i >= 1; i--) {
                if (stocks[i] < max) {
                    sum += max - (long) stocks[i];
                }

                max = Math.max(max, stocks[i]);
            }

            sb.append(sum).append('\n');
        }

        System.out.print(sb);
    }
}
