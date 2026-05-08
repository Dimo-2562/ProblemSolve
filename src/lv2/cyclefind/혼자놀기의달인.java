package lv2.cyclefind;

import java.util.*;

/*
숫자 카드 더미 -> 총 100장
1 ~ 100까지 숫자
2이상 100이하의 자연수를 하나 정해 그 수보다 작거나 같은 숫자 카드들을 준비
준비한 카드의 수만큼 작은 상자

상자에 카드를 한 장씩 넣고, 상자를 무작위로 섞어 일렬로 나열
상자가 일렬로 나열되면 상자가 나열된 순서에 따라 1번부터 순차적으로 증가하는 번호

임의의 상자 -> 숫자 카드 확인
숫자 카드에 적힌 번호에 해당하는 상자 열어서 확인
이미 열려있는 상자가 나올 때까지 반복
1번 상자 그룹
남는 상자가 없으면 0점

있다면 2번 상자 그룹을 만든다.
곱한 값이 게임의 점수

점수를 최고로 해보자.

<입력>
cards
- cards: 숫자 카드가 나열된 상자들 (2 ~ 10^2)
- cards[i]: 길이 이하의 임의의 자연수
- 중복 원소 없음.

<출력>
두 상자의 카드 개수 곱의 최댓값

<풀이>
1. dfs 돌리면서 다시 돌아오면 그 개수를 List에 넣기
2. 내림차순 정렬
3. 1개면 0 리턴
4. 2개면 두 수 곱하기.
*/

class 혼자놀기의달인 {
    boolean[] visited;
    int[] cards;
    int n;
    List<Integer> list = new ArrayList<>();

    public int solution(int[] cards) {
        this.cards = cards;
        n = cards.length;
        visited = new boolean[n + 1];

        for (int i = 1; i <= n; i++) {
            if (visited[i - 1]) continue;
            dfs(i, 0);
        }

        int answer = 0;
        if (list.size() == 1) return answer;

        list.sort((o1, o2) -> o2 - o1);
        answer = list.get(0) * list.get(1);
        return answer;
    }

    void dfs(int start, int depth) {
        int pos = start - 1;

        if (visited[pos]) {
            list.add(depth);
            return;
        }

        visited[pos] = true;

        dfs(cards[pos], depth + 1);
    }
}
