package silver.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem1149Retry {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] prev = new int[3];
        int[] cur = new int[3];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 3; j++) prev[j] = cur[j];

            StringTokenizer st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int g = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            cur[0] = r + Math.min(prev[1], prev[2]);
            cur[1] = g + Math.min(prev[0], prev[2]);
            cur[2] = b + Math.min(prev[0], prev[1]);
        }

        int min = Integer.MAX_VALUE;
        for (int i = 0; i < 3; i++) {
            min = Math.min(min, cur[i]);
        }
        System.out.print(min);

    }
}
