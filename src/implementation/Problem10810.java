package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem10810 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]); // 1~10^2
        int m = Integer.parseInt(input[1]); // 1~10^2

        int[] bucket = new int[105];
        for (int k = 0; k < m; k++) {
            input = br.readLine().split(" ");
            int i = Integer.parseInt(input[0]);
            int j = Integer.parseInt(input[1]);
            for(int q = i; q <= j; q++) {
                bucket[q] = Integer.parseInt(input[2]);
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++){
            sb.append(bucket[i]).append(" ");
        }
        System.out.println(sb);

    }
}