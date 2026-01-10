package bronze.math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem2292 {
    public static void main(String[] args) throws IOException {
        // 1 -> 1
        // 2 ~ 7 (6개) -> 2
        // 8 ~ 19 (12개) -> 3

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int answer = 0;
        int multiplier = 0;
        while (n > 0) {
            if (multiplier == 0) {
                n--;
            }
            n -= 6 * multiplier;
            answer++;
            multiplier++;
        }

        System.out.print(answer);
    }
}
