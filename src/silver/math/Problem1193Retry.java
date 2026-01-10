package silver.math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem1193Retry {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int diag = 1;
        while (n > diag) {
            n -= diag;
            diag++;
        }

        int child, parent;
        if (diag % 2 == 0) {
            child = n;
            parent = diag - n + 1;
        } else {
            child = diag - n + 1;
            parent = n;
        }

        System.out.println(child + "/" + parent);
    }
}
