package bronze.math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Problem9506 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str;
        StringBuilder sb = new StringBuilder();
        while ((str = br.readLine()) != null) {
            int n = Integer.parseInt(str);
            if (n == -1) break;

            List<Integer> smallList = new ArrayList<>();
            List<Integer> bigList = new ArrayList<>();
            for (int i = 1; i * i <= n; i++) {
                if (n % i == 0) {
                    smallList.add(i);

                    if (n / i != n && n / i != i) {
                        bigList.add(n / i);
                    }
                }
            }

            int sum = 0;
            for (int i = 0; i < smallList.size(); i++) {
                sum += smallList.get(i);
            }
            for (int i = 0; i < bigList.size(); i++) {
                sum += bigList.get(i);
            }

            if (sum == n) {
                sb.append(n).append(" = ");
                for (int i = 0; i < smallList.size(); i++) {
                    sb.append(smallList.get(i)).append(" + ");
                }
                for (int i = bigList.size()-1; i >= 0; i--) {
                    sb.append(bigList.get(i));
                    if (i != 0) sb.append(" + ");
                    else sb.append('\n');
                }
            } else {
                sb.append(n).append(" is NOT perfect.\n");
            }

        }

        System.out.print(sb);
    }
}
