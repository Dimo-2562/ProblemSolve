package bronze.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem3003 {
    private static int[] arr = {
            1, 1, 2, 2, 2, 8
    };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            int num = Integer.parseInt(st.nextToken());
            arr[i] = arr[i] - num;
            sb.append(arr[i]).append(' ');
        }

        System.out.print(sb);

    }
}
