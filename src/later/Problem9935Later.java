package later;

import java.io.*;

/*
문자열에 폭발 문자열이 있다
폭발 문자열이 폭발하면 그 문자는 사라지며, 합쳐지게 된다.

폭발
- 모든 폭발 문자열은 폭발하게 된다. 남은 문자열을 이어 붙여 새로운 문자열을 만든다.
- 새로 생긴 문자열도 폭발 문자열이 포함될 수 있다.
- 폭발 문자열이 문자열에 없을 때까지 계속한다.

남는 문자열이 무엇인지 구하라.
- 단, 문자가 없을 경우 FRULA를 출력하라.

<입력>
문자열
- 길이 (1 ~ 10^6)
폭발문자열
- 길이 (1 ~ 36)

두 문자열은 모두 알파벳 소문자와 대문자, 숫자(0 ~ 9)로만 이루어져 있다.

<출력>
남은 문자열을 출력하라.

<풀이>
브루트포스 -> 당연히 시간초과.

넣는 시점에 체크하기.
 */

public class Problem9935Later {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();
        String bomb = br.readLine();
        int bombLastIdx = bomb.length() - 1;

        StringBuilder sb = new StringBuilder();
        char[] strArr = str.toCharArray();
        for (int i = 0; i < strArr.length; i++) {
            sb.append(strArr[i]);

            if (sb.length() >= bomb.length() && strArr[i] == bomb.charAt(bombLastIdx)) {
                boolean flag = true;
                for (int j = 1; j < bomb.length(); j++) {
                    if (sb.charAt(sb.length() - 1 - j) != bomb.charAt(bombLastIdx - j)) flag = false;
                }

                if (flag) {
                    sb.setLength(sb.length() - bomb.length());
                }
            }
        }

        if (sb.toString().equals("")) System.out.print("FRULA");
        else System.out.print(sb);
    }
}
