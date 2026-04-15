package gold.bruteforce;

import java.io.*;
import java.util.*;

/*
1 ~ N층까지 이용가능
K자리 숫자
0으로 시작 가능

빌런 호석이는 1 ~ P개를 반전
반전 시키고 올바른 수가 되도록 할 예정.
LED를 고를 수 있는 경우이 수를 계산해보자.

<입력>
N, K, P, X
- N: 최대 층 (1 ~ 10^6)
- K: 숫자의 자리 개수 (1 ~ 6)
- P: 반전시킬 LED의 최대 개수 (1 ~ 42)
- X: 현재 엘레베이터의 층 수 (1 ~ 10^6)

<출력>
LED를 올바르게 반전시킬 수 있는 경우의 수

<풀이>
자리수가 최대 6자리이므로 모든 숫자로 변환해보고 가능한지 체크.
백트래킹?

1, 1, 1, 1, 1, 1, 0
0, 0, 0, 0, 1, 1, 0
1, 0, 1, 1, 0, 1, 1
1, 0, 0, 1, 1, 1, 1
0, 1, 0, 0, 1, 1, 1
1, 1, 0, 1, 1, 0, 1
1, 1, 1, 1, 1, 0, 1
1, 0, 0, 0, 1, 1, 0
1, 1, 1, 1, 1, 1, 1
1, 1, 0, 1, 1, 1, 1

 */

public class Problem22251 {
    static int[][] num = {
            {1, 1, 1, 1, 1, 1, 0},
            {0, 0, 0, 0, 1, 1, 0},
            {1, 0, 1, 1, 0, 1, 1},
            {1, 0, 0, 1, 1, 1, 1},
            {0, 1, 0, 0, 1, 1, 1},
            {1, 1, 0, 1, 1, 0, 1},
            {1, 1, 1, 1, 1, 0, 1},
            {1, 0, 0, 0, 1, 1, 0},
            {1, 1, 1, 1, 1, 1, 1},
            {1, 1, 0, 1, 1, 1, 1}
    };
    static int[][] reverseNum = new int[10][10];
    static int[] digits;

    static int n, k, p, x;
    static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        init();

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        p = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());
        digits = toDigits(x);

        backTracking(0, 0, 0);

        System.out.print(answer);
    }

    static void init() {
        for (int i = 0; i <= 9; i++) {
            for (int j = 0; j <= 9; j++) {
                int cnt = 0;
                for (int k = 0; k < 7; k++) {
                    if (num[i][k] != num[j][k]) cnt++;
                }
                reverseNum[i][j] = cnt;
            }
        }
    }

    static int[] toDigits(int num) {
        int[] arr = new int[k + 1];
        for (int i = k; i >= 1; i--) {
            arr[i] = num % 10;
            num /= 10;
        }
        return arr;
    }
    // 100 (1, 0, 0)

    static void backTracking(int depth, int cost, int value) {
        if (cost > p) return;

        if (depth == k) {
            if (value >= 1 && value <= n && cost >= 1 && value != x) answer++;
            return;
        }

        for (int i = 0; i <= 9; i++) {
            backTracking(depth + 1, cost + reverseNum[digits[depth + 1]][i], value * 10 + i);
        }
    }
}
