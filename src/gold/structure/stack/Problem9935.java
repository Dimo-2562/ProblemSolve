package gold.structure.stack;

import java.io.*;

/*
폭발 문자열
연쇄적으로 가능.

남아있는 문자가 없는 경우 FRULA를 출력.

<입력>
문자열
- 길이 (1 ~ 10^6)
폭발문자열
- 길이 (1 ~ 36)
- 알파벳 소문자, 대문자, 숫자(0 ~ 9)로만 구성.

<출력>
폭발이 끝난 후 남은 문자열

<풀이>
스택.
특정 위치 접근이 필요하므로 StringBuilder
 */

public class Problem9935 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();
        String bomb = br.readLine();

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);

            sb.append(c);

            if (sb.length() >= bomb.length()
                && sb.charAt(sb.length() - 1) == bomb.charAt(bomb.length() - 1)) {
                checkBomb(sb, bomb);
            }
        }

        System.out.print(sb.length() == 0 ? "FRULA" : sb);

    }

    static void checkBomb(StringBuilder sb, String bomb) {
        int sbLen = sb.length();
        int bombLen = bomb.length();

        boolean flag = true;
        for (int i = 0; i < bombLen; i++) {
            if (sb.charAt(sbLen - bombLen + i) != bomb.charAt(i)) {
                flag = false;
                break;
            }
        }

        if (flag) sb.setLength(sbLen - bombLen);
    }
}
