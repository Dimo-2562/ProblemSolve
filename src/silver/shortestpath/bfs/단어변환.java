package silver.shortestpath.bfs;

import java.io.*;
import java.util.*;

/*
한 번에 1개의 알파벳만 바꿀 수 있습니다.
words에 있는 단어로만 변환할 수 있습니다.

최소 몇 단계의 과정을 거쳐 begin을 target으로 변환할 수 있는지 return하라.

<입력>
begin, target, words
- 각 단어는 알파벳 소문자로만 구성
- 각 단어의 길이 (3 ~ 10)
- 모든 단어의 길이는 같다.
- words의 길이 (3 ~ 50)
- begin과 target은 다르다
- 변환할 수 없는 경우에 0을 return

<출력>
최소 몇 단계의 과정을 거쳐 target이 될 수 있는가?
- 없을경우 0을 출력.

<풀이>
words 안에 target이 없으면 0을 바로 return.

각 단어끼리 가중치를 구한뒤에 bfs.
*/

class 단어변환 {
    public int solution(String begin, String target, String[] words) {

        boolean flag = false;
        int answerPos = 0;
        for (int i = 0; i < words.length; i++) {
            if (words[i].equals(target)) {
                flag = true;
                answerPos = i + 1;
                break;
            }
        }
        if (!flag) return 0;

        // 각 단어끼리 가중치 비교.
        List<Integer>[] graph = new ArrayList[words.length + 1];
        for (int i = 0; i <= words.length; i++) {
            graph[i] = new ArrayList<>();
        }

        // begin부터 비교.
        for (int j = 0; j < words.length; j++) {
            int cnt = 0;

            String word = words[j];
            for (int k = 0; k < word.length(); k++) {
                if (begin.charAt(k) != word.charAt(k)) cnt++;
            }

            if (cnt == 1) graph[0].add(j + 1);
        }

        for (int i = 0; i < words.length; i++) {
            for (int j = 0; j < words.length; j++) {
                if (i == j) continue;

                int cnt = 0;
                String cur = words[i];
                String next = words[j];
                for (int k = 0; k < cur.length(); k++) {
                    if (cur.charAt(k) != next.charAt(k)) cnt++;
                }

                if (cnt == 1) {
                    graph[i + 1].add(j + 1);
                    graph[j + 1].add(i + 1);
                }
            }
        }

        Deque <int[]> dq = new ArrayDeque<>();
        boolean[] visited = new boolean[words.length + 1];
        visited[0] = true;
        dq.add(new int[] {0, 0});

        int answer = 0;
        while (!dq.isEmpty()) {
            int[] cur = dq.pollFirst();
            int pos = cur[0];
            int cost = cur[1];

            if (pos == answerPos) {
                answer = cost;
                break;
            }

            for (int num : graph[pos]) {
                if (!visited[num]) {
                    visited[num] = true;
                    dq.addLast(new int[] {num, cost + 1});
                }
            }
        }

        return answer;
    }
}
