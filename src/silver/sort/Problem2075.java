package silver.sort;

import java.io.*;
import java.util.*;

/*
메모리 제한이 빡빡함.

N * N 표
모든 수는 자신의 한 칸 위에 있는 수보다는 큼.
N번째 큰 수를 찾아라.

<입력>
N
- N: 한 변의 길이 (1 ~ 10^3)
N개의 수 (N개의 줄)
- -10억 ~ 10억 (int 범위)

<출력>
N번째 큰수를 출력.

1500 * 1500 * 4byte -> 배열 하나로 풀기.
N번째 큰 수 -> N*N - N + 1번째 수.
 */

public class Problem2075 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n*n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arr[n * i + j] = Integer.parseInt(st.nextToken());
            }
        }

        Arrays.sort(arr);

        System.out.print(arr[n*n-n]);
    }
}
