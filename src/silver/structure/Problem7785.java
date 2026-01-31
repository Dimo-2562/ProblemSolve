package silver.structure;

import java.io.*;
import java.util.*;

public class Problem7785 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 답: 현재 회사에 있는 모든 사람을 사전순의 역순으로 출력.

        // n: 로그의 개수 (10^6)
        int n = Integer.parseInt(br.readLine());
        Set<String> set = new TreeSet<>(Collections.reverseOrder());
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            String action = st.nextToken();

            if (action.equals("enter")) set.add(name);
            else if (action.equals("leave")) set.remove(name);
        }

        StringBuilder sb = new StringBuilder();
        for (String str : set) {
            sb.append(str).append('\n');
        }
        System.out.print(sb);
    }
}
