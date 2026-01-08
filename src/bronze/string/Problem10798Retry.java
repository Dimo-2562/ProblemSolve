package bronze.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem10798Retry {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] lines = new String[5];
        int maxLen = 0;

        for (int i = 0; i < 5; i++) {
            lines[i] = br.readLine();
            maxLen = Math.max(maxLen, lines[i].length());
        }

        StringBuilder sb = new StringBuilder(75);
        for (int j = 0; j < maxLen; j++) {
            for (int i = 0; i < 5; i++) {
                if (j < lines[i].length()) {
                    sb.append(lines[i].charAt(j));
                }
            }
        }

        System.out.print(sb);
    }
}
