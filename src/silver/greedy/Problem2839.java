package silver.greedy;

import java.io.*;

/*
3kg, 5kg
정확하게 Nkg을 배달해야 할 때, 봉지 최솟값.

<입력>
N
- N: 배달해야 하는 설탕의 무게 (3 ~ 10^3)

<출력>
배달하는 봉지의 최소 개수.
- 만약 정확하게 N킬로 그램을 만들 수 없다면 -1을 출력.

DP or 그리디
 */

public class Problem2839 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int num5 = 0, num3 = 0;
        num5 = n / 5;

        while (num5 >= 0) {
            int tmp = n - num5 * 5;
            if (tmp % 3 == 0) {
                num3 = tmp / 3;
                break;
            }

            num5--;
        }

        if (num5 < 0) System.out.print("-1");
        else System.out.print(num5 + num3);
    }
}
