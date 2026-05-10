package later;

import java.util.*;

/*
과제는 시작하기로 한 시각이 되면 시작

새로운 과제를 시작할 시간이 되면, 기존에 진행 중이던걸 멈추고 새로운 과제 시작
진행중이던 과제를 끝냈을경우, 잠시 멈춘 과제가 있다면, 멈춰둔 과제를 진행
- 만약, 과제를 끝낸 시각에 새로 시작해야 하는 과제와 멈춰둔 과제가 있다면, 새로 시작하는 과제부터 진행
멈춰둔 과제가 여러개면 가장 최근에 멈춘 과제부터 진행

<입력>
plans
- plans: 과제 계획 (3 ~ 10^3)
- [name, start, playtime]
- name: 과제 이름 (2 ~ 10)
-- 알파벳 소문자로만 구성
-- 중복 없음
- start: 과제 시작 시각 (00:00 ~ 23:59)
-- 시작 시각은 달라서 겹칠 일이 없다.
-- 시와 분의 값이 작을수록 더 빨리 시작한 과제
- playtime: 과제를 마치는데 걸리는 시간 (1 ~ 10^2)
-- 0으로 시작하지 않는다.
- 배열은 시간순으로 정렬되어 있지 않을 수 있다.

<출력>
과제를 끝낸 순서대로 이름을 배열에 담아 return

<풀이>
시간 -> 분으로 파싱,
시간순으로 정렬
진행해야 하는 시간을 계속 추적.

진행해야 하는 것 -> Queue
현재 진행중인 것
멈춰둔 것 -> Stack
*/

class 과제진행하기Later {
    public String[] solution(String[][] plans) {
        List<Plan> task = new ArrayList<>();

        for (String[] plan : plans) {
            String name = plan[0];
            int start = toMinute(plan[1]);
            int playTime = Integer.parseInt(plan[2]);

            task.add(new Plan(name, start, playTime));
        }

        task.sort((o1, o2) -> o1.start - o2.start);

        List<String> answerList = new ArrayList<>();
        Deque<Plan> waiting = new ArrayDeque<>();

        for (int i = 0; i < task.size() - 1; i++) {
            Plan cur = task.get(i);
            Plan next = task.get(i + 1);

            int available = next.start - cur.start;

            if (available >= cur.playTime) {
                answerList.add(cur.name);

                int left = available - cur.playTime;
                while (left > 0 && !waiting.isEmpty()) {
                    Plan t = waiting.pollLast();

                    if (left >= t.playTime) {
                        left -= t.playTime;
                        answerList.add(t.name);
                    } else {
                        t.setPlayTime(t.playTime - left);
                        left = 0;
                        waiting.addLast(t);
                    }
                }
            } else {
                cur.setPlayTime(cur.playTime - available);
                waiting.addLast(cur);
            }
        }

        answerList.add(task.get(task.size() - 1).name);

        while (!waiting.isEmpty()) {
            answerList.add(waiting.pollLast().name);
        }

        String[] answer = new String[answerList.size()];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = answerList.get(i);
        }
        return answer;
    }

    int toMinute(String hour) {
        String[] arr = hour.split(":");
        int h = Integer.parseInt(arr[0]) * 60;
        int m = Integer.parseInt(arr[1]);

        return h + m;
    }

    class Plan {
        String name;
        int start;
        int playTime;

        Plan(String name, int start, int playTime) {
            this.name = name;
            this.start = start;
            this.playTime = playTime;
        }

        void setPlayTime(int playTime) {
            this.playTime = playTime;
        }
    }
}