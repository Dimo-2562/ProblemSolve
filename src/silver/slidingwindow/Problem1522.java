package silver.slidingwindow;

import java.io.*;

/*
a와 b로만 이루어진 문자열이 주어질 때,
a를 모두 연속으로 만들기 위해서 필요한 교환의 횟수를 최소로

즉, a도 연속, b도 연속이 되어야 함.

<입력>
문자열
- 길이 (1 ~ 10^3)

<출력>
교환의 횟수의 최솟값.

슬라이딩 윈도우 -> 몇 개의 b를 빼야하는가.
 */

public class Problem1522 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine();
        int cntA = 0;
        for (char c: input.toCharArray()) {
            if (c == 'a') cntA++;
        }

        int cntB = 0;
        for (int i = 0; i < cntA; i++) {
            if (input.charAt(i) == 'b') cntB++;
        }

        int len = input.length();
        int min = cntB;
        for (int i = 1; i < len; i++) {
            if (input.charAt(i-1) == 'b') cntB--;
            if (input.charAt((cntA + i - 1) % len) == 'b') cntB++;

            min = Math.min(min, cntB);
        }

        System.out.print(min);
    }
}