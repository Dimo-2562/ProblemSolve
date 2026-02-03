package silver.structure.map;

import java.io.*;
import java.util.*;

public class Problem16165 {
    /*
    N, M
    N: 걸그룹의 수 (10^2)
    M: 맞혀야 할 문제의 수 (10^2)

    팀 이름
    인원 수
    멤버 이름
    (이름이 같은 멤버는 없음)

    M개의 퀴즈
    팀 이름 or 멤버의 이름
    퀴즈의 종류(0 or 1)
    - 0이면 팀 이름
    - 1이면 멤버 이름
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        Map<String, List<String>> teamMap = new HashMap<>();
        Map<String, String> memberMap = new HashMap<>();
        while (n-- > 0){
            String team = br.readLine();
            int cnt = Integer.parseInt(br.readLine());

            for (int i = 0; i < cnt; i++){
                String member = br.readLine();
                teamMap.computeIfAbsent(team, k -> new ArrayList<>()).add(member);
                memberMap.put(member, team);
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m; i++){
            String input = br.readLine();
            int kind = Integer.parseInt(br.readLine());

            if (kind == 0) {
                List<String> members = teamMap.get(input);
                Collections.sort(members);
                for (String member : members) {
                    sb.append(member).append('\n');
                }
            } else {
                String team = memberMap.get(input);
                sb.append(team).append('\n');
            }
        }

        System.out.print(sb);

    }
}
