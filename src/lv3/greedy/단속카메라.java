package lv3.greedy;

import java.io.*;
import java.util.*;

/*
모든 차량이 단속용 카메라를 한 번은 만나도록 카메라를 설치
차량의 경로가 주어짐.
진입/진출 시점에 카메라가 설치되어 있어도 카메라를 만난 것으로 함

최소 몇 대의 카메라를 설치해야 하는가?

<입력>
int[][] routes
- routes: 차량의 경로
- 크기 (1 ~ 10^4)
- 원소의 값 (-10^4 ~ 10^4)

<출력>
설치해야 하는 카메라의 최소 개수

<풀이>
정렬
1. 시작 지점 기준
-20, -13
-18, -15
-14, -5
-5, -3

2. 종료 지점 기준
-18, -15
-20, -13
-14, -5
-5, -3

최대한 끝에 설치한 후 시작 지점과 비교하며 카메라 추가.
*/

class 단속카메라 {
    public int solution(int[][] routes) {
        // 끝점 기준 정렬
        List<int[]> list = new ArrayList<>();
        for(int[] route: routes) {
            list.add(route);
        }
        list.sort((o1, o2) -> o1[1] - o2[1]);

        int answer = 0;
        int pos = Integer.MIN_VALUE;
        for (int[] route: list) {
            if (pos < route[0]) {
                pos = route[1];
                answer++;
            }
        }

        return answer;
    }
}