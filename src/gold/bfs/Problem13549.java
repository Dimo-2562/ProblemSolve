package gold.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.StringTokenizer;

public class Problem13549 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        final int max = 100001;
        int[] dist = new int[max * 2];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[n] = 0;

        Deque<Integer> dq = new ArrayDeque<>();
        dq.addFirst(n);

        while (!dq.isEmpty()) {
            int cur = dq.poll();

            if (cur == k) {
                System.out.print(dist[cur]);
                return;
            }

            if (cur * 2 <= max * 2 && dist[cur] < dist[cur * 2]) {
                dist[cur * 2] = dist[cur];
                dq.addFirst(cur * 2);
            }
            if (cur + 1 <= max && dist[cur] + 1 < dist[cur + 1]) {
                dist[cur + 1] = dist[cur] + 1;
                dq.addLast(cur + 1);
            }
            if (cur - 1 >= 0 && dist[cur] + 1 < dist[cur - 1]) {
                dist[cur - 1] = dist[cur] + 1;
                dq.addLast(cur - 1);
            }
        }
    }
}
