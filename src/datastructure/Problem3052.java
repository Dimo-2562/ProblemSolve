package datastructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Problem3052 {
    public static final int DIVISION = 42;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < 10; i++) {
            int num = Integer.parseInt(br.readLine());
            int value = num % DIVISION;
            set.add(value);
        }
        System.out.println(set.size());
    }
}
