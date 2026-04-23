package lv3.greedy;

import java.util.*;

/*
일렬로 나열된 n개의 풍선
모든 풍선에는 서로 다른 숫자가 써져 있다.
풍선들이 1개 남을 때까지 계속 터트리려고 한다.
1. 인접한 두 풍선을 고른 뒤, 두 풍선 중 하나를 터트린다.
2. 터진 풍선으로 빈 공간이 생겼다면, 중앙으로 밀착.

인접한 두 풍선 중 번호가 더 작은 풍선을 터트리는 행위는 최대 1번.
즉, 한 번 하고 나면 큰 풍선만 터트릴 수 있다.

어떤 풍선이 최후까지 남을 수 있는지 알아보고 싶다.
어떤 풍선은 무슨 수를 써서라도 마지막까지 남기는 것이 불가능할 수 있다.

<입력>
a
- a : 풍선의 배열 (1 ~ 10^6)
- 원소: 풍선에 써진 숫자 (-10^9 ~ 10^9)
- 숫자는 모두 다르다.

<출력>
최후까지 남기는 것이 가능한 풍선들의 개수를 return.

<풀이>
자기 기준 왼쪽, 오른쪽
-16 기준 -> 제일 작은게 있으므로 다 괜찮, 그리고 마지막에 터트리기.
27 기준 -> 왼쪽도 자기보다 작은 것, 오른쪽도 자기보다 작은 것 -> 불가능
-92는 자기가 제일 작으므로 ㄱㅊ
-71는 우측에선 자기보다 작은 게 없고, 왼쪽은 하나 있어서 ㄱㅊ
-68

매 숫자마다 체크 -> 시간초과
왼쪽부터 그 수 기준 가장 작은 수 체크
오른쪽부터 그 수 기준 가장 작은 수 체크
*/

class 풍선터트리기 {
    public int solution(int[] a) {

        int[] leftArr = new int[a.length];
        leftArr[0] = a[0];
        for (int i = 1; i < leftArr.length; i++) {
            leftArr[i] = Math.min(leftArr[i - 1], a[i]);
        }

        int[] rightArr = new int[a.length];
        rightArr[a.length - 1] = a[a.length - 1];
        for (int i = a.length - 2; i >= 0; i--) {
            rightArr[i] = Math.min(rightArr[i + 1], a[i]);
        }

        int answer = 0;
        for (int i = 0; i < a.length; i++) {
            if (!isOk(leftArr[i], a[i]) && !isOk(rightArr[i], a[i])) continue;
            answer++;
        }

        return answer;
    }

    boolean isOk(int min, int target) {
        if (target > min) return false;
        return true;
    }
}
