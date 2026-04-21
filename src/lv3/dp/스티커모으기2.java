package lv3.dp;

import java.io.*;
import java.util.*;

/*
N개의 스티커가 원형으로 붙어있다.
스티커를 몇 장 떼어내어 떼어낸 숫자들의 합이 최대가 되도록 하자.
단, 스티커 한 장을 뜯어내면 양쪽의 인접한 건 사용할 수 없다.

<입력>
int[] sticker
- 길이 (1 ~ 10^5)
- 각 숫자 (1 ~ 10^2)
- 원형으로 연결됨.

<출력>
떼어낸 스티커들의 합이 최대가 되도록.

<풀이>
DP
원형인 점 제외 -> 단순 선형 DP

dp[1] = arr[1]
dp[2] = Math.max(arr[1], arr[2])
dp[3] = Math.max(dp[2], dp[1] + arr[3])
dp[4] = Math.max(dp[3], dp[2] + arr[4])

어려운 점 -> 원형
케이스를 2개로,
1. 1번을 사용
2. 1번을 사용 X.
*/

class 스티커모으기2 {
    public int solution(int sticker[]) {
        int n = sticker.length;
        if (n == 1) return sticker[0];

        int answer = 0;

        // 1번을 사용 -> n번은 사용불가.
        int[] dp = new int[n + 1];

        dp[1] = sticker[0];
        dp[2] = dp[1];

        for (int i = 3; i < n; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + sticker[i - 1]);
        }

        answer = Math.max(answer, dp[n - 1]);

        // 1번을 사용 X -> n번 사용 가능.
        dp = new int[n + 1];

        dp[1] = 0;
        dp[2] = sticker[1];

        for (int i = 3; i <= n; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + sticker[i - 1]);
        }

        answer = Math.max(answer, dp[n]);

        return answer;
    }
}