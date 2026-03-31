package silver.structure.map;

import java.io.*;
import java.util.*;

/*
k개의 문제
0~100점 사이 점수

팀의 ID, 문제 번호, 점수가 시간 순서대로 저장.
여러 번 풀이 제출할경우 그 중 최고 점수로 선정.

팀의 최종 점수 = 각 문제에 대해 받은 점수의 총합
순위 = 팀보다 높은 점수를 받은 팀 + 1

점수가 같을경우
1. 풀이를 제출한 횟수가 적은 팀의 순위가 높다.
2. 풀이 제출 횟수도 같은 경우, 마지막 제출 시간이 더 빠른 팀.

당신 팀의 순위를 계산하라.

<입력>
T
- T: 테스트 데이터의 수
n, k, t, m
- n: 팀의 개수 (3 ~ 10^2)
- k: 문제의 개수 (3 ~ 10^2)
- t: 당신 팀의 ID (3 ~ 10^2)
- m: 로그 엔트리의 개수 (3 ~ 10^4)
i, j, s
- i: 팀 ID
- j: 문제 번호
- s: 획득한 점수 (0~10^2)

<출력>
각 테스트 데이터마다 팀의 순위를 출력 (줄바꿈 필요)

팀 class
- 각 문제별 획득 점수
- 풀이 제출 횟수
- 마지막 풀이 제출 번호

Map <팀 번호, 팀 class>
 */

public class Problem3758 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            Map <Integer, Team> teams = new HashMap<>();
            for (int i = 0; i < m; i++) {
                st = new StringTokenizer(br.readLine());
                int teamNum = Integer.parseInt(st.nextToken());
                int proNum = Integer.parseInt(st.nextToken());
                int score = Integer.parseInt(st.nextToken());
                Team team = teams.computeIfAbsent(teamNum, tmp -> new Team(k));
                team.scores[proNum] = Math.max(score, team.scores[proNum]);
                team.cnt++;
                team.lastIdx = i;
            }

            Team mine = teams.get(t);
            int rank = 1;
            for (Team team: teams.values()) {
                if(team.equals(mine)) continue;

                if (isHigher(team, mine)) rank++;
            }
            sb.append(rank).append('\n');
        }

        System.out.print(sb);
    }

    static boolean isHigher (Team team, Team mine) {
        if (team.getScore() != mine.getScore()) return team.getScore() > mine.getScore();
        if (team.cnt != mine.cnt) return mine.cnt > team.cnt;
        return mine.lastIdx > team.lastIdx;
    }

    static class Team {
        int[] scores;
        int cnt;
        int lastIdx;

        public Team (int k) {
            scores = new int[k+1];
            cnt = 0;
            lastIdx = 0;
        }

        public int getScore(){
            int sum = 0;
            for (int num : scores) {
                sum += num;
            }
            return sum;
        }
    }
}
