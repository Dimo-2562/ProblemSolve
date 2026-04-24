package later;

import java.util.*;

/*
파란색 칸은 현재 선택된 행
명령어
- U X: X칸 위에 있는 행
- D X: X칸 아래에 있는 행
- C: 현재 선택된 행을 삭제하고, 바로 아래 행을 선택, 단 현재 행이 가장 마지막 행이면 제일 윗 행을 선택
- Z: 최근에 삭제된 행을 복구, 단 현재 선택된 행을 바꾸진 않음.

<입력>
n
- n: 처음 표의 행 개수 (5 ~ 10^6)
k
- k: 처음에 선택된 행의 위치 (0 ~ 10^6)
cmd
- cmd: 명령어들이 담긴 문자열 배열 (1 ~ 10^5)

<출력>
삭제되지 않은 행은 O, 삭제된 행은 X로 표시하여 문자혈 형태로 return

<풀이>
boolean isRemoved로
Stack으로 최근 삭제 관리
위치 이동은 pos + X로

문제점: boolean 필드로 관리하면 pos + X로 이동할 수가 없음.
ArrayList.remove -> 시간 초과.
누적합?????

풀이 봄 -> 배열로 LinkedList 구현
X값 합이 10^6이므로 시간복잡도를 곱하지 않음.

*/

class 표편집Later {
    public String solution(int n, int k, String[] cmd) {
        int[] prev = new int[n];
        int[] next = new int[n];

        prev[0] = -1;
        for (int i = 1; i < n; i++) {
            prev[i] = i - 1;
        }
        next[n-1] = -1;
        for (int i = 0; i < n - 1; i++) {
            next[i] = i + 1;
        }

        boolean[] isRemoved = new boolean[n];
        Deque <Integer> dq = new ArrayDeque<>();

        int pos = k;
        for (String str : cmd) {
            char c = str.charAt(0);

            if (c == 'U') {
                int x = Integer.parseInt(str.substring(2));
                while (x-- > 0) {
                    pos = prev[pos];
                }
            } else if (c == 'D') {
                int x = Integer.parseInt(str.substring(2));
                while (x-- > 0) {
                    pos = next[pos];
                }
            } else if (c == 'C') {
                isRemoved[pos] = true;
                dq.addLast(pos);

                int pr = prev[pos];
                int ne = next[pos];

                if (ne != -1) prev[ne] = pr;
                if (pr != -1) next[pr] = ne;

                if (next[pos] == -1) {
                    pos = pr;
                } else {
                    pos = ne;
                }
            } else {
                int last = dq.pollLast();
                isRemoved[last] = false;

                int pr = prev[last];
                int ne = next[last];

                if (pr != -1) next[pr] = last;
                if (ne != -1) prev[ne] = last;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(isRemoved[i] ? 'X' : 'O');
        }

        return sb.toString();
    }
}