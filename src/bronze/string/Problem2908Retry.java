package bronze.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem2908Retry {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int first = reverse(st.nextToken());
        int second = reverse(st.nextToken());

        System.out.print(Math.max(first, second));
    }

    private static int reverse (String str) {
        return (str.charAt(2) - '0') * 100 +
                (str.charAt(1) - '0') * 10 +
                (str.charAt(0) - '0');
    }
}
