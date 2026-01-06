package bronze.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem10871Retry {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input1 = br.readLine().split(" ");
        int n = Integer.parseInt(input1[0]);
        int x = Integer.parseInt(input1[1]);

        String[] input2 = br.readLine().split(" ");
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(input2[i]);
            if (num < x) {
                sb.append(num).append(" ");
            }
        }

        System.out.println(sb);
    }
}
