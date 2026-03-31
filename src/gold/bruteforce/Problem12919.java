package gold.bruteforce;

import java.io.*;

/*
A와 B로만 이루어진 단어

S를 T로 바꾸기.
1. 문자열 뒤에 A를 추가
2. 문자열 뒤에 B를 추가하고 뒤집기.

<입력>
S
- S: 원본 문자열
- 길이: 1 ~ 49
T
- T: 목표 문자열
- 길이: 2 ~ 50

<출력>
S를 T로 바꿀 수 있으면 1, 없으면 0

목표 -> 원본
- B를 앞에서 빼고 뒤집기
- A를 뒤에서 빼기.

BABA
BAB
BA
A

dfs

 */

public class Problem12919 {

    static String S, T;
    static boolean isSolved = false;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        S = br.readLine(); T = br.readLine();

        solve(T);

        System.out.println(isSolved ? 1 : 0);
    }

    static void solve(String tmp) {
        if (tmp.compareTo(S) == 0) isSolved = true;

        if (tmp.isEmpty()) return;

        if (tmp.charAt(0) == 'B') {
            String next = tmp.substring(1, tmp.length());
            StringBuilder sb = new StringBuilder();
            for (char c: next.toCharArray()) {
                sb.append(c);
            }
            sb.reverse();
            solve(sb.toString());

        } if (tmp.charAt(tmp.length() - 1) == 'A') {
            solve(tmp.substring(0, tmp.length() - 1));
        }
    }
}
