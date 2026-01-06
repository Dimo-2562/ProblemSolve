package bronze.math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem1546 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());

        double[] score = new double[n+1];
        double max = Double.parseDouble(st.nextToken());
        score[0] = max;

        // 최댓값 구하기
        for (int i = 1; i < n; i++) {
            score[i] = Double.parseDouble(st.nextToken());
            max = Math.max(max, score[i]);
        }

        // 점수 변경 및 합 구하기
        double sum = 0;
        for (int i = 0; i < n; i++) {
            score[i] = score[i]/max * 100;
            sum += score[i];
        }

        // 평균 구하기
        System.out.println(sum/n);
    }
}
