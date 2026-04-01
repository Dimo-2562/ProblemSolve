package silver.greedy;

import java.io.*;
import java.util.*;

/*
세 가지 액션 중 하나
1. 주식 하나를 산다
2. 원하는 만큼 가지고 있는 주식을 판다.
3. 아무것도 안한다.

최대 이익을 계산하라.

<입력>
T
- T: 테스트케이스 수
N
- N: 날의 수 (2 ~ 10^6)
N개의 주가들
- 각 주가 (1 ~ 10^4)

<출력>
최대 이익을 나타내는 정수 하나를 테스트케이스마다 출력
(줄바꿈)

long 자료형
N^2 풀이는 불가. -> NlogN
 */

public class Problem11501Later {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());

            int[] arr = new int[n];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            long answer = 0;
            long max = 0;
            for (int i = n-1; i >= 0; i--) {
                max = Math.max(max, arr[i]);
                answer += max - arr[i];
            }
            sb.append(answer).append('\n');
        }
        System.out.print(sb);
    }
}
