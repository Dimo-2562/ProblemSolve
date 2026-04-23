package lv3.dfs.backtracking;

import java.io.*;
import java.util.*;

/*
불량 사용자 -> 처리 시 제외
*문자로 가림.
매핑된 응모자 아이디를 제재 아이디라고 부름.

<입력>
user_id
- user_id: 이벤트 응모자 아이디 목록 (1 ~ 8)
- 각 원소 (1 ~ 8)
- 중복 X.
- 알파벳 소문자와 숫자로 구성
banned_id
- banned_id: 불량 사용자 아이디 목록 (1 ~ 8)
- 알파벳 소문자와 숫자, *로 구성
- *을 반드시 하나 이상 포함
- 같은 응모자 아이디가 중복해서 제재 아이디 목록에 들어가는 경우는 없다.
- 제재 아이디 목록들을 구했을 때 아이디들이 순서 상관없이 내용이 동일하다면 같은 것으로 처리

<출력>
당첨에서 제외되어야 할 제재 아이디 목록의 경우의 수

<풀이>
백트래킹으로 전체 경우의 수
중복 제거 -> 정렬, StringBuilder로 String으로 만든 뒤 Set을 통해 제거.
*/

class 불량사용자 {
    static boolean[] visited;
    static List<String> picked = new ArrayList<>();
    static Set<String> answer = new HashSet<>();

    public int solution(String[] user_id, String[] banned_id) {
        visited = new boolean[user_id.length];

        backTracking(0, user_id, banned_id);

        return answer.size();
    }

    void backTracking(int depth, String[] user_id, String[] banned_id) {
        if (depth == banned_id.length) {

            List<String> tmp = new ArrayList<>(picked);
            tmp.sort((o1, o2) -> o1.compareTo(o2));

            StringBuilder sb = new StringBuilder();
            for (String s : tmp) {
                sb.append(s).append(", ");
            }
            answer.add(sb.toString());

            return;
        }

        for (int i = 0; i < user_id.length; i++) {
            if (visited[i]) continue;
            if (!matches(user_id[i], banned_id[depth])) continue;

            visited[i] = true;
            picked.add(user_id[i]);

            backTracking(depth + 1, user_id, banned_id);

            visited[i] = false;
            picked.remove(picked.size() - 1);
        }
    }

    boolean matches(String user, String banned) {
        if (user.length() != banned.length()) return false;

        char[] bannedArr = banned.toCharArray();
        for (int i = 0; i < banned.length(); i++) {
            if (bannedArr[i] == '*') continue;
            if (bannedArr[i] != user.charAt(i)) return false;
        }

        return true;
    }
}