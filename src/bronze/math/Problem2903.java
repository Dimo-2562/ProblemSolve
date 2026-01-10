package bronze.math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem2903 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        // 2 -> 3 -> 5 -> 9 -> 17
        int row = 2;
        for (int i = 0; i < n; i++) {
            row = 2 * row - 1;
        }
        System.out.println(row * row);
    }
}
