package later;

import java.util.*;

/*
코테언어: cpp, java, python
지원직군: backend, frontend
지원 경력구분: junior, senior
소울푸드: chicken, pizza
코딩 테스트 점수

코테 결과를 분석하여 조건에 맞는 지원자가 몇 명인지 쉽게 알 수 있는 도구 만들고 있다.

<입력>
info
- info: 4가지 정보 + 코테 점수를 하나의 문자열로 구성한 것 (1 ~ 10^4)
- [개발언어 직군 경력 소울푸드 점수]
- 점수 (1 ~ 10^5)
- 공백으로 구분
query
- query: 개발팀이 궁금해하는 문의조건 (1 ~ 10^5)
- [조건] X 형식
- [조건]: 개발언어 and 직군 and 경력 and 소울푸드 형식
- '-' 표시는 해당 조건을 고려하지 않겠다
- X: 코딩테스트 점수 조건 (이상 조건)
- 공백으로 구분

<출력>
문의조건에 해당하는 사람들의 숫자를 배열에 담아 return

<풀이>
매번 조건을 다 체크 -> 시간초과

쿼리 -> 10^5
info는 1번만 돌아야 함. 어떻게?
문자열?
자료구조?
비트마스킹?

00
01
10
11


*/

class 순위검색Later {
    Map <String, List<Integer>> map = new HashMap<>();

    public int[] solution(String[] info, String[] query) {

        for (String s : info) {
            String[] strArr = s.split(" ");
            backTracking(0, strArr, "");
        }

        for (List<Integer> list : map.values()) {
            list.sort((o1, o2) -> o1 - o2);
        }

        int[] answer = new int[query.length];
        int idx = 0;
        for (String q: query) {
            StringTokenizer st = new StringTokenizer(q);

            StringBuilder sb = new StringBuilder();

            for (int i = 0; i < 3; i++) {
                sb.append(st.nextToken());
                st.nextToken();
            }
            sb.append(st.nextToken());

            int score = Integer.parseInt(st.nextToken());

            List<Integer> list = map.get(sb.toString());
            if (list == null) {
                answer[idx++] = 0;
            } else {
                answer[idx++] = list.size() - lowerbound(list, score);
            }
        }

        return answer;
    }

    void backTracking(int depth, String[] strArr, String str) {
        if (depth == 4) {
            map.computeIfAbsent(str, k -> new ArrayList()).add(Integer.parseInt(strArr[4]));
            return;
        }

        backTracking(depth + 1, strArr, str + strArr[depth]);
        backTracking(depth + 1, strArr, str + "-");
    }

    int lowerbound(List<Integer> list, int target) {
        int lo = 0;
        int hi = list.size();

        while (lo < hi) {
            int mid = (lo + hi) / 2;

            if (list.get(mid) >= target) {
                hi = mid;
            } else {
                lo = mid + 1;
            }
        }

        return lo;
    }
}