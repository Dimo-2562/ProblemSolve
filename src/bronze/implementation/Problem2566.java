package bronze.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem2566 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int max = Integer.MIN_VALUE;
        int maxRow = 0;
        int maxCol = 0;

        for (int i = 1; i <= 9; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= 9; j++) {
                int num = Integer.parseInt(st.nextToken());
                if(max < num) {
                    max = num;
                    maxRow = i;
                    maxCol = j;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append(max).append('\n');
        sb.append(maxRow).append(' ').append(maxCol);

        System.out.print(sb);
    }
}
