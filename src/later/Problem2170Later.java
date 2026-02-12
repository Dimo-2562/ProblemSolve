package later;

import java.io.*;
import java.util.*;

public class Problem2170Later {
    /*
    일차원 직선이 여러 개 나옴.
    start or end 순으로 정렬

    N: 10^6 -> NlogN까지만.
     */

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        List<int[]> points = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            if (x > y) {
                int tmp = y;
                y = x;
                x = tmp;
            }
            points.add(new int[] {x, 1});
            points.add(new int[] {y, -1});
        }

        points.sort((a, b) -> {
           if (a[0] != b[0]) return a[0] - b[0];
           return b[1] - a[1];
        });

        int answer = 0;
        int count = 0;
        int prev = 0;

        for (int[] p : points) {
            if (count > 0) {
                answer += p[0] - prev;
            }
            count += p[1];
            prev = p[0];
        }

        System.out.print(answer);
    }
}
