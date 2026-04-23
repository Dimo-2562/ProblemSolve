package lv3.greedy;

/*
N개의 아파트
몇 개의 아파트에는 4g 기지국이 설치됨.
4g를 5g로 바꾸려고 한다.

5g는 전파 거리가 w
5g 기지국을 최소로 설치하면서 모든 아파트에 전달하려고 함.

<입력>
n, int[] stations, w
- n: 아파트의 개수 (1 ~ 10^8)
- int[] stations: 현재 기지국이 설치된 아파트의 번호
- w: 전파의 도달 거리 (1 ~ 10^4)

<출력>
모든 아파트에 전파를 전달하기 위해 증설해야 할 기지국 개수의 최솟값

<풀이>
파라미터 서치?
m개의 기지국으로 다 커버가 되는지 체크. O(NlogN)

그리디?
2w + 1칸에 두면 됨.
빈 구간마다 체크

왼쪽, 중앙, 오른쪽
*/

class 기지국설치Later {
    public int solution(int n, int[] stations, int w) {
        int cover = 2 * w + 1;

        int answer = 0;
        int start = 1;

        for (int pos: stations) {
            int len = (pos - w) - start;

            if (len > 0) {
                answer += (len + cover - 1) / cover;
            }

            start = pos + w + 1;
        }

        if (start <= n) {
            int len = n - start + 1;
            answer += (len + cover - 1) / cover;
        }

        return answer;
    }
}