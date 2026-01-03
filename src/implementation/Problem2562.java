package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem2562 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int max;
        int maxIdx;

        int first = Integer.parseInt(br.readLine());
        max = first;
        maxIdx = 1;

        for(int i = 2; i <= 9; i++){
            int num = Integer.parseInt(br.readLine());
            if(num > max){
                max = num;
                maxIdx = i;
            }
        }

        System.out.println(max + "\n" + maxIdx);
    }
}
