package lv3.dfs.backtracking;

import java.util.*;

/*
비정상적인 사용자 -> 불량 사용자
아이디 중 일부 문자를 *문자로 가림.
최소 하나 이상의 *문자를 사용.

불량 사용자 아이디 목록을 가지고 제재 아이디 목록의 경우의 수를 구하라.

<입력>
String[] user_id, String[] banned_id
- user_id: 이벤트 응모자 아이디 목록
-- 크기 (1 ~ 8)
-- 각 원소의 길이 (1 ~ 8)
-- 중복 X.
-- 알파벳 소문자와 숫자로만 구성.
- banned_id: 불량 사용자 아이디 목록
-- 크기 (1 ~ 8)
-- 각 원소의 길이 (1 ~ 8)
-- * 문자를 하나 이상 포함
-- 같은 응모자 아이디가 들어가는 경우는 없음.

<출력>
제재 아이디 목록의 경우의 수를 구하라.

<풀이>
N = 10
banned_id 1개당 user_id N개를 돌고, N개의 길이를 체크
- 1. 길이 체크
- 2. 알파벳 체크
각 단어가 만족하는 쌍을 들고 있어야 함.
*/

class 불량사용자Later {
    static boolean[] used = new boolean[8];
    static List<String> picked = new ArrayList<>();
    static Set<String> result = new HashSet<>();

    public int solution(String[] user_id, String[] banned_id) {
        dfs(0, user_id, banned_id);

        int answer = result.size();
        return answer;
    }

    void dfs(int depth, String[] user_id, String[] banned_id) {
        if (depth == banned_id.length) {

            List<String> tmp = new ArrayList<>(picked);
            tmp.sort((o1, o2) -> o1.compareTo(o2));

            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < tmp.size(); i++) {
                sb.append(tmp.get(i)).append(' ');
            }
            result.add(sb.toString());

            return;
        }

        for (int i = 0; i < user_id.length; i++) {
            if (used[i]) continue;
            if (!matches(user_id[i], banned_id[depth])) continue;

            picked.add(user_id[i]);
            used[i] = true;

            dfs(depth + 1, user_id, banned_id);

            picked.remove(picked.size() - 1);
            used[i] = false;
        }

    }

    boolean matches(String user, String banned) {
        if (user.length() != banned.length()) return false;

        for (int i = 0; i < banned.length(); i++) {
            if (banned.charAt(i) == '*') continue;
            if (banned.charAt(i) != user.charAt(i)) return false;
        }

        return true;
    }
}