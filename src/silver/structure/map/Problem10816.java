package silver.structure.map;

import java.util.*;
import java.io.*;

public class Problem10816 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(st.nextToken());
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m; i++) {
            int num = Integer.parseInt(st.nextToken());
            if (map.containsKey(num)) {
                sb.append(map.get(num));
            } else {
                sb.append(0);
            }
            sb.append(' ');
        }

        System.out.print(sb);
    }
}
