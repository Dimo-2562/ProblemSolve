package later;

import java.io.*;
import java.util.*;

/*
추월?
들어갔을 때 나보다 앞에 있던 차 (즉, 숫자가 작은 차)보다
나올 때 내 순위가 높다면 그건 추월
 */

public class Problem2002Later {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Map<String, Integer> car = new HashMap<>();
        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            car.put(str, i);
        }

        // i번째로 나온 차는 rank[i] 등수로 들어갔었음.
        int[] rank = new int[n];
        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            rank[i] = car.get(str);
        }

        int answer = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (rank[i] > rank[j]) {
                    answer++;
                    break;
                }
            }
        }
        System.out.print(answer);
    }
}