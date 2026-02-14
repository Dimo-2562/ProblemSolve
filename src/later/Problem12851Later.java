package later;

import java.util.*;
import java.io.*;

public class Problem12851Later {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        final int MAX = 200002;
        int[] dist = new int[MAX];
        Arrays.fill(dist, -1);
        int[] count = new int[MAX];

        Deque<Integer> queue = new ArrayDeque<>();
        queue.add(n);
        dist[n] = 0;
        count[n] = 1;

        while (!queue.isEmpty()) {
            int cur = queue.poll();

            for (int next : new int[] {cur - 1, cur + 1, cur * 2}) {
                if (next < 0 || next > 100000) continue;

                if (dist[next] == -1) {
                    dist[next] = dist[cur] + 1;
                    count[next] = count[cur];
                    queue.add(next);
                } else if (dist[next] == dist[cur] + 1){
                    count[next] += count[cur];
                }
            }
        }

        System.out.print(dist[k] + "\n" + count[k]);

    }
}
