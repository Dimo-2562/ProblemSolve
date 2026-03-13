package silver.implement;

import java.io.*;
import java.util.*;


/*
랭킹 시스템
내림차순
같으면 동일하게, 그 동일한 등수를
등수 밖이면 -1을 출력

N, 새로운 점수, P
- N: 0 ~ P
- 새로운 점수: 0 ~ 2,000,000,000
- P: 10 ~ 50
점수들
- 내림차순으로 주어짐.

정렬.
등수는 어떻게? bruteforce
ArrayList
 */

public class Problem1205 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int newScore = Integer.parseInt(st.nextToken());
        int p = Integer.parseInt(st.nextToken());

        List<Integer> list = new ArrayList<>();
        if (n > 0) st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            list.add(Integer.parseInt(st.nextToken()));
        }

        if (list.size() >= p && list.get(n-1) >= newScore) {
            System.out.println("-1");
            return;
        }

        list.add(newScore);
        Collections.sort(list, (o1, o2) -> o2 - o1);

        int rank = 0;
        for (int i = 0; i < n+1; i++) {
            rank++;
            if (list.get(i) == newScore) {
                break;
            }
        }
        System.out.print(rank);
    }
}
