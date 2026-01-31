package silver.structure;

import java.io.*;
import java.util.*;

public class Problem14425 {
    public static void main(String[] args) throws IOException {
        // N개의 문자열로 이루어진 집합 S가 주어짐.
        // M개의 문자열 중 집합 S에 포함되어 있는 것이 총 몇 개인지.

        // N: S의 문자열의 개수 (10^4)
        // M: 주어지는 문자열 (10^4)

        // S 먼저 입력 받고
        // M입력 받으면서 존재 여부 확인 -> Map Set?

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        Set<String> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            set.add(br.readLine());
        }

        int ans = 0;
        for (int i = 0; i < m; i++) {
            if (set.contains(br.readLine())) {
                ans++;
            }
        }

        System.out.print(ans);
    }
}
