package bronze.math.isprime;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem1978 {
    public static void main(String[] args) throws IOException {
        // 입력 받기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 2부터 검사해서 i * i 가 1000까지
        // i * i 부터 i씩 더해가며 false로 체크
        boolean[] isPrime = new boolean[1001];
        for (int i = 2; i <= 1000; i++) isPrime[i] = true;

        for (int i = 2; i * i <= 1000; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j <= 1000; j += i) {
                    isPrime[j] = false;
                }
            }
        }

        int answer = 0;
        while (n-- > 0) {
            int num = Integer.parseInt(st.nextToken());
            if (isPrime[num]) answer++;
        }
        System.out.print(answer);
    }
}
