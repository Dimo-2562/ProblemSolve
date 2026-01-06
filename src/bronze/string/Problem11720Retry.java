package bronze.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem11720Retry {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        br.readLine();

        int sum = 0;
        for (char c : br.readLine().toCharArray()) {
            sum += c - '0';
        }
        System.out.println(sum);
    }
}
