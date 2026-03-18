package silver.greedy;

import java.io.*;

/*
0과 1로 구성된 문자열 S
S가 포함하는 0의 개수와 1의 개수는 모두 짝수개

S를 구성하는 문자중 절반의 0과 절반의 1을 제거하여 새로운 문자열 S'를 만들려고 한다.
S'로 가능한 문자열 중 사전 순으로 가장 빠른 것을 구하시오.

<입력>
S
- 길이: 2 ~ 10^2
- 짝수 개의 0과 짝수 개의 1로 이루어져 있음.

<출력>
S'로 가능한 문자열 중 사전순으로 가장 빠른 것.

백트래킹 X.
0과 1의 개수를 체크한 뒤,
0은 뒤에서부터 지우고, 1은 앞에서부터 지우기.
 */

public class Problem20310 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine();
        int[] nums = new int[2];
        boolean[] isDeleted = new boolean[500];
        for (char c : input.toCharArray()) {
            if (c == '0') nums[0]++;
            else nums[1]++;
        }

        for (int i = 0; i < 2; i++) nums[i] /= 2;

        for (int i = 0; i < input.length(); i++) {
            if (nums[1] > 0 && input.charAt(i) == '1') {
                isDeleted[i] = true;
                nums[1]--;
            }
        }

        for (int i = input.length() -1; i >= 0; i--) {
            if (nums[0] > 0 && input.charAt(i) == '0') {
                isDeleted[i] = true;
                nums[0]--;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < input.length(); i++) {
            if (!isDeleted[i]) sb.append(input.charAt(i));
        }
        System.out.println(sb);

    }
}
