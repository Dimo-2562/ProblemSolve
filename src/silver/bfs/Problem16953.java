package silver.bfs;

import java.util.*;
import java.io.*;

public class Problem16953 {
    public static void main(String[] args) throws IOException {
        // 연산 1. 2배
        // 연산 2. 10배 + 1

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        Deque<int[]> q = new ArrayDeque<>();
        q.addLast(new int[]{b, 1});
        boolean flag = false;
        while (q.size() > 0) {
            int[] cur = q.pollFirst();
            int num = cur[0];
            int val = cur[1];

            if (num == a) {
                System.out.print(val);
                flag = true;
                break;
            }

            if ((num-1) % 10 == 0 && (num-1) / 10 >= a) {
                q.addLast(new int[]{(num-1)/10, val+1});
            }
            if ((num % 2 == 0) && num / 2 >= a) {
                q.addLast(new int[]{num/2, val+1});
            }
        }

        if(!flag) System.out.print("-1");
    }
}
