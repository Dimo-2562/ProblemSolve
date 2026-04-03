package silver.slidingwindow;

import java.io.*;

/*
a와 b로 구성된 문자열
a를 모두 연속으로 만들기 위한 교환의 횟수를 최소로 하도록.
원형 구조임.

<입력>
문자열
- 길이: ~ 10^3

<출력>
교환의 횟수의 최솟값.

1. 연속인지 체크.
앞뒤로 빼면서 a 개수 체크 -> 전체에서 개수랑 같으면 ok.
2. 연속이 아닐경우 횟수 체크
- b와 b 사이에 있는게 있으면 교환.
- 없으면 그냥 b 옆에 있는거랑 교환.

풀이 생각 못함
-> 슬라이딩 윈도우.
 */

public class Problem1522Later {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine();

        int cntA = 0;
        for (char c : input.toCharArray()) {
            if (c == 'a') cntA++;
        }

        int cntB = 0;
        for (int i = 0; i < cntA; i++) {
            if (input.charAt(i) == 'b') cntB++;
        }

        int min = cntB;
        for (int i = 1; i < input.length(); i++) {

            if (input.charAt(i - 1) == 'b') cntB--;
            if (input.charAt((cntA + i - 1) % input.length()) == 'b') cntB++;

            min = Math.min(cntB, min);
        }

        System.out.print(min);
    }
}
