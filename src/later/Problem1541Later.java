package later;

import java.io.*;
import java.util.*;

/*
양수, +, -
괄호를 적절히 쳐서 이 식의 값을 최소로 하라.

<입력>
0~9의 숫자, +, -가 입력됨.
- 가장 처음과 마지막 문자는 수자
- 연속해서 두 개 이상의 연산자는 나타나지 않음.
- 5자리보다 많이 연속되는 숫자는 x.
- 수는 0으로 시작 가능.
- 식의 길이: 1 ~ 50.

<출력>
이 식의 최솟값.

그리디.
숫자는 연산자 기준으로 나눈 뒤, Integer.parseInt
- 다음 숫자부터 -가 나올때까지 묶기.
 */

public class Problem1541Later {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), "-");

        int answer = 0;
        boolean isFirst = true;
        while (st.hasMoreTokens()) {
            String str = st.nextToken();

            String[] strArray = str.split("\\+");
            int sum = 0;
            for (int i = 0; i < strArray.length; i++) {
                sum += Integer.parseInt(strArray[i]);
            }

            if (isFirst) {
                isFirst = false;
                answer += sum;
            } else answer -= sum;
        }

        System.out.print(answer);
    }
}