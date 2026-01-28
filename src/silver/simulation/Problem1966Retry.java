package silver.simulation;

import java.util.*;
import java.io.*;

public class Problem1966Retry {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (t-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int pos = Integer.parseInt(st.nextToken());

            Deque<int[]> dq = new ArrayDeque<>();
            PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                int num = Integer.parseInt(st.nextToken());
                dq.add(new int[]{i, num});
                pq.add(num);
            }

            int ans = 0;
            while (!dq.isEmpty()) {
                int[] cur = dq.poll();

                if (cur[1] == pq.peek()){
                    ans++;
                    pq.poll();
                    if (cur[0] == pos){
                        sb.append(ans).append('\n');
                        break;
                    }
                } else {
                    dq.add(cur);
                }
            }
        }

        System.out.print(sb);
    }
}
