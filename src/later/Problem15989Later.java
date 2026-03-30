package later;

import java.io.*;

/*
1, 2, 3의 합을 통해 수를 나타내기.
순서만 다른 것은 같은 것으로 친다.

dp[1] = 1 (1) -> 1 0 0
dp[2] = 2 (1, 1), (2) -> 1 1 0
dp[3] = 3 (1, 1, 1), (1, 2), (3) -> 1 1 1
dp[4] = 4 (1, 1, 1, 1), (1, 2, 1), (3, 1), (2, 2) -> 1 2 1
dp[5] = 5 (1, 1, 1, 1, 1), (1, 2, 1, 1), (3, 1, 1), (2, 2, 1), (3, 2) -> 1 2 2
dp[6] = 7 (1, 1, 1, 1, 1, 1) , (1, 2, 1, 1, 1), (3, 1, 1, 1), (2, 2, 1, 1), (3, 2, 1), (2, 2, 2), (3, 3) ->

문제 풀이 떠올리지 못함
-> 동전 문제
(1만으로 수 구성), (2까지 허용), (3까지 허용)
 */

public class Problem15989Later {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        int[] dp = new int[10001];
        dp[0] = 1; //합이 0이 되는 방법 1개.

        for (int i = 1; i <= 3; i++) {
            for (int j = i; j <= 10000; j++) {
                dp[j] += dp[j-i];
            }
        }

        StringBuilder sb = new StringBuilder();
        while (t-- > 0) {
            int num = Integer.parseInt(br.readLine());
            sb.append(dp[num]).append('\n');
        }

        System.out.print(sb);
    }
}