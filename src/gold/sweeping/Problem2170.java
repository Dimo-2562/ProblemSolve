package gold.sweeping;

import java.io.*;
import java.util.*;

/*
그려진 선들의 총 길이를 구라하.

<입력>
N
- N: 선을 그은 횟수 (1 ~ 10^6)
x, y
- x, y (10^9) -> int범위.

<출력>
그은 선의 총 길이를 출력하라.

boolean 배열로 브루트포스 -> 10^6 * 10^9 -> 시간초과.

정렬 -> 합치기.
각 입력의 처음과 기존 것들의 맨 끝만 비교.
 */

public class Problem2170 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        List<int[]> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list.add(new int[] {a, b});
        }

        list.sort((o1, o2) -> Integer.compare(o1[0], o2[0]));

        List<int[]> lines = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int[] line = list.get(i);

            if (lines.isEmpty()) {
                lines.add(new int[] {line[0], line[1]});
                continue;
            }

            int[] last = lines.get(lines.size()-1);
            if (line[0] <= last[1]) {
                last[1] = Math.max(last[1], line[1]);
            } else {
                lines.add(line);
            }
        }

        int sum = 0;
        for (int[] line : lines) {
            sum += line[1] - line[0];
        }

        System.out.print(sum);
    }
}
