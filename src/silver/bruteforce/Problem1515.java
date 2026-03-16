package silver.bruteforce;

import java.io.*;

/*
1 ~ N까지의 수를 공백 없이 적었고, 몇 개의 숫자를 지웠다.

이어붙인 수가 주어질 때 N의 최솟값을 구하는 프로그램을 작성하라.

<입력>
지우고 남은 수
- 최대 10^3 자리의 수

<출력>
가능한 N 중에 최솟값을 출력.

9자리
90 * 2 = 180자리
900 * 3 = 2700 자리

N은 최대 네 자리 숫자.
Bruteforce
 */

public class Problem1515 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        int answer = 1;
        int idx = 0;
        while (idx != str.length()) {
            String tmp = String.valueOf(answer);
            for (int k = 0; k < tmp.length(); k++) {
                if (tmp.charAt(k) == str.charAt(idx)) {
                    idx++;
                }
                if (idx == str.length()) break;
            }
            if (idx == str.length()) break;

            answer++;
        }

        System.out.print(answer);
    }
}
