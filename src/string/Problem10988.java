package string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem10988 {
    public static void main(String[] args) throws IOException {
        // 투포인터
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] input = br.readLine().toCharArray();

        int left = 0;
        int right = input.length - 1;
        boolean answer = true;
        while (left < right) {
            if(input[left] != input[right]) {
                answer = false;
                break;
            }

            left++;
            right--;
        }

        if(answer) {
            System.out.print(1);
        } else {
            System.out.print(0);
        }
    }
}
