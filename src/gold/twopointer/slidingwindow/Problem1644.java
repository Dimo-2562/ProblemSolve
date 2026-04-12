package gold.twopointer.slidingwindow;

import java.io.*;
import java.util.*;

/*
자연수를 연속된 소수의 합으로 나타낼 수 있는 경우를 구하라.

<입력>
N
- N: 고려해야 하는 숫자 (1 ~ 10^6)

<출력>
경우의 수

<풀이>
연속된 소수의 합 -> 슬라이딩 윈도우
1. 소수를 구하기.
2. 소수를 배열에서 슬라이딩 윈도우

 */

public class Problem1644 {
    static boolean[] isPrime = new boolean[4000001];
    static List<Integer> primeNum = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        // 1. 소수 구하기.
        checkPrime(n);

        // 2. 슬라이딩 윈도우
        int left = 0;
        long sum = 0;
        int cnt = 0;
        for (int right = 0; right < primeNum.size(); right++) {
            sum += primeNum.get(right);

            while (sum > n) {
                sum -= primeNum.get(left);
                left++;
            }

            if (sum == n) cnt++;
        }

        System.out.print(cnt);
    }

    static void checkPrime(int n) {
        Arrays.fill(isPrime, true);
        isPrime[1] = false;

        for (int i = 2; i * i <= n; i++) {
            for (int j = i * i; j <= n; j += i) {
                if (isPrime[j]) isPrime[j] = false;
            }
        }

        for (int i = 2; i <= n; i++) {
            if (isPrime[i]) primeNum.add(i);
        }
    }
}
