package lv2.greedy;

import java.util.*;

class 조이스틱 {
    public int solution(String name) {
        int n = name.length();

        int answer = 0;
        int move = n - 1;
        for (int i = 0; i < n; i++) {
            char c = name.charAt(i);

            answer += Math.min(c - 'A', 'Z' - c + 1);

            int next = i + 1;
            while (next < n && name.charAt(next) == 'A') {
                next++;
            }

            move = Math.min(move, 2 * i + (n - next));
            move = Math.min(move, i + 2 * (n - next));
        }

        answer += move;

        return answer;
    }
}