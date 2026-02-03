package silver.structure.map;

import java.io.*;
import java.util.*;

public class Problem1620 {
    /*
    N, M
    N: 도감에 수록되어 있는 포켓몬의 개수 (10^5)
    M: 맞춰야 하는 문제의 개수 (10^5)

    포켓몬의 이름: 영어, 첫 글자 or 마지막 글자만 대문자, 나머지 소문자,
    (2 ~ 20)
    알파벳 -> 포켓몬 번호
    숫자 -> 문자 출력
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        Map<String, Integer> stringMap = new HashMap<>();
        Map<Integer, String> integerMap = new HashMap<>();
        for (int i = 1; i <= n; i++) {
            String str = br.readLine();
            stringMap.put(str, i);
            integerMap.put(i, str);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m; i++){
            String str = br.readLine();
            if (str.charAt(0) >= '1' && str.charAt(0) <= '9') {
                int num = Integer.parseInt(str);
                sb.append(integerMap.get(num)).append('\n');
            } else {
                sb.append(stringMap.get(str)).append('\n');
            }
        }

        System.out.print(sb);
    }
}