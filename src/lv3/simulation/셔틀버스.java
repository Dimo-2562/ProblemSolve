package lv3.simulation;

import java.util.*;

/*
셔틀버스
09:00부터 총 n회 t분 간격으로 역에 도착
최대 m명 탑승 가능

대기열에 서는 이벤트 -> 태우는 이벤트

셔틀을 타고 사무실로 갈 수 있는 도착 시간 중 제일 늦은 시간을 구하라.

콘은 같은 시각에 도착한 크루 중 제일 뒤에 선다
23:59에 집에 들어간다
어떤 크루도 다음날 셔틀을 타는 일은 없다.

<입력>
n
- n: 셔틀 운행 횟수 (1 ~ 10)
t
- t: 셔틀 운행 간격 (1 ~ 60) (분)
m
- m: 한 셔틀에 탈 수 있는 최대 크루 (1 ~ 45)
timetable
- timetable: 대기열에 도착하는 시각을 모은 배열 (1 ~ 10^3)
- HH:MM 형식으로 이루어져 있다.
- 00:01 ~ 23:59 사이이다.

<출력>
사무실로 갈 수 있는 제일 늦은 시각을 출력하라.

<풀이>
0. timetable을 int[]로 변경.
1. timeList를 시간 -> 분 순서로 오름차순 정렬
2. n과 t를 기반으로 버스가 오는 시각 생성
3. 버스가 올때마다 사람 태우기.
4. 마지막 버스에서 m번째 사람보다 1분 빠르게 하기.

09:00에 5명
09:00에 2명, 09:10에 2명

*/

class 셔틀버스 {
    public String solution(int n, int t, int m, String[] timetable) {
        List<int[]> timeList = new ArrayList<>();
        for (String s : timetable) {
            String h = s.substring(0, 2);
            String minute = s.substring(3, 5);
            timeList.add(new int[]{Integer.parseInt(h), Integer.parseInt(minute)});
        }

        // 1. timeList 정렬
        timeList.sort((o1, o2) -> {
            if (o1[0] != o2[0]) return o1[0] - o2[0];
            return o1[1] - o2[1];
        });

        // 2. n과 t를 기반으로 버스 오는 시각 생성
        List<int[]> busList = new ArrayList<>();
        int busH = 9;
        int busM = 0;
        for (int i = 0; i < n; i++) {
            int sum = t * i;

            int plusH = sum / 60;
            int plusM = sum % 60;

            busList.add(new int[]{busH + plusH, busM + plusM});
        }

        // 3. 버스가 올때마다 사람 태우기.
        int idx = 0;
        int[] answer = new int[2];
        for (int i = 0; i < n; i++) {
            int[] busTime = busList.get(i);

            int busHour = busTime[0];
            int busMinute = busTime[1];

            // 버스 탑승
            int cnt = 0;
            while (cnt < m && idx < timeList.size() &&
                   (timeList.get(idx)[0] < busHour || ((timeList.get(idx)[0] == busHour) && (timeList.get(idx)[1] <= busMinute)))) {
                cnt++;
                idx++;
            }

            // 4. 막차에 사람이 남을경우
            if (i == n - 1 && cnt < m) {
                answer[0] = busHour;
                answer[1] = busMinute;
            }  else if (i == n - 1 && cnt == m) {
                int lastIdx = idx - 1;
                int lastH = timeList.get(lastIdx)[0];
                int lastM = timeList.get(lastIdx)[1];

                if (lastM == 0) {
                    answer[0] = lastH - 1;
                    answer[1] = 59;
                } else {
                    answer[0] = lastH;
                    answer[1] = lastM - 1;
                }
            }
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < 2; i++) {
            if (answer[i] < 10) {
                sb.append('0').append(answer[i]);
            } else {
                sb.append(answer[i]);
            }

            if (i == 0) sb.append(':');
        }

        return sb.toString();
    }
}