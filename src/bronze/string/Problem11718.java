package bronze.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem11718 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder(10000 + 100);

        String str;
        while ((str = br.readLine()) != null) {
            sb.append(str).append('\n');
        }

        System.out.print(sb);
    }
}