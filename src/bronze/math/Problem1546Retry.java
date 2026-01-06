package bronze.math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem1546Retry {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int max = Integer.parseInt(st.nextToken());
        int sum = max;
        for (int i = 1; i < n; i++) {
            int num = Integer.parseInt(st.nextToken());
            sum += num;
            max = Math.max(max, num);
        }

        // 평균 구하기
        System.out.println((double) sum / max * 100 / n );
    }
}