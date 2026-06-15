package easy.implementation;

import java.util.*;

/*
word1이랑 word2가 있을 때 문자열 번갈아가며 합치기.

<입력>
- word1, word2
- 길이 (1 ~ 10^2)

<출력>
두 문자열을 합친 결과
*/

class Problem1768 {
    public String mergeAlternately(String word1, String word2) {
        int idx1 = 0;
        int idx2 = 0;

        int len1 = word1.length();
        int len2 = word2.length();

        StringBuilder sb = new StringBuilder();

        while (idx1 < len1 && idx2 < len2) {
            sb.append(word1.charAt(idx1++)).append(word2.charAt(idx2++));
        }

        while (idx1 < len1) {
            sb.append(word1.charAt(idx1++));
        }

        while (idx2 < len2) {
            sb.append(word2.charAt(idx2++));
        }

        return sb.toString();
    }
}