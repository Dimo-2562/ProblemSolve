package lv3.structure.tree;

import java.util.*;

/*
판매에 의하여 발생하는 이익의 10%를 추천인에게 배분.
이익의 90%는 자신이 가진다.
10% 계산할 때는 원 단위에서 절사.
이익은 위로만 10%씩 보낸다.

한 개를 판매하여 얻는 이익은 100원

<입력>
enroll
- enroll: 민호를 제외한 조직 구성원의 수 (1 ~ 10^4)
referral
- referral: 판매원을 조직에 참여시킨 사람의 이름
- parent가 민호인 경우 -가 기입.
- enroll에 등장하는 순서와 동일함.
seller
- seller: amount가 누구에게 발생했는지 (1 ~ 10^5)
amount
- amount: 집계 데이터 판매량
- 원소 (1 ~ 10^2)

<출력>

<풀이>
*/

class 다단계칫솔판매 {
    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        int[] parent = new int[enroll.length];
        int[] answer = new int[enroll.length];

        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < enroll.length; i++) {
            map.put(enroll[i], i);
        }

        for (int i = 0; i < referral.length; i++) {
            String s = referral[i];

            if (s.equals("-"))
                parent[i] = -1;
            else {
                parent[i] = map.get(s);
            }
        }

        for (int i = 0; i < amount.length; i++) {
            int cur = map.get(seller[i]);
            int money = amount[i] * 100;

            while (cur != -1 && money > 0) {
                int give = money / 10;
                int mine = money - give;

                answer[cur] += mine;

                money = give;
                cur = parent[cur];
            }
        }

        return answer;
    }
}