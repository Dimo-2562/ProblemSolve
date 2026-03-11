package silver.implement;

import java.io.*;

public class Problem20125 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        char[][] map = new char[n+1][n+1];
        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            for (int j = 0; j < n; j++) {
                map[i][j] = str.charAt(j);
            }
        }

        // 머리부터 찾기
        boolean isFound = false;
        int y = 0, x = 0;
        for (int i = 0; i < n; i++) {
            if (isFound) break;
            for (int j = 0; j < n; j++) {
                if(map[i][j] == '*') {
                    isFound = true;
                    y = i;
                    x = j;
                    break;
                }
            }
        }

        int left = 0, right = 0, waist = 0, leftLeg = 0, rightLeg = 0;
        int waistY = 0;

        // 왼쪽 팔
        for (int i = 0; i < x; i++) {
            if (map[y+1][i] == '*') left++;
        }
        // 오른쪽 팔
        for (int i = x+1; i < n; i++) {
            if (map[y+1][i] == '*') right++;
        }
        // 허리
        for (int i = y+2; i < n; i++) {
            if (map[i][x] == '*') {
                waist++;
                waistY = i;
            }
        }
        for (int i = waistY + 1; i < n; i++) {
            if (map[i][x-1] == '*') leftLeg++;
        }
        for (int i = waistY + 1; i < n; i++) {
            if (map[i][x+1] == '*') rightLeg++;
        }

        StringBuilder sb = new StringBuilder();
        sb.append(y+2).append(' ').append(x+1).append('\n');
        sb.append(left).append(' ').append(right).append(' ').append(waist).append(' ')
                .append(leftLeg).append(' ').append(rightLeg);
        System.out.print(sb);
    }
}
