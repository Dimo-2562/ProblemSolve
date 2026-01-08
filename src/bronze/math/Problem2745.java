package bronze.math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem2745 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        String input = st.nextToken();
        int b = Integer.parseInt(st.nextToken());

        long answer = 0;
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            int digit;
            if (Character.isDigit(c)) {
                digit = c - '0';
            } else {
                digit = c - 'A' + 10;
            }

            answer = answer * b + digit;
        }

        System.out.print(answer);
    }
}
