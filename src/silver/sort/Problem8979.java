package silver.sort;

import java.io.*;
import java.util.*;

/*
N, K
- N: 국가의 수
- K: 등수를 알고 싶은 국가
각 국가의 숫자, 금, 은, 동

자료 구조는? ArrayList
 */

public class Problem8979 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        List<int[]> list = new ArrayList<>();
        while (n-- > 0) {
            st = new StringTokenizer(br.readLine());
            int country = Integer.parseInt(st.nextToken());
            int gold = Integer.parseInt(st.nextToken());
            int silver = Integer.parseInt(st.nextToken());
            int bronze = Integer.parseInt(st.nextToken());
            list.add(new int[] {country, gold, silver, bronze});
        }

        list.sort((o1, o2) -> {
            if (o1[1] != o2[1]) return o2[1] - o1[1];
            if (o1[2] != o2[2]) return o2[2] - o1[2];
            return o2[3] - o1[3];
        });

        int rank = 1;
        int size = list.size();
        for (int i = 0; i < size; i++) {
            if (i > 0) {
                int[] prev = list.get(i-1);
                int[] now = list.get(i);

                if (prev[1] != now[1] || prev[2] != now[2] || prev[3] != now[3]) {
                    rank = i+1;
                }
            }

            if(list.get(i)[0] == k) {
                System.out.println(rank);
                break;
            }
        }
    }
}
