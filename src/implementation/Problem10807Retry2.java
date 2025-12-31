package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem10807Retry2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Integer n = Integer.parseInt(br.readLine());
        int[] arr = new int[201];

        String[] input = br.readLine().split(" ");
        for(int i = 0; i < n; i++) {
            Integer tmp = Integer.parseInt(input[i]);
            arr[tmp+100]++;
        }

        Integer v = Integer.parseInt(br.readLine());
        System.out.println(arr[v+100]);

    }
}
