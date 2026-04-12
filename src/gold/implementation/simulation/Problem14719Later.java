package gold.implementation.simulation;

import java.io.*;
import java.util.*;

/*
고이는 빗물의 총량

<입력>
H, W
- H: 세로 길이 (1 ~ 10^2)
- W: 가로 길이 (1 ~ 10^2)
높이 (W개)

<출력>
고이는 빗물의 총량을 출력하라.

스택
왼쪽에 높은 게 있고, 작은 것, 그리고 다시 높은 것 -> 물이 고임.

 */

public class Problem14719Later {
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
        for (int i = 1; i < w; i++) {
            leftMax[i] = Math.max(leftMax[i - 1], height[i]);
        }

        int[] rightMax = new int[w];
        rightMax[w - 1] = height[w - 1];
        for (int i = w - 2; i >= 0; i--) {
            rightMax[i] = Math.max(rightMax[i + 1], height[i]);
        }

        int answer = 0;
        for (int i = 0; i < w; i++) {
            answer += Math.min(rightMax[i], leftMax[i]) - height[i];
        }

        System.out.print(answer);
    }
}