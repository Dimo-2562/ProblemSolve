package bronze.math.isprime;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem2581 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int m = Integer.parseInt(br.readLine());
        int n = Integer.parseInt(br.readLine());

        // 에라토스테네스의 체 사용
        boolean[] isPrime = new boolean[n + 1];
        for (int i = 2; i <= n; i++) isPrime[i] = true;

        for (int i = 2; i * i <= n; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j <= n; j += i) {
                    isPrime[j] = false;
                }
            }
        }

        int min = Integer.MAX_VALUE;
        int sum = 0;
        for (int i = m; i <= n; i++) {
            if (isPrime[i]) {
                min = Math.min(min, i);
                sum += i;
            }
        }

        if (sum == 0) System.out.print(-1);
        else System.out.print(sum + "\n" + min);
    }
}
