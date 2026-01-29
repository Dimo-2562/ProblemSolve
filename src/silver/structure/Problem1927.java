package silver.structure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Problem1927 {
    public static void main(String[] args) throws IOException {
        /*
        연산 두 가지를 지원.
        - 배열에 자연수 x 넣기
        - 배열에서 가장 작은 값 출력. 그 값을 배열에서 제거

        입력
        - N: 연산의 개수 (10^5)
        - x가 자연수라면 배열에 x 추가
        - x가 0이라면 배열에서 가장 작은 값 출력 + 배열에서 제거
         */

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(br.readLine());
            if (num > 0) {
                pq.add(num);
            } else {
                int tmp = 0;
                if (pq.size() > 0) {
                    tmp = pq.poll();
                }
                sb.append(tmp).append('\n');
            }
        }

        System.out.println(sb);

    }
}
