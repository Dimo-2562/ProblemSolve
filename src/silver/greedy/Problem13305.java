package silver.greedy;

import java.io.*;
import java.util.*;

/*
도로들은 길이가 다를 수 잇다.
처음에 기름을 넣고 출발, 기름통은 무제한.
1km 1리터
리터당 가격이 다름.

long 자료형

N
- 도시의 개수 (1 ~ 10^5)
도로의 길이
- 1 ~ 10^9
주유소의 리터당 가격
- 1 ~ 10^9
 */

public class Problem13305 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        long[] roadArr = new long[n-1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n-1; i++) {
            roadArr[i] = Long.parseLong(st.nextToken());
        }

        long[] gasArr = new long[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            gasArr[i] = Long.parseLong(st.nextToken());
        }

        long cost = 0;
        long min = Integer.MAX_VALUE;
        for (int i = 0; i < n-1; i++) {
            min = Math.min(min, gasArr[i]);
            cost += min * roadArr[i];
        }

        System.out.print(cost);
    }
}
