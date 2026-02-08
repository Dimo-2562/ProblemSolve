package silver.bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Problem7568 {
    public static void main(String[] args) throws IOException {
        // N: 전체 사람의 수 (10)
        // N^2도 가능
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        List<int[]> person = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int weight = Integer.parseInt(st.nextToken());
            int height = Integer.parseInt(st.nextToken());
            person.add(new int[]{weight, height});
        }

        // 명백하게 큰 사람과 작은 사람만 카운트
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            int rank = 1;
            for (int j = 0; j < n; j++) {
                if (i == j) continue;
                if (person.get(i)[0] < person.get(j)[0]
                    && person.get(i)[1] < person.get(j)[1] ) {
                    rank++;
                }
            }
            sb.append(rank).append(' ');
        }

        System.out.print(sb);
    }
}
