package silver.sort;

import java.io.*;
import java.util.*;

public class Problem11651 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Set <int[]> set = new TreeSet<>((o1, o2) ->
                o1[1] != o2[1] ? o1[1] - o2[1] : o1[0] - o2[0]);
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            set.add(new int[] {x, y});
        }

        StringBuilder sb = new StringBuilder();
        for (int[] arr : set) {
            sb.append(arr[0]).append(' ').append(arr[1]).append('\n');
        }
        System.out.print(sb);

    }
}
