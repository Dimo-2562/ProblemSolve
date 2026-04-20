package gold.greedy;

import java.io.*;

/*
N개의 스위치와 N개의 전구
i번 스위치를 누르면 i-1, i, i+1의 세 개의 전구 상태가 바뀐다.

N개의 전구들의 상태와 우리가 목표로 하는 상태가 주어졌을 때,
그 상태를 만들기 위해 스위치를 최소 몇 번 누르면 되는지 알아내라.

<입력>
N
- N: 전구 및 스위치의 개수 (2 ~ 10^5)
전구 상태
목표 상태
- 0이 켜진 상태
- 1은 꺼진 상태

<출력>
스위치를 최소 몇 번 누르면 되는지
- 불가능할 경우 -1을 출력.

<풀이>
왼쪽부터 차례대로
n-1번 전구를 결정하는 것 -> n번 스위치.
 */

public class Problem2138 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        String input = br.readLine();
        String goal = br.readLine();

        boolean[] inputArr = new boolean[n + 1];
        boolean[] goalArr = new boolean[n + 1];
        for (int i = 0; i < n; i++) {
            inputArr[i] = input.charAt(i) == '0' ? false : true;
            goalArr[i] = goal.charAt(i) == '0' ? false : true;
        }

        int answer = Integer.MAX_VALUE;
        int cnt = 0;

        // 눌렀을 때
        cnt++;
        inputArr[0] = !inputArr[0];
        inputArr[1] = !inputArr[1];
        for (int i = 1; i < n; i++) {
            if (inputArr[i - 1] != goalArr[i - 1]) {
                inputArr[i - 1] = !inputArr[i - 1];
                inputArr[i] = !inputArr[i];
                inputArr[i + 1] = !inputArr[i + 1];
                cnt++;
            }
        }

        if (inputArr[n - 1] == goalArr[n - 1]) answer = Math.min(cnt, answer);

        // 안 눌렀을 때
        for (int i = 0; i < n; i++) {
            inputArr[i] = input.charAt(i) == '0' ? false : true;
        }
        cnt = 0;

        for (int i = 1; i < n; i++) {
            if (inputArr[i - 1] != goalArr[i - 1]) {
                inputArr[i - 1] = !inputArr[i - 1];
                inputArr[i] = !inputArr[i];
                inputArr[i + 1] = !inputArr[i + 1];
                cnt++;
            }
        }

        if (inputArr[n - 1] == goalArr[n - 1]) answer = Math.min(cnt, answer);

        System.out.print(answer == Integer.MAX_VALUE ? "-1" : answer);
    }
}
