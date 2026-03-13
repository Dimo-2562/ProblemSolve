package silver.simulation;

import java.io.*;
import java.util.*;

/*
남 - 스위치 번호가 받은 수의 배수이면 스위치의 상태를 변화
여 - 스위치 번호가 같은 수를 중심으로 좌우가 대칭이며 가장 많은 스위치를 포함하는 구간의 스위치를 모두 바꾼다. (홀수 개)

N
- 스위치 개수 (1 ~ 100)
스위치 상태
- 켜지면 1
- 꺼지면 0
P
- 학생 수
학생의 성별, 받은 수
- P개의 줄에 걸쳐서 입력됨.
- 1은 남, 2는 여

출력: 전체 스위치의 결과를 20개씩 한 줄에 출력

boolean 배열
 */

public class Problem1244 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        boolean[] arr = new boolean[n+1];
        for (int i = 1; i <= n; i++) {
            int num = Integer.parseInt(st.nextToken());
            if (num == 0) arr[i] = false;
            else arr[i] = true;
        }

        int p = Integer.parseInt(br.readLine());
        for (int i = 0; i < p; i++) {
            st = new StringTokenizer(br.readLine());
            int gender = Integer.parseInt(st.nextToken());
            int num = Integer.parseInt(st.nextToken());

            if (gender == 1) { // 남성
                for (int j = 1; j <= n; j++) {
                    if (j % num == 0) {
                        arr[j] = !arr[j];
                    }
                }
            } else { // 여성
                arr[num] = !arr[num];

                int range = 1;
                while (true) {
                    int tmp = num;
                    if(tmp-range < 1 || tmp+range > n || arr[tmp-range] != arr[tmp+range]) {
                        break;
                    }

                    arr[tmp-range] = !arr[tmp-range];
                    arr[tmp+range] = !arr[tmp+range];
                    range++;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            sb.append(arr[i] ? 1 : 0).append(' ');
            if (i % 20 == 0) sb.append('\n');
        }
        System.out.print(sb);
    }
}
