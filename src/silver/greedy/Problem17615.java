package silver.greedy;

import java.io.*;

/*
볼 옮기기
1. 옆에 다른 색상 볼들은 한 번에 건너띌 수 있음.
2. 한 번 고른 색상의 볼만 옮길 수 있음.
최소 이동횟수를 찾아라.

<입력>
N
- N: 볼의 총 개수 (1 ~ 10^5)
볼들
- R or B

<출력>
최소 이동횟수

R을 옮길 때와 B를 옮길 때는 별도로 실행.
왼쪽 끝 or 오른쪽 끝.
 */

public class Problem17615 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        String input = br.readLine();

        int min = Integer.MAX_VALUE;
        int cnt;
        boolean isDiff;

        // R - left
        cnt = 0;
        isDiff = false;
        for (char c : input.toCharArray()) {
            if (c == 'R' && isDiff) cnt++;

            if (c == 'B') isDiff = true;
        }
        min = Math.min(min, cnt);

        // R - right
        cnt = 0;
        isDiff = false;
        for (int i = input.length()-1; i >= 0; i--) {
            char c = input.charAt(i);

            if (c == 'R' && isDiff) cnt++;
            if (c == 'B') isDiff = true;
        }
        min = Math.min(min, cnt);

        // B - left
        cnt = 0;
        isDiff = false;
        for (char c : input.toCharArray()) {
            if (c == 'B' && isDiff) cnt++;

            if (c == 'R') isDiff = true;
        }
        min = Math.min(min, cnt);

        // B - right
        cnt = 0;
        isDiff = false;
        for (int i = input.length()-1; i >= 0; i--) {
            char c = input.charAt(i);

            if (c == 'B' && isDiff) cnt++;
            if (c == 'R') isDiff = true;
        }
        min = Math.min(min, cnt);

        System.out.print(min);
    }
}
