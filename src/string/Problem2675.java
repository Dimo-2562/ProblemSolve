package string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem2675 {
    public static void main(String[] args) throws IOException {
        // S를 입력받고, 각 문자를 R번 반복해 P를 만든 후 출력
        // 테스트케이스 T (10^3)

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        while (t-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            char[] arr = st.nextToken().toCharArray();

            for(int j = 0; j < arr.length; j++) {
                for (int i = 0; i < r; i++) {
                    sb.append(arr[j]);
                }
            }
            sb.append("\n");
        }

        System.out.print(sb);
    }
}
