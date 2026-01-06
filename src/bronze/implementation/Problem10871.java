package bronze.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Problem10871 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());

        List<Integer> list = new ArrayList<>();
        String[] arr = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            Integer num = Integer.parseInt(arr[i]);
            if (num < x) {
                list.add(num);
            }
        }

        for(Integer num : list) {
            System.out.print(num + " ");
        }
    }
}
