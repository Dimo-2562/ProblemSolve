package silver.implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem1316Retry {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int answer = 0;
        while (n-- > 0) {
            boolean[] alphabet = new boolean[26];

            boolean flag = true;
            Character prev = ' ';
            for (char c : br.readLine().toCharArray()) {
                if (alphabet[c - 'a'] == false) {
                    alphabet[c - 'a'] = true;
                    prev = c;
                } else {
                    if (c != prev){
                        flag = false;
                        break;
                    }
                }
            }

            if (flag) answer++;
        }

        System.out.print(answer);
    }
}
