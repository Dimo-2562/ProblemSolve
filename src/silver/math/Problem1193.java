package silver.math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem1193 {
    public static void main(String[] args) throws IOException {
        // 1 /1 2/ 3 2 1/ 1 2 3 4
        // 1 /2 1/ 1 2 3/ 4 3 2 1

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        int range = 1;
        while (n > range) {
            n -= range;
            range++;
        }

        int child, parent;
        if (range % 2 == 0) {
            child = 1;
            parent = range;
            for (int i = 1; i < n; i++) {
                child++;
                parent--;
            }
            sb.append(child).append('/').append(parent);
        } else {
            child = range;
            parent = 1;
            for (int i = 1; i < n; i++) {
                child--;
                parent++;
            }
            sb.append(child).append('/').append(parent);
        }
        System.out.print(sb);

    }
}
