package gold.dp;

import java.io.*;
import java.util.*;

/*
전봇대 A와 B 사이에 전깃줄을 교차하지 않도록.

전깃줄의 개수 및 연결되는 위치가 주어질 때
교차하지 않게 하기위해 없애야 하는 최소 개수를 구하라.

<입력>
N
- N: 전깃줄의 개수 (1 ~ 10^2)
A B
- 두 전깃줄의 연결되는 위치 (1 ~ 10^2)
- 같은 위치에 두 개 이상의 전깃줄이 연결되는 건 X.

<출력>
서로 교차하지 않기 위해 없애야 하는 전깃줄의 최소 개수

<풀이>
1 8
2 2
3 9
4 1
6 4
7 6
9 7
10 10

1. 시작 기준으로 오름차순 정렬
2. 도착 기준으로 가장 긴 증가하는 부분 수열이 만들어지는 길이 구하기
3. 전깃줄 개수 - 길이 = 답.
dp[i] = i를 끝으로 하는 가장 긴 증가하는 부분 수열
 */

public class Problem2565 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            list.add(new int[]{s, e});
        }

        list.sort((o1, o2) -> o1[0] - o2[0]);

        int[] dp = new int[n];
        int len = -1;
        for (int i = 0; i < n; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if(list.get(i)[1] > list.get(j)[1]) dp[i] = Math.max(dp[i], dp[j] + 1);
            }
            len = Math.max(len, dp[i]);
        }

        System.out.print(n - len);
    }
}
