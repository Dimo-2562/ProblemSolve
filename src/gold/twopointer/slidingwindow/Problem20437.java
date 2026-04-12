package gold.twopointer.slidingwindow;

import java.io.*;
import java.util.*;

/*
알파벳 소문자로 이루어진 문자열 W
양의 정수 K
1. 어떤 문자를 정확히 K개를 포함하는 가장 짧은 연속 문자열의 길이를 구하라.
2. 어떤 문자를 정확히 K개를 포함하고, 문자열의 첫 번째와 마지막 글자가 해당 문자로 같은 가장 긴 연속 문자열의 길이를 구하라.
게임을 T회 진행.

<입력>
T
- 문자열 게임의 수 (1 ~ 10^2)
W
- 주어지는 문자열
K
- 조건 (1 ~ 10^4)

<출력>
3번과 4번에서 구한 연속 문자열의 길이를 공백을 사이에 두고 출력
없을경우 -1을 출력.


1. 각 문자별 카운트 세서 안되는 경우 찾기.
각 문자별로 queue에 넣기.
2. 되는 경우의 문자들을 차례대로 해보기.
 */

public class Problem20437 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        while (t-- > 0) {
            String w = br.readLine();
            int k = Integer.parseInt(br.readLine());

            int[] cntArr = new int[26];
            int max = -1;
            Map <Character, List<Integer>> charMap = new HashMap<>();

            char[] chars = w.toCharArray();
            for (int i = 0; i < chars.length; i++) {
                cntArr[chars[i] - 'a']++;
                max = Math.max(max, cntArr[chars[i] - 'a']);

                charMap.computeIfAbsent(chars[i], tmp -> new ArrayList<>()).add(i);
            }

            if (max < k) {
                sb.append("-1").append('\n');
                continue;
            }

            int min = Integer.MAX_VALUE;
            max = -1;
            for (int i = 0; i < 26; i++) {
                if (cntArr[i] >= k) {
                    char c = (char) ('a' + i);
                    List<Integer> list = charMap.get(c);

                    int start = 0;
                    int end = 0;

                    for (int j = 0; j < list.size(); j++) {
                        end = j;

                        int cnt = end - start + 1;
                        if (cnt == k) {
                            min = Math.min(min, list.get(end) - list.get(start) + 1);
                            max = Math.max(max, list.get(end) - list.get(start) + 1);
                            start++;
                        }
                    }
                }
            }
            sb.append(min).append(' ').append(max).append('\n');
        }
        System.out.print(sb);
    }
}
