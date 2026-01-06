package string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem1157 {
    public static void main(String[] args) throws IOException {
        // 1. 입력 받기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 2. 대문자로 바꾸기
        String s = br.readLine().toUpperCase();

        // 3. 개수 체크
        int[] arr = new int[26];
        for (char c : s.toCharArray()) {
            arr[c - 'A']++;
        }

        boolean flag = true;
        int max = arr[0];
        int maxIdx = 0;
        for (int i = 1; i < 26; i++) {
            if (arr[i] == max) {
                flag = false;
            } else if (arr[i] > max) {
                flag = true;
                max = arr[i];
                maxIdx = i;
            }
        }

        if (flag) {
            System.out.print((char)('A' + maxIdx));
        } else {
            System.out.print('?');
        }
    }
}
