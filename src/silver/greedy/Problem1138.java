package silver.greedy;

import java.io.*;
import java.util.*;

/*
N명의 사람들. 키는 모두 다르다.
자기보다 큰 사람이 왼쪽에 몇 명 있었는지를 기억.

<입력>
N
- N : 사람의 수 (1 ~ 10)
키가 1인 사람부터 키가 큰 사람이 왼쪽에 몇 명 있었는지 .

<출력>
처음에 줄을 선 순서대로 키를 출력.

1 왼쪽에 2명
2 왼쪽에 1명
3 왼쪽에 1명.
4 왼쪽에 0명.

높은 사람부터 특정 위치에 넣기. -> ArrayList
 */

public class Problem1138 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] input = new int[n+1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            input[i] = Integer.parseInt(st.nextToken());
        }

        List<Integer> list = new ArrayList<>();
        for (int i = n; i >= 1; i--) {
            list.add(input[i], i);
        }

        StringBuilder sb = new StringBuilder();
        for (int tmp : list) {
            sb.append(tmp).append(' ');
        }
        System.out.print(sb);
    }
}
