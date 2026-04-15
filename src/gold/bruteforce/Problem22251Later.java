package gold.bruteforce;

import java.io.*;
import java.util.*;

/*
1 ~ N층
K자리 수
0으로 시작 가능.

1 ~ P개를 반전시킬 계획
반전 이후에 올바른 수가 보여지며, 1 ~ N 사이의 수가 되도록.
X층에 멈춰있을 때, 호석이가 반전시킬 LED를 고를 수 있는 경우의 수를 계산하라.

<입력>
N, K, P, X
- N: 층의 높이 (1 ~ 10^6)
- K: 디스플레이 자리수 (1 ~ 6)
- P: 호석이가 바꾸려고 하는 LED의 수 (1 ~ 42)
- X: 현재 층 (1 ~ 10^6)

<출력>
LED를 올바르게 반전시킬 수 있는 경우의 수

<풀이>
각 숫자를 바꾸는데 필요한 개수
boolean[][] light = {
    {T, T, T, T, T, T, F} 0
    {F, F, F, F, T, T, F} 1
    {T, F, T, T, F, T, T} 2
    {T, F, F, T, T, T, T} 3
    {F, T, F, F, T, T, T} 4
    {T, T, F, T, T, F, T} 5
    {T, T, T, T, T, F, T} 6
    {T, F, F, F, T, T, F} 7
    {T, T, T, T, T, T, T} 8
    {T, T, F, T, T, T, T} 9
}
이걸 토대로 각 숫자에서 숫자로 바꾸는 비용 계산

1. 각 자리에 들어갈 목표 숫자 구하기.
브루트포스
 */

public class Problem22251Later {
    static int[][] light = {
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
    static int[][] cost = new int[10][10];
    static int[] xDigits;
    static int answer = 0;
    static int n, k, p, x;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        p = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());

        init();
        xDigits = toDigits(x);

        dfs(0, 0, 0);

        System.out.println(answer);

    }

    static void init() {
        for (int i = 0; i <= 9; i++) {
            for (int j = 0; j <= 9; j++) {
                if (i == j) continue;

                int cnt = 0;
                for (int k = 0; k <= 6; k++) {
                    if (light[i][k] != light[j][k]) cnt++;
                }
                cost[i][j] = cnt;
            }
        }
    }

    static int[] toDigits(int num) {
        int[] digits = new int[k + 1];
        for (int i = k; i >= 1; i--) {
            digits[i] = num % 10;
            num /= 10;
        }
        return digits;
    }

    static void dfs(int depth, int used, int value) {
        if (used > p) return;

        if (depth == k) {
            if (value >= 1 && value <= n && value != x && used >= 1) answer++;
            return;
        }

        int curDigit = xDigits[depth + 1];
        for (int i = 0; i <= 9; i++) {
            dfs(depth + 1, used + cost[curDigit][i], value * 10 + i);
        }
    }
}