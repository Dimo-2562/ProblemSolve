package silver.structure.set;

import java.io.*;
import java.util.*;

public class Problem10815 {
    public static void main(String[] args) throws IOException {
        // 숫자 카드 N개 (1 ~ 10^5), 수는 int형
        // 정수 M개가 주어졌을 때 이 수를 가지고 있는지 아닌지 (1 ~ 10^5)

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Set<Integer> set = new HashSet<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            set.add(Integer.parseInt(st.nextToken()));
        }

        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m; i++) {
            if(set.contains(Integer.parseInt(st.nextToken()))) sb.append(1).append(' ');
            else sb.append(0).append(' ');
        }

        System.out.print(sb);
    }
}
