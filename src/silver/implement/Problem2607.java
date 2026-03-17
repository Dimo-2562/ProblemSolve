package silver.implement;

import java.io.*;

/*
알파벳 대문자로 이루어진 두 단어가 아래 조건을 만족하면 같은 것으로 봄.
- 두 개의 단어가 같은 종류의 문자로 이루어져 있다.
- 같은 문자는 같은 개수만큼 있다.

같은 구성 or 한 단어에서 한 문자를 더하거나, 빼거나, 하나의 문자를 다른 문자로 바꾸면 비슷한 것으로 봄.

<입력>
N
- N: 단어의 개수
단어들
- 개수: 1 ~ 10^2
- 길이: 1 ~ 10

<출력>
첫 번째 단어와 비슷한 단어가 몇 개인지.

즉, 순서 상관없이 문자의 count로만. 각 문자의 차이를 구해서 더했을 때 1까지면 ok.
int[] alphabet
 */

public class Problem2607 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        // 처음 단어 처리
        String first = br.readLine();
        int[] alphabet = new int[30];
        for (char c: first.toCharArray()) {
            alphabet[c - 'A']++;
        }

        // 다음 단어들 체크
        int answer = 0;
        for (int i = 1; i < n; i++) {
            String input = br.readLine();
            int[] inputArr = new int[30];
            for (char c : input.toCharArray()) {
                inputArr[c - 'A']++;
            }

            // 케이스가 2개
            // A. 문자가 하나 더 많거나 적은경우
            // B. 문자를 하나 바꾼경우 -> 하나는 적어지고, 하나는 많아짐.
            int other = 0;
            for (int j = 0; j < 30; j++) {
                other += Math.abs(alphabet[j] - inputArr[j]);
            }

            if (other <= 1) answer++;
            else if (other == 2) {
                int sum = 0;
                for (int j = 0; j < 30; j++) {
                    sum += alphabet[j] - inputArr[j];
                }
                if (sum == 0) answer++;
            }
        }

        System.out.print(answer);

    }
}
