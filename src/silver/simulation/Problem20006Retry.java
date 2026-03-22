package silver.simulation;

import java.io.*;
import java.util.*;

/*
1. 입장 신청 당시 매칭 가능한 방이 없을경우 새로 방을 생성하고 입장.
- 해당 방은 플레어어 기준 -10 ~ +10까지 입장 가능
2. 입장 가능한 방이 있다면 입장 -> 정원이 찰 때까지 대기
- 가능한 방이 여러개라면 먼저 생성된 방
3. 정원이 모두 차면 시작

<입력>
p, m
- p: 플레이어의 수 (1 ~ 10^2)
- m: 방의 정원 (1 ~ 10^2)
l, n (p개의 줄)
- l: 플레이어의 레벨
- n: 닉네임 (중복 x, 알파벳 소문자, 길이는 16까지)

<출력>
게임의 시작 유무 (Started! or Waiting!)
레벨 + 아이디 (인원수만큼)
- 닉네임을 사전순으로 정렬시켜 출력.

1. 방이 있는지 체크
2. 있으면 입장
3. 없으면 새로 생성

2차원 List
 */

public class Problem20006Retry {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        List<List<Person>> rooms = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            int level = Integer.parseInt(st.nextToken());
            String name = st.nextToken();
            Person p = new Person(level, name);

            //방 순회
            boolean isEntered = false;
            for (List<Person> room : rooms) {
                if (room.size() >= m) continue;
                Person first = room.get(0);
                if (first.level - 10 <= level && level <= first.level + 10) {
                    room.add(p);
                    isEntered = true;
                    break;
                }
            }

            // 들어갈 방이 없으면 자기가 방 만들고 입장.
            if (!isEntered) {
                List<Person> newRoom = new ArrayList<>();
                newRoom.add(p);
                rooms.add(newRoom);
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < rooms.size(); i++) {
            List<Person> list = rooms.get(i);
            if (list.size() == m) {
                sb.append("Started!\n");
            } else {
                sb.append("Waiting!\n");
            }

            list.sort(Comparator.comparing(o -> o.name));
            for (int j = 0; j < list.size(); j++) {
                Person p = list.get(j);
                sb.append(p.level).append(' ').append(p.name).append('\n');
            }
        }

        System.out.print(sb);
    }

    static class Person {
        int level;
        String name;

        public Person(int level, String name) {
            this.level = level;
            this.name = name;
        }
    }
}