package silver.structure.deque;

import java.io.*;
import java.util.*;

/*
시간제한 0.3초

영어 소문자만 입력할 수 있는 편집기
최대 10^5글자.

커서
ㅇaㅇbㅇcㅇdㅇ
임의의 ㅇ 위치에는 다 들어갈 수 있음.
처음에는 문장의 맨 뒤에 위치.

명령어
L: 왼쪽으로 한 칸 (맨 앞이면 무시)
D: 오른쪽으로 한 칸 (맨 뒤이면 무시)
B: 왼쪽에 있는 문자를 삭제
P $: $라는 문자를 커서 왼쪽에 추가함.

<입력>
문자열
- 길이 (1 ~ 10^5)
M
- M: 명령어의 개수 (1 ~ 10^5)
명령어 (M개의 줄)

<출력>
모든 명령어를 수행하고 난 후 편집기에 입력되어 있는 문자열.

커서를 기준으로 deque를 두 개.
 */

public class Problem1406 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine();
        int m = Integer.parseInt(br.readLine());

        Deque<Character> left = new ArrayDeque<>();
        Deque<Character> right = new ArrayDeque<>();
        for (char c : input.toCharArray()) {
            left.addLast(c);
        }

        while (m-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String com = st.nextToken();

            switch (com) {
                case "L":
                    if (!left.isEmpty()) right.addFirst(left.pollLast());
                    break;
                case "D":
                    if (!right.isEmpty()) left.addLast(right.pollFirst());
                    break;
                case "B":
                    if (!left.isEmpty()) left.pollLast();
                    break;
                case "P":
                    String tmp = st.nextToken();
                    left.addLast(tmp.charAt(0));
                    break;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (char c: left) {
            sb.append(c);
        }
        for (char c: right) {
            sb.append(c);
        }
        System.out.print(sb);
    }
}
