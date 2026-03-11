package silver.structure.set;

import java.io.*;
import java.util.*;

/*
Y 1명
F 2명
O 3명

N과 플레이할 게임의 종류
최대 몇 번이나 게임을 할 수 잇는지
한 번 하면 끝.

SET으로 중복 제거
 */

public class Problem25757 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        char c = st.nextToken().charAt(0);

        Set <String> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            set.add(br.readLine());
        }

        int ans = 0;
        if(c == 'Y') {
            ans = set.size() / 1;
        } else if (c == 'F') {
            ans = set.size() / 2;
        } else {
            ans = set.size() / 3;
        }
        System.out.print(ans);
    }
}
