package later;

import java.io.*;

public class Problem1436Later {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int cnt = 0;
        int num = 665;
        while (cnt < n) {
            num++;
            if (contains666(num)) cnt++;
        }

        System.out.println(num);
    }

    private static boolean contains666(int num) {
        if (String.valueOf(num).contains("666")) return true;
        return false;
    }
}
