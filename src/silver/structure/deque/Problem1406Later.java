package silver.structure.deque;

import java.io.*;
import java.util.*;

/*
한 줄로 된 간단한 에디터
영어 소문자만 기록
최대 600,000개의 글자.

커서
- 문장의 맨 앞, 맨 뒤, 문장 중간 임의의 곳에 위치 가능.

명령어
- L: 커서를 왼쪽으로 한 칸 (단, 문장의 맨 앞일경우 무시)
- D: 커서를 오른쪽으로 한 칸 (단, 문장의 맨 뒤일경우 무시)
- B: 커서 왼쪽에 있는 문자를 삭제 (단, 문장의 맨 앞일경우 무시)
- P $: $라는 문자를 커서 왼쪽에 추가.

초기 커서 위치는 문장의 맨 뒤.

<입력>
문자열
- 영어 소문자로 구성.
- 길이는 10^5
M
- M: 입력할 명령어의 개수 (1 ~ 10^5)
입력할 명령어.

자료구조 고민... 특정 위치 문자를 삭제 + 삽입이 가능해야 함. -> 그냥 String
-> 시간복잡도 초과.
커서를 기준으로 deque 두 개로 나누기.
ㅇaㅇbㅇcㅇdㅇ
 */

public class Problem1406Later {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Deque<Character> left = new ArrayDeque<>();
        Deque<Character> right = new ArrayDeque<>();
        for (char c: br.readLine().toCharArray()) {
            left.addLast(c);
        }

        int m = Integer.parseInt(br.readLine());
        while (m-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            String input = st.nextToken();
            switch (input) {
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
                    String c = st.nextToken();
                    left.addLast(c.charAt(0));
            }
        }

        StringBuilder sb = new StringBuilder();
        for (char c : left) {
            sb.append(c);
        }
        for (char c : right) {
            sb.append(c);
        }
        System.out.print(sb);
    }
}