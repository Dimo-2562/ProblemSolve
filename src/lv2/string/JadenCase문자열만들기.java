package lv2.string;

import java.util.*;

/*
JadenCase = 단어의 첫 문자만 대문자, 나머지는 소문자
첫 글자가 알파벳이 아니면 그대로 두기.

s를 JadenCase로 바꾼 뒤 return 하라.

<입력>
s
- s: 문자열
- 길이 (1 ~ 10^2)
- 알파벳, 숫자, 공백으로 구성
- 공백은 연속해서 나올 수 있다.

<출력>
JadenCase로 바뀐 문자열

<풀이>
문자열의 첫 번째 글자, 이전 글자가 공백일 때-> 대문자
나머지 문자 -> 소문자
*/

class JadenCase문자열만들기 {
    public String solution(String s) {

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (i == 0 || s.charAt(i - 1) == ' ') {
                sb.append(Character.toUpperCase(s.charAt(i)));
            } else {
                sb.append(Character.toLowerCase(s.charAt(i)));
            }
        }

        return sb.toString();
    }
}