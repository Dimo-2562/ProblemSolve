package later;

import java.util.*;

/*
문자열이 나눈다는 것은 s가 t의 합으로 구성될 수 있을 때
str1과 str2를 모두 나눌 수 있는 x를 구하라.

<입력>
- str1, str2
- 길이 (1 ~ 10^3)
- 대문자로만 구성

<출력>
x

<풀이>
1. 먼저 길이로 체크
2. 반복해보면서 되는지 체크
*/

class Problem1071Later {
    public String gcdOfStrings(String str1, String str2) {
        int len1 = str1.length();
        int len2 = str2.length();

        int min = Math.min(len1, len2);

        for (int i = min; i >= 1; i--) {
            if (len1 % i != 0 || len2 % i != 0) {
                continue;
            }

            String candidate = str1.substring(0, i);

            if (canMake(str1, candidate) && canMake(str2, candidate)) return candidate;
        }

        return "";
    }

    boolean canMake(String str, String candidate) {
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) != candidate.charAt(i % candidate.length()))
                return false;
        }

        return true;
    }
}