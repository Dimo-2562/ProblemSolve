package silver.structure.set;

import java.io.*;
import java.util.*;

/*
키워드는 중복 X, N개 존재
한 글에 최대 10개의 키워드.

<입력>
N, M
- N: 메모장에 적은 키워드 개수 (1 ~ 10^5)
- M: 쓴 글의 갯 (1 ~ 10^5)
키워드들 (N개의 줄)
글에서 쓴 키워드
- ,로 구분지어서 입력됨.

<출력>
x번째 줄마다 x번째 글을 쓰고 난 후에 남아있는 키워드의 개수.

처음에 set으로 입력받고
글마다 contains 체크 후 remove 그 후 set의 사이즈 출력
HashSet
 */

public class Problem22233 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        Set<String> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            set.add(str);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine(), ",");

            while (st.hasMoreTokens()) {
                String str = st.nextToken();
                if (set.contains(str)) set.remove(str);
            }
            sb.append(set.size()).append('\n');
        }

        System.out.print(sb);
    }
}
