package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem10811Retry {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] bucket = new int[n + 1];
        for (int i = 1; i <= n; i++) bucket[i] = i;

        for (int k = 0; k < m; k++) {
            st = new StringTokenizer(br.readLine());
            int left = Integer.parseInt(st.nextToken());
            int right = Integer.parseInt(st.nextToken());

            while (left < right) {
                int temp = bucket[left];
                bucket[left] = bucket[right];
                bucket[right] = temp;
                left++;
                right--;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            if (i > 1) sb.append(" ");
            sb.append(bucket[i]);
        }
        System.out.print(sb);
    }
}
