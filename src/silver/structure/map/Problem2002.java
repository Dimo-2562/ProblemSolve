package silver.structure.map;

import java.io.*;
import java.util.*;

/*
들어가는 차량 순서와 나오는 차량 순서가 주어짐.

N개의 차량이 지나간 후 반드시 추월한 차의 대수를 세자.

<입력>
N
- N: 차의 대수 (1 ~ 10^3)
들어간 순서대로 차량 번호 목록 (N개)
나온 순서대로 차량번호 목록 (N개)

<출력>
반드시 추월을 했을 것으로 여겨지는 차가 몇 대인가?

추월? => 자신이 들어갔던 순서에서 앞에 있는 차보다 먼저 나왔다 (즉, 상대적)
카운트는 X.
Map <String, Integer> -> 번호랑 순서
 */

public class Problem2002 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        Map<String, Integer> in = new HashMap<>();
        for (int i = 1; i <= n; i++) {
            String car = br.readLine();
            in.put(car, i);
        }

        String[] arr = new String[n+1];
        for (int i = 1; i <= n; i++) {
            arr[i] = br.readLine();
        }

        int cnt = 0;
        for (int i = 1; i <= n; i++) {
            String car = arr[i];

            int prev = in.get(car);
            for (int j = i + 1; j <= n; j++) {
                String otherCar = arr[j];

                int otherPrev = in.get(otherCar);
                if (prev > otherPrev) {
                    cnt++;
                    break;
                }
            }
        }

        System.out.print(cnt);
    }
}
