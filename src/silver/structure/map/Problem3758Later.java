package silver.structure.map;

import java.io.*;
import java.util.*;

/*
k개 문제를 풀 때 한 문제는 0 ~ 100점 사이 점수
ID, 문제 번호, 시간이 순서대로 저장.
여러 번 문제를 풀면 최고 점수가 저장됨.
기본값은 0

최종 점수: 각 문제에 대해 받은 점수의 총합

순위: 나보다 높은 점수인 팀의 수 + 1
동일 점수일 때
- 풀이를 제출한 횟수가 적은 경우
- 풀이를 제출한 횟수까지 같으면 마지막 제출 시간이 더 빠른경우

<입력>
T
- T: 테스트 데이터의 수
n, k, t, m
- n: 팀의 개수 (3 ~ 10^2)
- k: 문제의 개수 (3 ~ 10^2)
- t: 당신 팀의 ID (3 ~ 10^2)
- m: 로그 엔트리의 개수 (3 ~ 10^4)
로그들 (i, j, s)
- i: 팀 ID (1 ~ 10^2)
- j: 문제 번호 (1 ~ 10^2)
- s: 획득한 점수 (0 ~ 10^2)

<출력>
당신 팀의 순위를 한 줄에 출력.

Map <팀, 팀의 정보>
-> 팀의 정보
- 각 문제별 최고점
- 제출한 풀이의 수
- 마지막 문제 풀이 순서

정렬 (총점 높은순, 풀이 제출 횟수가 낮은 순, 마지막 문제 풀이 순서가 낮은 순)
 */

public class Problem3758Later {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        while (t-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int teamNum = Integer.parseInt(st.nextToken());
            int problemNum = Integer.parseInt(st.nextToken());
            int myTeamNum = Integer.parseInt(st.nextToken());
            int logNum = Integer.parseInt(st.nextToken());

            Map <Integer, Team> map = new HashMap<>();

            for (int i = 0; i < logNum; i++) {
                st = new StringTokenizer(br.readLine());
                int teamId = Integer.parseInt(st.nextToken());
                int problemId = Integer.parseInt(st.nextToken());
                int score = Integer.parseInt(st.nextToken());
                Team team = map.computeIfAbsent(teamId, key -> new Team(problemNum));
                team.maxScore[problemId] = Math.max(team.maxScore[problemId], score);
                team.submitCnt++;
                team.lastTime = i;
            }

            List<Team> teams = new ArrayList<>(map.values());
            teams.sort((o1, o2) -> {
               if (o1.sum() != o2.sum()) return o2.sum() - o1.sum();
               if (o1.submitCnt != o2.submitCnt) return o1.submitCnt - o2.submitCnt;
               return o1.lastTime - o2.lastTime;
            });

            Team myTeam = map.get(myTeamNum);
            int rank = 1;
            for (Team team : teams){
                if (team == myTeam) {
                    sb.append(rank).append('\n');
                    break;
                }
                rank++;
            }
        }

        System.out.println(sb);
    }


    /*
    Map <팀, 문제 정보>
    -> 문제 정보
    - 각 문제별 최고점
    - 제출한 풀이의 수
    - 마지막 문제 풀이 순서
     */
    static class Team {
        int[] maxScore;
        int submitCnt = 0;
        int lastTime = 0;

        int rank;

        public Team(int problemNum) {
            this.maxScore = new int[problemNum+1];
        }

        public int sum() {
            int sum = 0;
            for (int i = 0; i < maxScore.length; i++) {
                sum += maxScore[i];
            }
            return sum;
        }
    }
}
