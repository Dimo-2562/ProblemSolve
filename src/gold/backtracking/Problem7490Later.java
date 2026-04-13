package gold.backtracking;

import java.io.*;

/*
1 ~ N까지 오름차순 수열
+, -, 공백(숫자 이어붙이기)을 숫자 사이에 삽입
그 결과가 0이 될 수 있는지 살피자.

<입력>
T
- T: 테스트 케이스의 수 (1 ~ 10)
N (T개의 줄)
- N: (3 ~ 9)

<출력>
0이 되는 모든 수식을 출력.
- 각 테스트 케이스는 한 줄을 띄워 구분.

<풀이>
백트래킹 -> 3^8 * 10
그 결과 처리.
 */

public class Problem7490Later {

    static int n;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            n = Integer.parseInt(br.readLine());

            backTracking(1, "1");
            sb.append('\n');
        }

        System.out.print(sb);
    }

    static void backTracking(int cur, String str) {
        if (cur == n) {
            if (calculate(str) == 0) {
                sb.append(str).append('\n');
            }
            return;
        }

        int next = cur + 1;

        backTracking(next, str + " " + next);
        backTracking(next, str + "+" + next);
        backTracking(next, str + "-" + next);
    }

    static int calculate(String str) {
        int sum = 0;

        int num = 0;
        char op = '+';
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);

            if (c == '+' || c == '-') {
                if (op == '+') sum += num;
                else sum -= num;

                op = c;
                num = 0;
            } else if (c == ' ') {
                continue;
            } else {
                num = num * 10 + (c - '0');
            }
        }

        if (op == '+') sum += num;
        else sum -= num;

        return sum;
    }
}
