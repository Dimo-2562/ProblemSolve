package silver.prefixsum;

import java.io.*;
import java.util.*;

/*
특정 문자열 S
특정 문자열 a
문자열의 구간 [l, r]
a가 몇 번 등장하는지 구하라.
같은 문자열을 두고 q번 질문

<입력>
S
- S: 문자열 (1 ~ 10^5)
q
- q: 질문의 수 (1 ~ 10^5)
a, l, r
- a: 특정 문자
- l, r (0 ~ 10^5)

<출력>
해당 범위 안에 a가 나타나는 횟수 (줄바꿈)

<풀이>
q가 10^5이므로,
일단 문자열을 받고 미리 계산을 해둬야 함. -> 누적합.

a ~ z까지 문자열 안에 몇 번 등장하는 지 계산하기.
int[][] cnt = new int[26][200_000]
 */

public class Problem16139 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();
        int[][] alphaCnt = new int[26][200_000 + 1];
        for (int i = 0; i < 26; i++) {
            char c = (char)('a' + i);

            for (int j = 1; j <= s.length(); j++) {
                alphaCnt[i][j] = alphaCnt[i][j-1] + (s.charAt(j - 1) == c ? 1 : 0);
            }
        }

        int q = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (q-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            char c = st.nextToken().charAt(0);
            int l = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());

            sb.append(alphaCnt[c - 'a'][r + 1] - alphaCnt[c - 'a'][l]).append('\n');
        }

        System.out.print(sb);
    }
}
