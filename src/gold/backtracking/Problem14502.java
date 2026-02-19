package gold.backtracking;

import java.util.*;
import java.io.*;

/*
벽을 3개 세울 수 있음.

0은 빈 칸, 1은 벽, 2는 바이러스
연구소의 지도가 주어졌을 때 얻을 수 있는 안전 영역의 최댓값

입력
N, M
- N: 세로 크기 (3 ~ 8)
- M: 가로 크기 (3 ~ 8)
지도 모양 (공백으로 구분)

풀이: 조합 -> 62C3 (백트래킹) 최댓값 구하기.
 */

public class Problem14502 {

    static int n, m;
    static int[][] map;
    static boolean[][] mapVisited;
    static int[] dy = {1, -1, 0, 0};
    static int[] dx = {0, 0, 1, -1};

    static int max;

    static List<int[]> blank = new ArrayList<>();
    static boolean[] visited;
    static int[] selected = new int[3];


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 0) {
                    blank.add(new int[]{i, j});
                }
            }
        }
        visited = new boolean[blank.size()];

        backTracking(0, 0);

        System.out.println(max);
    }

    static void backTracking(int depth, int start) {
        if (depth == 3) {
            int[][] copyMap = copyMapAndBuildWall();
            mapVisited = new boolean[n][m];

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (copyMap[i][j] == 2 && !mapVisited[i][j]) {
                        mapVisited[i][j] = true;
                        dfs(i, j, copyMap);
                    }
                }
            }

            int cnt = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (copyMap[i][j] == 0) cnt++;
                }
            }

            max = Math.max(cnt, max);
            return;

        }

        for (int i = start; i < blank.size(); i++) {
            if (!visited[i]){
                visited[i] = true;
                selected[depth] = i;
                backTracking(depth + 1, i + 1);
                visited[i] = false;
            }
        }
    }

    static int[][] copyMapAndBuildWall(){
        int[][] copy = new int[n][m];
        for (int i = 0; i < n; i++){
            for (int j = 0; j < m; j++){
                copy[i][j] = map[i][j];
            }
        }

        for (int i = 0; i < selected.length; i++) {
            int[] wall = blank.get(selected[i]);
            copy[wall[0]][wall[1]] = 1;
        }
        return copy;
    }

    static void dfs(int i, int j, int[][] copyMap) {
        // dfs에 들어온순간 i랑 j는 2인것을 보장.
        for (int k = 0; k < 4; k++){
            int ny = i + dy[k];
            int nx = j + dx[k];
            if (ny >= 0 && ny < n && nx >= 0 && nx < m){
                if (copyMap[ny][nx] == 0){
                    copyMap[ny][nx] = 2;
                    mapVisited[ny][nx] = true;
                    dfs(ny, nx, copyMap);
                }
            }
        }
    }
}
