package silver.bruteforce;

import java.io.*;

/*
666

N번째 종말의 수.

<입력>
N
- N: N번째로 작은 종말의 수 (1 ~ 10^4)

<출력>
N번째 수
 */

public class Problem1436 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int cnt = 0;
        int i = 666;
        while (cnt != n) {
            if(String.valueOf(i).contains("666")) {
                cnt++;
            }
            if (cnt == n) break;
            i++;
        }

        System.out.print(i);
    }
}
