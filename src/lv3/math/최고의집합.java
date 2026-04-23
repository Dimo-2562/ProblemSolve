package lv3.math;

import java.io.*;
import java.util.*;

/*
n개로 이루어진 중복 집합 중 다음 조건을 만족하면 최고의 집합
1. 각 원소의 합이 S
2. 위 조건을 만족하며 각 원소의 곱이 최대가 되는 집합

<입력>
n
- n: 집합의 크기 (1 ~ 10^4)
s
- s: 합이 되어야 하는 수 (1 ~ 10^8)

<출력>
최고의 집합
- 없을 경우 [-1]을 리턴

<풀이>
포인터 X.
수학적 접근 -> 최대한 균등한 게 좋음

int q = s / n
int r = s % n

n이 3, s가 11이면
3 4 4
q가 n - r개, q+1이 r개

n이 3, s가 10이면
3 3 4

*/

class 최고의집합 {
    public int[] solution(int n, int s) {
        if (s < n) return new int[]{-1};

        int[] arr = new int[n];

        int q = s / n; // 4
        int r = s % n;

        for (int i = 0; i < n - r; i++) {
            arr[i] = q;
        }
        for (int i = n - r; i < n; i++) {
            arr[i] = q + 1;
        }

        return arr;
    }
}