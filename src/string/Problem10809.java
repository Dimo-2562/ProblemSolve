package string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem10809 {
    public static void main(String[] args) throws IOException {
        // 입력 받기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();

        int[] answer = new int[30];
        for (int i = 0; i < 30; i++) {
            answer[i] = -1;
        }

        // 순회하면서 위치 나오면 처음에만 값 넣기
        char[] chars = s.toCharArray();
        for(int i = 0; i < s.length(); i++) {
            int idx = chars[i] - 'a';
            if(answer[idx] == -1) {
                answer[idx] = i;
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < 26; i++){
            sb.append(answer[i]).append(' ');
        }
        System.out.println(sb);
    }
}
