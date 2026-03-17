package silver.greedy;

import java.io.*;
import java.util.*;

public class Problem19941Retry {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        char[] input = br.readLine().toCharArray();
        int answer = 0;
        for (int i = 0; i < n; i++) {
            if (input[i] != 'P') continue;

            int min = Math.max(0, i-k);
            int max = Math.min(n-1, i+k);

            for(int j = min; j <= max; j++) {
                if(input[j] == 'H') {
                    input[j] = ' ';
                    answer++;
                    break;
                }
            }
        }

        System.out.print(answer);

    }
}
