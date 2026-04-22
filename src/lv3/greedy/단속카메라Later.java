package lv3.greedy;

import java.util.*;

/*
고속도로를 이용하는 차량이 단속용 카메라를 한 번은 만나도록 카메라를 설치
경로 routes가 주어질 때 최소 몇 대의 카메라를 설치해야 하는가?

<입력>
int[][] routes
- 크기 (1 ~ 10^4)
- 시작 지점 및 나간 지점
- 그 위치에 설치되어도 만난 것으로 간주
- 각 값 (-10^4 ~ 10^4)

<출력>
모든 차량이 한 번은 단속용 카메라를 만나도록 하는 카메라의 최소 개수.

<풀이>
-20 -15
-18 -13
-14 -5
-5 -3

풀이 봄 -> 끝점을 이용한다는 건 파악 완료
단, 끝점 기준으로 정렬해야 함을 인지하지 못함.

*/

class 단속카메라Later {
    public int solution(int[][] routes) {
        List<int[]> list = new ArrayList<>();

        for (int i = 0; i < routes.length; i++) {
            list.add(routes[i]);
        }

        list.sort((o1, o2) -> o1[1] - o2[1]);

        int answer = 1;
        int prev = list.get(0)[1];

        for (int i = 1; i < list.size(); i++) {
            if (list.get(i)[0] <= prev) continue;
            else {
                prev = list.get(i)[1];
                answer++;
            }
        }

        return answer;
    }
}
