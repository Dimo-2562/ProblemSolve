import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem1676 {
    public static void main(String[] args) throws IOException {
        // 2의 배수 개수랑 5의 배수 개수 중 Min값이 0의 개수
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int num2 = 0, num5 = 0;
        for (int i = 1; i <= n; i++) {
            int tmp = i;
            while (tmp % 2 == 0) {
                num2++;
                tmp /= 2;
            }
            while (tmp % 5 == 0) {
                num5++;
                tmp /= 5;
            }
        }

        System.out.print(Math.min(num2, num5));
    }
}
