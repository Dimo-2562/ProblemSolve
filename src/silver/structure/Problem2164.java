package silver.structure;

import java.io.*;
import java.util.*;

public class Problem2164 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Deque<Integer> dq = new ArrayDeque<>();
        for (int i = 1; i <= n; i++) {
            dq.addLast(i);
        }

        while (dq.size() > 1) {
            dq.pollFirst();
            int num = dq.pollFirst();
            dq.addLast(num);
        }

        System.out.println(dq.peekFirst());
    }
}
