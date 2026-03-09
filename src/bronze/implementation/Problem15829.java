package bronze.implementation;

import java.io.*;

public class Problem15829 {

    static final int MOD = 1234567891;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int L = Integer.parseInt(br.readLine());
        String str = br.readLine();

        long hash = 0;
        long power = 1;
        for (int i = 0; i < L; i++) {
            hash = (hash + (str.charAt(i) - 'a' + 1) * power) % MOD;
            power = power * 31 % MOD;
        }

        System.out.println(hash);
    }
}
