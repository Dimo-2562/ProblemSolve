package bronze.math.isprime;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem11653 {
    public static void main(String[] args) throws IOException {
        // O(N)까지만 돌기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        boolean[] isPrime = new boolean[n + 1];
        for (int i = 2; i <= n; i++) isPrime[i] = true;

        for (int i = 2; i * i <= n; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j <= n; j += i) {
                    isPrime[j] = false;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 2; i <= n; i++) {
            if (n == 1) break;

            if (isPrime[i] && n % i == 0) {
                while (n % i == 0) {
                    n /= i;
                    sb.append(i).append('\n');
                }
            }
        }

        System.out.print(sb);
    }
}
