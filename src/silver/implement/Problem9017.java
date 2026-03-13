package silver.implement;

import java.io.*;
import java.util.*;

/*
팀은 여섯 명
팀 점수: 상위 네 명
점수는 자격을 갖춘 팀의 주자에게만
결승점을 통과한 순서대로 점수 부여
가장 낮은 점수가 우승
여섯 명의 주자가 없을경우 점수 계산에서 제외
동점의 경우에는 다섯 번재 주자가 빨리 들어온 팀

등수가 주어질 때 우승팀을 구하는 프로그램

T
- 테스트 케이스 개수
N
- N: 주자의 수 (6 ~ 10^3)
팀 번호들
- 팀 번호: (1 ~ 200)

출력
우승팀의 번호

전체 데이터 기록용 int[]
팀 점수 기룍용 int[]
Map<팀, 등수>

점수가 동점일 땐 다섯번째 선수 카운트.
 */

public class Problem9017 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());

            int[] person = new int[n];
            int[] cntArr = new int[201];
            boolean[] valid = new boolean[201];
            Arrays.fill(valid, true);
            for (int i = 0; i < n; i++) {
                person[i] = Integer.parseInt(st.nextToken());
                cntArr[person[i]]++;
            }

            // 6명이 안되면 valid를 false로
            for (int i = 1; i <= 200; i++) {
                if (cntArr[i] != 6) valid[i] = false;

            }

            // 팀마다 점수 입력
            Map<Integer, List<Integer>> teamMap = new HashMap<>();
            int score = 1;
            for (int i = 0; i < n; i++) {
                if (valid[person[i]]) {
                    teamMap.computeIfAbsent(person[i], k -> new ArrayList<>()).add(score++);
                }
            }

            // 최고 팀 구하기
            int bestTeam = -1;
            int bestSum = Integer.MAX_VALUE;
            int bestFifth = Integer.MAX_VALUE;
            for (int i = 1; i <= 200; i++) {
                if (valid[i]) {
                    List<Integer> r = teamMap.get(i);
                    int sum = r.get(0) + r.get(1) + r.get(2) + r.get(3);
                    int fifth = r.get(4);

                    if (sum < bestSum || (sum == bestSum && fifth < bestFifth)) {
                        bestSum = sum;
                        bestTeam = i;
                        bestFifth = fifth;
                    }
                }
            }

            sb.append(bestTeam).append('\n');
        }
        System.out.print(sb);
    }
}
