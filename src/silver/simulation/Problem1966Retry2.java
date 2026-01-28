package silver.simulation;

import java.io.*;
import java.util.*;

public class Problem1966Retry2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        while (t-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int pos = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            Deque<int[]> dq = new ArrayDeque<>();
            int[] cnt = new int[10];
            int maxPriority = Integer.MIN_VALUE;
            for (int i = 0; i < n; i++) {
                int num = Integer.parseInt(st.nextToken());
                dq.add(new int[]{i, num});
                cnt[num]++;
                maxPriority = Math.max(maxPriority, num);
            }

            int ans = 0;
            while (!dq.isEmpty()) {
                int[] cur = dq.poll();

                if (cur[1] == maxPriority){
                    ans++;
                    if (pos == cur[0]){
                        sb.append(ans).append('\n');
                        break;
                    }

                    cnt[cur[1]]--;
                    while (maxPriority > 0 && cnt[maxPriority] == 0){
                        maxPriority--;
                    }
                } else {
                    dq.add(cur);
                }
            }
        }

        System.out.print(sb);
    }
}
