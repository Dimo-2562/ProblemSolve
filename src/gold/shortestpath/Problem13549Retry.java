package gold.shortestpath;

import java.util.*;
import java.io.*;

public class Problem13549Retry {
    /*
    현재 점 N (0 ~ 10^5)
    동생은 K (0 ~ 10^5)

    1초 후에 X-1, X+1
    0초 후에 2*X
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));
        pq.add(new int[]{0, n});
        boolean[] visited = new boolean[200000];

        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int curCost = cur[0];
            int curPos = cur[1];

            if (visited[curPos]) continue;
            visited[curPos] = true;

            if (curPos == k) {
                System.out.print(curCost);
                return;
            }

            if (curPos * 2 < 200000 && !visited[curPos*2]) {
                pq.add(new int[]{curCost, curPos * 2});
            }
            if (curPos + 1 <= 100000 && !visited[curPos + 1]) {
                pq.add(new int[]{curCost+1, curPos + 1});
            }
            if (curPos - 1 <= 100000 && curPos - 1 >= 0 && !visited[curPos - 1]) {
                pq.add(new int[]{curCost+1, curPos - 1});
            }
        }
    }
}
