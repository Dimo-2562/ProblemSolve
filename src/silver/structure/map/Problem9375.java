package silver.structure.map;

import java.io.*;
import java.util.*;

public class Problem9375 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());

            Map <String, List<String>> map = new HashMap<>();
            for (int i = 0; i < n; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                String item = st.nextToken();
                String part = st.nextToken();
                map.computeIfAbsent(part, k -> new ArrayList<>()).add(item);
            }

            int answer = 1;
            for (List<String> items: map.values()) {
                answer *= (items.size() + 1);
            }
            answer--;
            sb.append(answer).append('\n');
        }

        System.out.print(sb);
    }

}
