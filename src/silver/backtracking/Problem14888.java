package silver.backtracking;

import java.util.*;
import java.io.*;

/*
백트래킹

입력
N
- N: 수의 개수 (2 ~ 11)
수열
4개의 정수
- 덧셈, 뺄셈, 곱셈, 나눗셈의 개수
 */

public class Problem14888 {

    static int[] exp = new int[4];
    static int[] arr;
    static int n;
    static int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            exp[i] = Integer.parseInt(st.nextToken());
        }

        backTracking(1, arr[0]);

        System.out.println(max + "\n" + min);
    }

    static void backTracking(int depth, int sum) {
        if(depth == n) {
            max = Math.max(sum, max);
            min = Math.min(sum, min);
        }

        for (int i = 0; i < 4; i++) {
            if(i == 0 && exp[i] > 0) {
                exp[i]--;
                backTracking(depth+1, sum+arr[depth]);
                exp[i]++;
            } if(i == 1 && exp[i] > 0) {
                exp[i]--;
                backTracking(depth+1, sum-arr[depth]);
                exp[i]++;
            } if(i == 2 && exp[i] > 0) {
                exp[i]--;
                backTracking(depth+1, sum*arr[depth]);
                exp[i]++;
            } if(i == 3 && exp[i] > 0) {
                exp[i]--;
                backTracking(depth+1, sum/arr[depth]);
                exp[i]++;
            }
        }
    }
}
