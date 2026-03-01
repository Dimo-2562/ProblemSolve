package later;

import java.io.*;

/*
N개의 옵션
1개 or 여러 개의 단어로 옵션의 기능을 설명
각 옵션에 단축키를 의미하는 대표 알파벳을 지정
1. 첫 번째 글자가 지정되어 있는지 체크
2. 모든 단어의 첫 글자가 지정이 되어있다면 왼쪽부터 봐서 단축키로 지정되지 않은 것 지정
3. 지정할 수 없다면 그냥 놔두기

N
- 옵션의 개수
옵션 문자열
 */

public class Problem1283Later {

    static boolean[] alpha = new boolean[26];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            String[] words = line.split(" ");
            int idx = -1;

            // 1. 각 단어의 첫 글자 체크
            int pos = 0;
            for (String word : words) {
                char c  = word.toLowerCase().charAt(0);
                if (!alpha[c - 'a']) {
                    alpha[c - 'a'] = true;
                    idx = pos;
                    break;
                }
                pos += word.length()+1;
            }

            // 2. 전체 돌면서 체크
            if (idx == -1) {
                String str = line.toLowerCase();
                for (int j = 0; j < line.length(); j++) {
                    if(str.charAt(j) == ' ') continue;
                    if (alpha[str.charAt(j) - 'a'] == false) {
                        alpha[str.charAt(j) - 'a'] = true;
                        idx = j;
                        break;
                    }
                }
            }

            if (idx == -1) {
                sb.append(line).append('\n');
            } else {
                for (int j = 0; j < line.length(); j++) {
                    if (j == idx) {
                        sb.append('[').append(line.charAt(j)).append(']');
                    } else {
                        sb.append(line.charAt(j));
                    }
                }
                sb.append('\n');
            }
        }

        System.out.print(sb);

    }
}
