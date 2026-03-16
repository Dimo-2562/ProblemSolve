package silver.structure.map;

import java.io.*;
import java.util.*;

/*
자주 나오는 단어일수록 앞에 배치
해당 단어의 길이가 길수록 앞에 배치
알파벳 사전 순으로 앞에 배치

길이가 M이상 단어만 외우도록.

N M
- N: 단어의 개수 (1 ~ 10^5)
- M: 외울 단어의 기준
단어

Map을 사용해서 단어의 개수 체크
 */

public class Problem20920 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            if (str.length() < m) continue;

            map.put(str, map.getOrDefault(str, 0) + 1);
        }

        List<String> list = new ArrayList<>(map.keySet());

        Collections.sort(list, (o1, o2) -> {
            int a = map.get(o1); int b = map.get(o2);
            if(a != b) return map.get(o2) - map.get(o1);
            if(o1.length() != o2.length()) return o2.length() - o1.length();
            return o1.compareTo(o2);
        });

        StringBuilder sb = new StringBuilder();
        for (String str: list) {
            sb.append(str).append('\n');
        }
        System.out.print(sb);

    }
}
