package silver.simulation;

import java.io.*;
import java.util.*;

public class Problem1966 {
    public static void main(String[] args) throws IOException {
        // FIFO
        // 큐에 가장 앞에있는 문서의 중요도를 체크
        // 나머지 문서들 중 중요도가 높은 문서가 있다면 큐의 가장 뒤에 배치.
        // 큐에서 어떤 문서가 몇 번째로 인쇄되는지 알아내는 것.

        // 입력
        // T: 테스트 케이스의 수
        // N: 문서의 개수 (10^2)
        // 내가 궁금한 문서의 위치
        // N개의 중요도

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (t-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int pos = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            LinkedList<int[]> q = new LinkedList<>();
            for (int i = 0; i < n; i++) {
                q.add(new int[]{i, Integer.parseInt(st.nextToken())});
            }

            int ans = 0;
            while (!q.isEmpty()) {
                int[] cur = q.pollFirst();
                boolean isMax = true;

                for (int[] next : q) {
                    if (cur[1] < next[1]) {
                        isMax = false;
                        break;
                    }
                }

                if (isMax) {
                    ans++;
                    if (cur[0] == pos) {
                        sb.append(ans).append('\n');
                        break;
                    }
                } else {
                    q.add(cur);
                }
            }
        }

        System.out.print(sb);
    }
}
