package silver.bruteforce;

import java.util.*;
import java.io.*;

/*
케이스의 수: 10^3
학생들의 수: 10

bruteforce 적용.
 */

public class Problem10431 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int p = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= p; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            sb.append(num).append(' ');

            int[] student = new int[20];
            int sum = 0;
            for (int j = 0; j < 20; j++) {
                student[j] = Integer.parseInt(st.nextToken());
                for (int k = 0; k < j; k++) {
                    if(student[k] > student[j]) sum++;
                }
            }
            sb.append(sum).append('\n');
        }

        System.out.print(sb);
    }
}
