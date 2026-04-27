package later;

import java.util.*;

/*
전체 재생 구간
검은색 선: 재생한 구간, 각 ID가 존재
빨간색 선: 최적의 공익광고 위치

누적 재생시간이 가장 큰 위치에 배치
가장 많은 곳이 여러 곳이라면, 그 중에서 가장 빠른 시작 시각.

<입력>
play_time
- play_time: 동영상 전체 재생시간 길이 (1 ~ 10^5)
- 양식 (HH:MM:SS)
- 100 * 60 * 60 = 360000
adv_time
- adv_time : 공익광고 재생시간 길이 (1 ~ 10^5)
- 양식 (HH:MM:SS)
logs
- logs: 동영상을 재생했던 구간 정보 (1 ~ 10^5)
- 길이가 17
- H1:M1:S1-H2:M2:S2
잘못된 시간들은 주어지지 않는다.

<출력>
공익 광고를 삽입할 시각을 HH:MM:SS 형식의 문자열로 반환

<풀이>
1. 파싱
- 일단 시간들은 다 초 단위로 변환
- logs는 [시작시각, 종료시각]으로 변환

제일 많이 겹치는 구간에 배치해야 함.

*/

class 광고삽입Later {
    public String solution(String play_time, String adv_time, String[] logs) {
        int playTime = toSec(play_time);
        int advTime = toSec(adv_time);

        // 차 배열
        long[] time = new long[playTime + 1];
        for (String log : logs) {
            int start = toSec(log.substring(0, 8));
            int end = toSec(log.substring(9, 17));

            time[start]++;
            time[end]--;
        }

        // 누적합
        for (int i = 1; i <= playTime; i++) {
            time[i] += time[i - 1];
        }

        // 슬라이딩 윈도우
        long sum = 0;
        for (int i = 0; i < advTime; i++) {
            sum += time[i];
        }

        long max = sum;
        int start = 0;
        for (int i = 1; i <= playTime - advTime; i++) {
            sum -= time[i - 1];
            sum += time[i + advTime - 1];

            if (sum > max) {
                max = sum;
                start = i;
            }
        }

        return toTime(start);
    }

    int toSec(String str) {
        int h = Integer.parseInt(str.substring(0, 2));
        int m = Integer.parseInt(str.substring(3, 5));
        int s = Integer.parseInt(str.substring(6, 8));

        return h * 3600 + m * 60 + s;
    }

    String toTime(int time) {
        int h = time / 3600;
        time %= 3600;

        int m = time / 60;
        int s = time % 60;

        return String.format("%02d:%02d:%02d", h, m, s);
    }
}