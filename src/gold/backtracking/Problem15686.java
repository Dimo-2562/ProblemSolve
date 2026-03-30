package gold.backtracking;

import java.io.*;
import java.util.*;

/*
N*N 도시
각 칸 - 빈 칸 or 치킨집 or 집
- 0: 빈 칸
- 1: 집
- 2: 치킨집

(r,c) -> r행 c열
(1,1)부터 시작

치킨 거리: 집과 가장 가까운 치킨집 사이의 거리
도시의 치킨 거리: 모든 집의 치킨 거리의 합

치킨집의 최대 개수는 M개.
도시의 치킨 거리가 가장 작게 되도록 하라.

<입력>
N, M
- N: 도시의 크기 (2 ~ 50)
- M: 치킨 집의 개수 (1 ~ 13)
도시의 정보 (N개의 줄)
- 0: 빈 칸
- 1: 집
- 2: 치킨집

<출력>
최대 M개의 치킨집만 남겼을 때 도시의 치킨 거리의 최솟값.

2^13 -> 백트래킹 가능.

1. 입력을 통해 집과 치킨집 위치를 List에 넣기.
2. 백트래킹으로 살려둘 치킨집 구하기
3. 집과 치킨집들 사이의 최소 거리 구하기
4. 각 치킨 거리 합친 후 최솟값 구하기.
 */

public class Problem15686 {
    static int min = Integer.MAX_VALUE;
    static int m;
    static List<int[]> house = new ArrayList<>();
    static List<int[]> chicken = new ArrayList<>();
    static boolean[] isSelected = new boolean[13];


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        // 1. 집과 치킨집 위치를 List에 넣음.
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++) {
                int tmp = Integer.parseInt(st.nextToken());
                if (tmp == 1) house.add(new int[]{i, j});
                if (tmp == 2) chicken.add(new int[]{i, j});
            }
        }

        // 2. 백트래킹으로 살려둘 치킨집 구하기
        backTracking(0, 0);

        System.out.print(min);
    }

    static void backTracking(int depth, int next) {
        if (depth == m) {
            int sum = 0;
            for (int[] home: house) {
                int homeMin = Integer.MAX_VALUE;
                for (int i = 0; i < chicken.size(); i++) {
                    if (isSelected[i]) {
                        int leng =  Math.abs(home[0] - chicken.get(i)[0]) + Math.abs(home[1] - chicken.get(i)[1]);
                        homeMin = Math.min(homeMin, leng);
                    }
                }
                sum += homeMin;
            }

            min = Math.min(sum, min);
            return;
        }

        for (int i = next; i < chicken.size(); i++) {
            if (!isSelected[i]) {
                isSelected[i] = true;
                backTracking(depth + 1, i + 1);
                isSelected[i] = false;
            }
        }
    }
}
