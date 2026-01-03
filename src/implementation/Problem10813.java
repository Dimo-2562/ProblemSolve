package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem10813 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] bucket = new int[n+1];
        for(int i = 1; i <=n; i++){
            bucket[i] = i;
        }

        while(m > 0){
            st = new StringTokenizer(br.readLine());
            int i = Integer.parseInt(st.nextToken());
            int j = Integer.parseInt(st.nextToken());
            swap(i, j, bucket);

            m--;
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 1; i <= n; i++){
            if(i > 1) sb.append(" ");
            sb.append(bucket[i]);
        }
        System.out.println(sb);
    }

    private static void swap(int i, int j, int[] bucket){
        int temp = bucket[i];
        bucket[i] = bucket[j];
        bucket[j] = temp;
    }
}
