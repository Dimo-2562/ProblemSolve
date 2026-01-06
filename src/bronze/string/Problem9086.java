package bronze.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem9086 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < t; i++) {
            String s = br.readLine();
            sb.append(s.charAt(0)).append(s.charAt(s.length()-1)).append("\n");
        }
        System.out.println(sb);
    }
}
