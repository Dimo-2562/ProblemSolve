package silver.sort;

import java.util.*;
import java.io.*;

public class Problem1181 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Set <String> set = new TreeSet<>((s1, s2) -> {
            if (s1.length() != s2.length()) return s1.length() - s2.length();
            return s1.compareTo(s2);
        });

        while (n-- > 0) {
            set.add(br.readLine());
        }

        StringBuilder sb = new StringBuilder();
        for (String word: set) {
            sb.append(word).append('\n');
        }
        System.out.print(sb);

    }
}
