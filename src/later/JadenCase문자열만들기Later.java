package later;

import java.util.*;

/*
첫 문자가 대문자
그 외의 알파벳은 소문자인 문자열
첫 문자가 알파벳이 아니면 이어지는 문자열은 다 소문자로

문자열이 주어질 때, 문자열을 JadenCase로 바꾼 문자열을 return하라

<입력>
s
- s: 문자열 (1 ~ 10^2)
- 알파벳, 숫자, 공백으로 구성
- 숫자는 단어의 첫 문자로만 나온다.
- 숫자로만 이루어진 단어는 없다

<출력>
JadenCase로 바꾼 문자열

<풀이>
첫 문자가 알파벳일 때만 대문자로
*/

class JadenCase문자열만들기Later {
    public String solution(String s) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (i == 0 || s.charAt(i - 1) == ' ') {
                sb.append(Character.toUpperCase(c));
            } else {
                sb.append(Character.toLowerCase(c));
            }
        }

        return sb.toString();
    }
}
