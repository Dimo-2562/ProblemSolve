package gold.binarysearch;

import java.util.*;
import java.io.*;

public class Problem2110 {
    public static void main(String[] args) throws IOException {
        // 집 N개가 수직선 위
        // 공유기를 C개 설치
        // 공유기 사이의 거리를 가능한 크게

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        int[] pos = new int[n];
        for (int i = 0; i < n; i++) {
            pos[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(pos);

        int ans = parametricSearch(pos, c);
        System.out.print(ans);
    }

    private static int parametricSearch(int[] pos, int c) {
        // 인접한 공유기 사이의 거리를 d 이상으로 유지하면서 c개 이상 생성할 수 있는지.
        int start = 1;
        int end = pos[pos.length - 1] - pos[0];
        int ans = 1;
        while (start <= end) {
            int mid = (start + end) / 2;
            int sum = 1;

            int prev = pos[0];
            for (int i = 1; i < pos.length; i++) {
                if (pos[i] - prev >= mid) {
                    sum++;
                    prev = pos[i];
                }
            }

            if (sum >= c) {
                ans = mid;
                start = mid + 1;
            } else {
                end = mid - 1;
            }

        }
        return ans;
    }
}
