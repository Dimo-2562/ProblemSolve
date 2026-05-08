package later;

import java.util.*;

/*
n개의 집에 택배 배달
물건은 모두 크기가 같은 재활용 택배 상자에 담아 배달
배달을 다니며 빈 재활용 택배 상자들을 수거

배달할 택배들은 모두 재활용 택배 상자에 담겨서 물류창고에 보관
각 집 사이의 거리는 1
트럭에는 상자를 최대 cap개 실을 수 있다.
배달 + 수거

트럭 하나로 물류창고까지 돌아올 수 있는 최소 이동 거리를 구하라.

<입력>
cap
- cap: 트럭에 실을 수 있는 택배 상자의 최대 개수 (1 ~ 50)
n
- n: 배달할 집의 개수 (1 ~ 10^5)
deliveries, pickups
- 각각 배달해야 하는 것, 수거해야 하는 것
- 원소 (1 ~ 50)

<출력>
트럭 하나로 물류창고까지 돌아올 수 있는 최소 이동 거리를 구하라.

<풀이>
그리디

*/

class 택배배달과수거하기Later {
    public long solution(int cap, int n, int[] deliveries, int[] pickups) {

        int dEnd = -1;
        int pEnd = -1;
        for (int i = n - 1; i >= 0; i--) {
            if (deliveries[i] > 0) {
                dEnd = i;
                break;
            }
        }
        for (int i = n - 1; i >= 0; i--) {
            if (pickups[i] > 0) {
                pEnd = i;
                break;
            }
        }

        long answer = 0;
        while (dEnd >= 0 || pEnd >= 0) {
            answer += (long) (Math.max(dEnd, pEnd) + 1) * 2;

            int tmp = cap;
            while (dEnd >= 0 && tmp > 0) {
                if (tmp >= deliveries[dEnd]) {
                    tmp -= deliveries[dEnd];
                    deliveries[dEnd] = 0;
                    while (dEnd >= 0 && deliveries[dEnd] == 0) dEnd--;
                } else {
                    deliveries[dEnd] -= tmp;
                    tmp = 0;
                }
            }

            tmp = cap;
            while (pEnd >= 0 && tmp > 0) {
                if (tmp >= pickups[pEnd]) {
                    tmp -= pickups[pEnd];
                    pickups[pEnd] = 0;
                    while (pEnd >= 0 && pickups[pEnd] == 0) pEnd--;
                } else {
                    pickups[pEnd] -= tmp;
                    tmp = 0;
                }
            }
        }

        return answer;
    }
}