package bronze.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem10818 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        String[] input = br.readLine().split(" ");

        int min = 1987654;
        int max = -1987654;
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(input[i]);
            if (num < min) {
                min = num;
            } if (num > max) {
                max = num;
            }
        }

        System.out.println(min + " " + max);

    }
}
