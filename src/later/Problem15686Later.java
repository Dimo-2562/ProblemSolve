package later;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Problem15686Later {
    static int n, m;
    static List<int[]> house = new ArrayList<>();
    static List<int[]> chicken = new ArrayList<>();
    static int answer = Integer.MAX_VALUE;

    // 각 경우의 수 전부 고려해보기 -> 백트래킹
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++) {
                int tmp = Integer.parseInt(st.nextToken());
                if (tmp == 1) house.add(new int[]{i, j});
                else if (tmp == 2) chicken.add(new int[]{i, j});
            }
        }

        // 백트래킹으로 각 경우에서 맵 상태 반영
        dfs(0, 0, new int[m]);

        System.out.print(answer);
    }

    public static void dfs(int start, int depth, int[] selected) {
        if (depth == m) {
            // 각 집에서 가장 가까운 치킨집 찾기
            int total = 0;
            for (int[] house : house) {
                int shortest = Integer.MAX_VALUE;
                for (int idx : selected) {
                    int dist = Math.abs(house[0] - chicken.get(idx)[0])
                            + Math.abs(house[1] - chicken.get(idx)[1]);
                    shortest = Math.min(shortest, dist);
                }

                total += shortest;
            }

            answer = Math.min(answer, total);
            return;
        }

        for (int i = start; i < chicken.size(); i++) {
            selected[depth] = i;
            dfs(i + 1, depth + 1, selected);
        }
    }
}
