package datastructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Problem10807Retry {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Integer n = Integer.parseInt(br.readLine());

        Map<Integer, Integer> map = new HashMap<>();
        String[] input = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            Integer num = Integer.parseInt(input[i]);
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        Integer v = Integer.parseInt(br.readLine());
        if(map.containsKey(v)) {
            System.out.println(map.get(v));
        } else {
            System.out.println("0");
        }
    }
}
