package gold.dp;

import java.io.*;
import java.util.*;

public class Problem2096 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[][] maxArr = new int[2][3];
        int[][] minArr = new int[2][3];

        StringTokenizer st = new StringTokenizer(br.readLine());
        int first = Integer.parseInt(st.nextToken());
        int second = Integer.parseInt(st.nextToken());
        int third = Integer.parseInt(st.nextToken());
        maxArr[0][0] = minArr[0][0] = first;
        maxArr[0][1] = minArr[0][1] = second;
        maxArr[0][2] = minArr[0][2] = third;

        for (int i = 1; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            first = Integer.parseInt(st.nextToken());
            second = Integer.parseInt(st.nextToken());
            third = Integer.parseInt(st.nextToken());

            maxArr[1][0] = Math.max(maxArr[0][0], maxArr[0][1]) + first;
            maxArr[1][1] = Math.max(Math.max(maxArr[0][1], maxArr[0][2]), maxArr[0][0]) + second;
            maxArr[1][2] = Math.max(maxArr[0][1], maxArr[0][2]) + third;

            minArr[1][0] = Math.min(minArr[0][0], minArr[0][1]) + first;
            minArr[1][1] = Math.min(Math.min(minArr[0][1], minArr[0][2]), minArr[0][0]) + second;
            minArr[1][2] = Math.min(minArr[0][1], minArr[0][2]) + third;

            for (int j = 0; j < 3; j++) {
                maxArr[0][j] = maxArr[1][j];
                minArr[0][j] = minArr[1][j];
            }
        }

        int myMax = Integer.MIN_VALUE;
        int myMin = Integer.MAX_VALUE;
        for (int j = 0; j < 3; j++) {
            myMax = Math.max(myMax, maxArr[0][j]);
            myMin = Math.min(myMin, minArr[0][j]);
        }

        System.out.print(myMax + " " + myMin);

    }
}
