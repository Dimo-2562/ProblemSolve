package silver.binarysearch;

import java.io.*;
import java.util.*;

/*
<입력>
N, M
- N: 칭호의 개수 (1 ~ 10^5)
- M: 캐릭터들의 개수 (1 ~ 10^5)
이름, 정수 (N개의 줄)
- 이름: 1 ~ 11의 길이를 가지고 영어 대문자로만 구성
- 정수: 0 ~ 10^9
- 칭호는 비내림차순으로 주어짐. (-> 방향)
캐릭터 전투력 (M개의 줄)
- 항상 해당하는 칭호가 존재함.

<출력>
전투력에 맞는 칭호.
단, 칭호가 여러 개 가능할경우 가장 먼저 입력된 칭호만 가능하다.

N^2 풀이는 시간 초과.
NlogN...
lowerbound? upperbound를 쓰면 해결되는데..
 */

public class Problem19637 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] namePower = new int[n];
        String[] name = new String[n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            name[i] = st.nextToken();
            namePower[i] = Integer.parseInt(st.nextToken());
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m; i++) {
            int num = Integer.parseInt(br.readLine());
            int idx = lowerbound(num, namePower);
            sb.append(name[idx]).append('\n');
        }

        System.out.println(sb);
    }

    static int lowerbound(int num, int[] p) {
        int left = 0;
        int right = p.length - 1;
        int answer = 0;

        while (left <= right) {
            int mid = (left + right) / 2;

            if (p[mid] >= num) { // upperbound면 등호가 빠짐
                answer = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return answer;
    }
}
