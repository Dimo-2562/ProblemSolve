package bronze.math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem11005 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        StringBuilder sb = new StringBuilder();
        while (n > 0){
            char c;
            if (n % b >= 10){
                c = (char) (n % b - 10 + 'A');
            } else {
                c = (char) (n % b + '0');
            }

            n = n / b;
            sb.append(c);
        }

        System.out.println(sb.reverse());
    }
}
