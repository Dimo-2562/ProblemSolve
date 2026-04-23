package lv3.greedy;

import java.io.*;
import java.util.*;

/*
N개의 아파트
w = 전파의 도달 거리

기지국을 최소로 설치.

<입력>
N
- N: 아파트의 개수 (1 ~ 10^8)
stations
- stations: 현재 기지국이 설치된 아파트의 번호 (1 ~ 10^4)
- 원소들은 오름차순 정렬 (1 ~ 10^8)
w
- w: 전파의 도달 거리 (1 ~ 10^4)

<출력>
증설해야 할 기지국의 최솟값.

<풀이>
빈 구간에 설치.
처음, 기지국 사이, 끝으로 구간을 나누기.

기지국을 그리디하게 설치.


*/

class 기지국설치 {
    public int solution(int n, int[] stations, int w) {
        int start = 1;

        int answer = 0;

        for (int spot : stations) {
            int end = spot - w - 1;
            int range = 2 * w + 1;

            // 올림 공식
            int len = end - start + 1;
            answer += (len + range - 1) / range;

            start = spot + w + 1;
        }

        int end = n;
        int len = end - start + 1;
        int range = 2 * w + 1;

        answer += (len + range - 1) / range;

        return answer;
    }
}