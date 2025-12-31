package datastructure;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Problem10807 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int num = sc.nextInt();
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        int v = sc.nextInt();
        if(map.containsKey(v)) {
            System.out.println(map.get(v));
        }else {
            System.out.println("0");
        }
    }
}
