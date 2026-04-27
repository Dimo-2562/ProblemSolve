package lv3.simulation;

import java.util.*;

/*
2차원 가상 벽면 n * n

기둥은 바닥 or 보의 한쪽 끝 or 다른 기둥 위
보는 한쪽 끝 부분이 기둥 위 or 양쪽 끝 부분이 다른 보와 동시에 연결

삭제하는 기능도 삭제 후에 남은 것들이 규칙을 만족해야 함.
조건에 맞지 않는다면 작업은 무시

<입력>
n
- n : 벽면의 크기 (5 ~ 10^2)
build_frame
- build_frame :  기둥과 보를 설치하거나 삭제하는 작업 (1 ~ 10^3)
- [x, y, a, b]
- x, y: 좌표
- a: 종류 (0은 기둥, 1은 보)
- b: 행동의 종류 (0은 삭제, 1은 설치)
- 잘못된 입력은 없다.

- 좌표 기준 보는 오른쪽, 기둥은 위쪽 방향
- 겹치도록 설치하는 경우 + 없는 구조물을 삭제하는 경우는 주어지지 않는다.

<출력>
2차원 배열
[x, y, a]
x좌표 기준 오름차순 정렬,
같다면 y좌표 기준 오름차순 정렬
이것도 같다면 기둥이 먼저

<풀이>
그냥 시뮬레이션으로 구현.
마지막에 정렬
*/

class 기둥과보설치 {
    boolean[][][] map;

    public int[][] solution(int n, int[][] build_frame) {
        map = new boolean[n + 2][n + 2][2];

        for (int[] action : build_frame) {
            int x = action[0];
            int y = action[1];
            int type = action[2];
            int act = action[3];

            if (act == 0) {
                // 삭제
                if (type == 0) {
                    // 기둥
                    map[y][x][0] = false;
                    boolean isOk = true;
                    for (int i = 0; i <= n; i++) {
                        for (int j = 0; j <= n; j++) {
                            if (map[i][j][0] && !isTowerBuildPossible(j, i)) {
                                isOk = false;
                            }
                            if (map[i][j][1] && !isBoBuildPossible(j, i)) {
                                isOk = false;
                            }
                        }
                    }
                    if (!isOk) map[y][x][0] = true;
                } else {
                    // 보
                    map[y][x][1] = false;
                    boolean isOk = true;
                    for (int i = 0; i <= n; i++) {
                        for (int j = 0; j <= n; j++) {
                            if (map[i][j][0] && !isTowerBuildPossible(j, i)) isOk = false;
                            if (map[i][j][1] && !isBoBuildPossible(j, i)) isOk = false;
                        }
                    }
                    if (!isOk) map[y][x][1] = true;
                }

            } else {
                // 설치
                if (type == 0) {
                    // 기둥
                    if (isTowerBuildPossible(x, y)) {
                        map[y][x][0] = true;
                    }
                } else {
                    // 보
                    if (isBoBuildPossible(x, y)) {
                        map[y][x][1] = true;
                    }
                }

            }

        }

        // 결과를 정렬
        List<int[]> result = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= n; j++) {
                for (int k = 0; k < 2; k++) {
                    if (map[i][j][k]) result.add(new int[]{j, i, k});
                }
            }
        }
        result.sort((o1, o2) -> {
            if (o1[0] != o2[0]) return o1[0] - o2[0];
            if (o1[1] != o2[1]) return o1[1] - o2[1];
            return o1[2] - o2[2];
        });

        int[][] answer = new int[result.size()][3];
        for (int i = 0; i < result.size(); i++) {
            answer[i] = result.get(i);
        }

        return answer;
    }

    boolean isTowerBuildPossible(int x, int y) {
        if (y == 0) return true;
        if (map[y][x][1] || (x > 0 && map[y][x - 1][1])) return true;
        if (y > 0 && map[y - 1][x][0]) return true;
        return false;
    }

    boolean isBoBuildPossible(int x, int y) {
        if (y > 0 && (map[y - 1][x][0] || map[y - 1][x + 1][0])) return true;
        if (x > 0 && map[y][x - 1][1] && map[y][x + 1][1]) return true;
        return false;
    }
}