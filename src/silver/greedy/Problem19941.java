package silver.greedy;

import java.util.*;
import java.io.*;

/*
햄버거와 사람이 간격을 두고 나열.
거리가 K이하인 햄버거를 먹을 수 있음.

<입력>
N, K
- N: 식탁의 길이 (1 ~ 10^4)
- K: 햄버거를 선택할 수 있는 위치 (1 ~ 10)
사람과 햄버거의 위치
- P: 사람
- H: 햄버거

<출력>
햄버거를 먹을 수 있는 최대 사람 수

백트래킹 X.
 */

public class Problem19941 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        char[] input = br.readLine().toCharArray();

        int answer = 0;
        for (int i = 0; i < n; i++) {
            char c = input[i];

            if (c == 'H') {
                for (int j = i-k; j <= i+k; j++) {
                    if(j < 0 || j == i || j >= n) continue;
                    if(input[j] == 'P') {
                        answer++;
                        input[j] = ' ';
                        input[i] = ' ';
                        break;
                    }
                }
            } else if (c == 'P') {
                for (int j = i-k; j <= i+k; j++) {
                    if(j < 0 || j == i || j >= n) continue;
                    if(input[j] == 'H') {
                        answer++;
                        input[j] = ' ';
                        input[i] = ' ';
                        break;
                    }
                }
            }
        }

        System.out.println(answer);
    }
}
