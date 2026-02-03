package silver.structure.map;

import java.io.*;
import java.util.*;

public class Problem16165Retry {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        Map<String, String> memberMap = new HashMap<>();
        Map<String, Set<String>> teamMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            String team = br.readLine();
            int cnt = Integer.parseInt(br.readLine());
            for (int j = 0; j < cnt; j++) {
                String member = br.readLine();
                memberMap.put(member, team);
                teamMap.computeIfAbsent(team, k -> new TreeSet<>()).add(member);
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m; i++) {
            String input = br.readLine();
            int kind = Integer.parseInt(br.readLine());

            if (kind == 0) {
                for (String member : teamMap.get(input)) {
                    sb.append(member).append('\n');
                }
            } else {
                sb.append(memberMap.get(input)).append('\n');
            }
        }

        System.out.print(sb);
    }
}
