package lv3.twopointer.slidingwindow;

import java.io.*;
import java.util.*;

/*
매장 진열대의 특정 범위의 물건을 모두 싹쓸이
진열된 모든 종류의 보석을 적어도 1개 이상 포함하는 가장 짧은 구간을 찾아라.

<입력>
String[] gems
- gems: 보석들의 이름이 순서대로 저장된 배열 (1 ~ 10^5)
- 각 원소: 알파벳 대문자로만 구성 (1 ~ 10)

<출력>
모든 보석을 하나 이상 포함하는 가장 짧은 구간을 찾아서 return
[시작 번호, 끝 번호]
- 여러 개일 경우 시작 진열대 번호가 가장 작은 구간

<풀이>
Map <보석 이름, 위치> -> 애매한데...


gems만큼 돌아서 전체 종류를 체크
Map size.

걍 투포인터
*/

class 보석쇼핑 {
    public int[] solution(String[] gems) {
        Set<String> set = new HashSet<>();
        for (String gem : gems) {
            set.add(gem);
        }

        int cut = set.size();

        int start = 1;
        int minLen = gems.length + 1;
        int answer[] = new int[2];

        Map<String, Integer> map = new HashMap<>();
        for (int end = 1; end <= gems.length; end++) {
            map.put(gems[end - 1], map.getOrDefault(gems[end - 1], 0) + 1);

            while (map.size() == cut) {
                if (minLen > end - start + 1) {
                    minLen = end - start + 1;
                    answer[0] = start;
                    answer[1] = end;
                }

                String cur = gems[start - 1];

                map.put(cur, map.get(cur) - 1);
                if (map.get(cur) == 0) map.remove(cur);

                start++;
            }
        }

        return answer;
    }
}