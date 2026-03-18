package silver.implement;

import java.io.*;
import java.util.*;

/*
N개의 옵션 -> 대표키 지정

1. 왼쪽에서 오른쪽으로 단어의 첫 글자가 단축키로 지정되었는지 체크 후 안되어 있으면 단축키
2. 모든 단어의 첫 글자가 지정이 되어있다면 왼쪽에서부터 차례대로 알파벳을 보면서 단축키로 지정 안 된 것 단축키로
3. 어떠한 것도 단축키로 지정할 수 없다면 그냥 놔두기. (대소문자 구분 X)
4. 1 ~ N번째 옵션까지 모두 적용

<입력>
N
- N: 옵션의 개수 (1 ~ 30)
옵션들
 */

public class Problem1283Retry {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        boolean[] isUsed = new boolean[26];

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            String input = br.readLine();
            StringTokenizer st = new StringTokenizer(input);

            int idx = 0;
            boolean isFinished = false;

            // 단어의 첫 글자 체크.
            while (st.hasMoreTokens()) {
                String word = st.nextToken().toLowerCase();
                char first = word.charAt(0);
                if (!isUsed[first - 'a']) {
                    isUsed[first - 'a'] = true;
                    isFinished = true;
                    break;
                } else {
                    idx += word.length() + 1;
                }
            }

            if (isFinished) {
                for (int j = 0; j < input.length(); j++) {
                    if(j == idx) sb.append('[');
                    sb.append(input.charAt(j));
                    if(j == idx) sb.append(']');
                }
                sb.append('\n');
                continue;
            }

            idx = 0;
            isFinished = false;
            String tmp = input.toLowerCase();

            for (int j = 0; j < tmp.length(); j++) {
                if (tmp.charAt(j) == ' ') continue;

                if (!isUsed[tmp.charAt(j) - 'a']) {
                    isUsed[tmp.charAt(j) - 'a'] = true;
                    idx = j;
                    isFinished = true;
                    break;
                }
            }

            for (int j = 0; j < input.length(); j++) {
                if(isFinished && j == idx) sb.append('[');
                sb.append(input.charAt(j));
                if(isFinished && j == idx) sb.append(']');
            }
            sb.append('\n');
        }

        System.out.print(sb);
    }
}
