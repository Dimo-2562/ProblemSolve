package gold.backtracking;

import java.io.*;

/*
1 ~ N까지 오름차순으로 쓴 수열
+, -, 공백을 삽입
만든 수식의 값이 0이 되는 경우를 모두 찾아라.

<입력>
T
- T: 테스트 케이스의 수 (1 ~ 10)
N (T개의 줄)
- (3 ~ 9)

<출력>
ASCII 순서에 따라 결과가 0이 되는 수식을 모두 출력
-> +, -, 공백 순서로 나와야 함.

<풀이>
3^8 = 81 * 81 => 가능
DFS로 완전탐색.

 */

public class Problem7490 {
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());

            dfs(1, n, "1");
            sb.append('\n');
        }

        System.out.print(sb);
    }

    static void dfs(int depth, int end, String exp) {
        if (depth == end) {

            char op = '+';
            int num = 0;
            int sum = 0;
            for (char c : exp.toCharArray()) {
                if (c == '+' || c == '-') {
                    if (op == '+') {
                        sum += num;
                    } else {
                        sum -= num;
                    }
                    num = 0;
                    op = c;
                } else if (c == ' ') {
                    num = num * 10;
                } else {
                    num += (c - '0');
                }
            }

            if (op == '+') {
                sum += num;
            } else {
                sum -= num;
            }

            if (sum == 0) sb.append(exp).append('\n');
            return;
        }

        dfs(depth + 1, end, exp + " " + (depth + 1));
        dfs(depth + 1, end, exp + "+" + (depth + 1));
        dfs(depth + 1, end, exp + "-" + (depth + 1));
    }
}
