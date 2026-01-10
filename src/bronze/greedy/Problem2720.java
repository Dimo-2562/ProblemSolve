package bronze.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem2720 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] coin = {25, 10, 5, 1};

        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            int c = Integer.parseInt(br.readLine());

            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < 4; i++) {
                sb.append(c / coin[i]).append(" ");
                c %= coin[i];
            }
            System.out.println(sb);
        }

    }
}
