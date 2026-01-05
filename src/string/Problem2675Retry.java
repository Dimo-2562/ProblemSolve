package string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem2675Retry {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder(160000 + 1000);

        while (t-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());

            for (char c : st.nextToken().toCharArray()) {
                for (int i = 0; i < r; i++) {
                    sb.append(c);
                }
            }
            sb.append('\n');
        }
        System.out.print(sb);
    }
}
