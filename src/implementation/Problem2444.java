package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem2444 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= 2 * n - 1; i++) {
            int blankNum = Math.abs(n - i);
            for (int j = 0; j < blankNum; j++) {
                sb.append(' ');
            }

            int starLevel = i;
            if (i > n) starLevel = 2 * n - i;

            for (int j = 0; j < 2 * starLevel - 1; j++) {
                sb.append('*');
            }

            if (i != 2 * n - 1) sb.append('\n');
        }
        System.out.print(sb);
    }
}
