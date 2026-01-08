package bronze.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Problem10798 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[][] arr = new char[5][15];
        for(int i = 0; i < 5; i++) {
            Arrays.fill(arr[i], '!');
        }

        // 입력 받기
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < 5; i++) {
            char[] line = br.readLine().toCharArray();
            max = Math.max(max, line.length);
            for (int j = 0; j < line.length; j++) {
                arr[i][j] = line[j];
            }
        }

        // 이어 붙이기 -> 비어있으면 무시
        StringBuilder sb = new StringBuilder();
        for (int j = 0; j < max; j++) {
            for (int i = 0; i < 5; i++) {
                if (arr[i][j] != '!') {
                    sb.append(arr[i][j]);
                }
            }
        }

        System.out.print(sb);
    }
}
