package silver.implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Problem1316 {
    public static void main(String[] args) throws IOException {
        // 연속성이 중요
        // 자료구조 -> 배열? 스택? 같은게
        // boolean 배열 + 스택

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int answer = 0;
        while (n-- > 0) {
            boolean[] alphabet = new boolean[26];
            Deque<Character> stack = new ArrayDeque<>();

            char[] input = br.readLine().toCharArray();
            boolean flag = true;
            for (int i = 0; i < input.length; i++) {
                if (alphabet[input[i] - 'a'] == true) {
                    if (stack.getLast() != input[i]) {
                        flag = false;
                        break;
                    }
                }

                stack.addLast(input[i]);
                alphabet[input[i] - 'a'] = true;
            }

            if (flag) answer++;
        }

        System.out.print(answer);
    }
}
