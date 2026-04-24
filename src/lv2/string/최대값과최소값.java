package lv2.string;

import java.util.*;

/*
문자열 s에는 공백으로 구분된 숫자들이 저장되어 있음

최소값 최대값 형태로 문자열을 Return 하라

<입력>
s
- s: 문자열 (공백으로 구분도니 숫자들)

<출력>
최소값 최대값

<풀이>
split
*/

class 최대값과최소값 {
    public String solution(String s) {
        String[] arr = s.split(" ");

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for (String str : arr) {
            int num = Integer.parseInt(str);

            min = Math.min(min, num);
            max = Math.max(max, num);
        }

        StringBuilder sb = new StringBuilder();
        sb.append(min).append(' ').append(max);

        return sb.toString();
    }
}