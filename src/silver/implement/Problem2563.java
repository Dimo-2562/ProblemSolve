package silver.implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem2563 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        boolean[][] black = new boolean[101][101];
        for(int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int left = Integer.parseInt(st.nextToken());
            int down = Integer.parseInt(st.nextToken());
            for(int j = left; j < Math.min(100, left+10); j++){
                for(int k = down; k < Math.min(100, down+10); k++){
                    black[j][k] = true;
                }
            }
        }

        int answer = 0;
        for (int i = 1; i < 101; i++) {
            for (int j = 1; j < 101; j++) {
                if(black[i][j]) {
                    answer++;
                }
            }
        }

        System.out.print(answer);

    }
}
