package gold.implementation.simulation;

import java.io.*;
import java.util.*;

/*
빗물의 총량을 구하시오.

<입력>
H, W
- H: 세로 길이 (1 ~ 10^2)
- W: 가로 길이 (1 ~ 10^2)
높이 (W개)

<출력>
한 칸의 용량이 1일 때 빗물의 총량을 구하라.
- 전혀 고이지 않을 때는 0을 출력하라.

<풀이>
쌓이는 조건 -> 왼쪽의 높은 것과 오른쪽의 높은 것
그리고 그 중 작은 것의 높이 - 내 높이 = 쌓이는 양
 */

public class Problem14719 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int h = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());
        int[] height = new int[w];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < w; i++) {
            height[i] = Integer.parseInt(st.nextToken());
        }

        int[] leftMax = new int[w];
        leftMax[0] = height[0];
        int[] rightMax = new int[w];
        rightMax[w - 1] = height[w - 1];

        for (int i = 1; i < w; i++) {
            leftMax[i] = Math.max(leftMax[i - 1], height[i]);
        }
        for (int i = w - 2; i >= 0; i--) {
            rightMax[i] = Math.max(rightMax[i + 1], height[i]);
        }

        int sum = 0;
        for (int i = 1; i <= w - 2; i++) {
            int max = Math.min(leftMax[i], rightMax[i]);
            if (max > height[i]) sum += max - height[i];
        }

        System.out.print(sum);
    }
}
