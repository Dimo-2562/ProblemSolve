package silver.string;

import java.io.*;
import java.util.*;

public class Problem11478 {
    /*
    S가 주어졌을 때 S의 서로 다른 부분 문자열의 개수
    (10^3)
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        int size = input.length();

        Set<String> set = new HashSet<>();
        for (int i = 0; i < size; i++) {
            for (int j = i + 1; j <= size; j++) {
                set.add(input.substring(i, j));
            }
        }
        System.out.print(set.size());
    }
}
