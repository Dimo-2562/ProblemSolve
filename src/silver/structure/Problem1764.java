package silver.structure;

import java.util.*;
import java.io.*;

public class Problem1764 {
    /*
    듣지 못한 사람 명단, 보지 못한 사람 명단이 주어질 때 두 개 다 만족하는 사람의 명단

    입력
    N, M
    N: 듣도 못한 사람 (10^5)
    M: 보도 못한 사람 (10^5)
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        Set<String> setA = new TreeSet<>();
        Set<String> setB = new HashSet<>();
        for (int i = 0; i < n; i++) {
            setA.add(br.readLine());
        }
        for (int i = 0; i < m; i++) {
            setB.add(br.readLine());
        }

        StringBuilder sb = new StringBuilder();
        int answer = 0;
        for (String str : setA) {
            if (setB.contains(str)) {
                answer++;
                sb.append(str).append('\n');
            }
        }

        System.out.println(answer);
        System.out.print(sb);

    }
}