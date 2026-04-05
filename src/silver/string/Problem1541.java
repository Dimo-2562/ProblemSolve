package silver.string;

import java.io.*;

/*
양수, +, -, 괄호
이 중에서 괄호를 모두 지웠다.

이 식의 값을 최소로 만들려고 한다.

<입력>
식
- 0~9, +, - 만으로 구성됨.
- 두 개 이상의 연산자가 연속으로 나타나지 않음.
- 수는 0으로 시작 가능.
- 식의 길이 (1 ~ 50)

<출력>
이 식의 만들 수 있는 최소 값

-를 기준으로 분리. 그 안에서 + 기준으로 분리해서 합치기.
 */

public class Problem1541 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine();
        String[] first = input.split("-");

        int answer = 0;
        for (int i = 0; i < first.length; i++) {
            String tmp = first[i];

            String[] second = tmp.split("\\+");
            int sum = 0;
            for (int j = 0; j < second.length; j++) {
                sum += Integer.parseInt(second[j]);
            }

            if (i == 0) answer += sum;
            else answer -= sum;
        }

        System.out.print(answer);
    }
}