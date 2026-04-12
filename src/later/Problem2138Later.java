package later;

import java.io.*;

/*
N개의 스위치, N개의 전구
각각의 전구는 켜짐 or 꺼짐
i번 스위치를 누르면 i-1, i, i+1 세 개의 전구 상태가 바뀜.

N개의 전구들과 우리가 만들고자 하는 상태가 주어질 때 그 상태를 만들기 위해 최소 몇 번 눌러야 하는가?

<입력>
N
- N: 스위치 및 전구의 개수 (2 ~ 10^5)
전구들의 상태
목표 상태

<출력>
최소 눌러야 하는 횟수
- 불가능한 경우 -1

<풀이>
0이려면 짝수번 영향 받기.
1이려면 홀수번 영향 받기.

그리디? -> i-1번째 칸을 i번째에서 최종 결정하기.
 */

public class Problem2138Later {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        String input = br.readLine();
        String goal = br.readLine();

        boolean[] inputArr = new boolean[n + 1];
        boolean[] goalArr = new boolean[n + 1];

        for (int i = 0; i < n; i++) {
            inputArr[i] = input.charAt(i) == '1';
            goalArr[i] = goal.charAt(i) == '1';
        }

        int myMin = Integer.MAX_VALUE;
        int cnt = 1;
        for (int i = 0; i <= 1; i++) inputArr[i] = !inputArr[i];

        for (int i = 1; i < n; i++) {
            if (inputArr[i - 1] != goalArr[i - 1]) {
                cnt++;
                inputArr[i - 1] = !inputArr[i - 1];
                inputArr[i] = !inputArr[i];
                inputArr[i + 1] = !inputArr[i + 1];
            }
        }

        boolean isSame = true;
        for (int i = 0; i < n; i++) {
            if (inputArr[i] != goalArr[i]) isSame = false;
        }
        if (isSame) myMin = Math.min(myMin, cnt);


        for (int i = 0; i < n; i++) {
            inputArr[i] = input.charAt(i) == '1' ? true : false;
        }
        cnt = 0;

        for (int i = 1; i < n; i++) {
            if (inputArr[i - 1] != goalArr[i - 1]) {
                cnt++;
                inputArr[i - 1] = !inputArr[i - 1];
                inputArr[i] = !inputArr[i];
                inputArr[i + 1] = !inputArr[i + 1];
            }
        }

        isSame = true;
        for (int i = 0; i < n; i++) {
            if (inputArr[i] != goalArr[i]) isSame = false;
        }
        if (isSame) myMin = Math.min(myMin, cnt);

        if (myMin == Integer.MAX_VALUE) System.out.println("-1");
        else System.out.println(myMin);
    }
}
