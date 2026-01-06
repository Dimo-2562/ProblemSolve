package bronze.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem5597 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] student = new int[31];

        for(int i = 0; i < 28; i++){
            int num = Integer.parseInt(br.readLine());
            student[num] = 1;
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 1; i <= 30; i++){
            if(student[i] == 0){
                sb.append(i).append("\n");
            }
        }
        System.out.print(sb);
    }
}