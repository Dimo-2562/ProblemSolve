package gold.twopointer;

import java.io.*;
import java.util.*;

/*
산성 용액과 알칼리성 용액
정수 = 용액의 특성 (-10^9 ~ 10^9)

혼합한 용액의 특성값 = 혼합에 사용된 용액들의 합.
0에 가까운 용액을 만들고자 함.

0에 가장 가까운 용액을 만들어내는 두 용액을 찾아라.

<입력>
N
- N: 전체 용액의 수 (2 ~ 10^5)
용액의 특성값들
- 각 값 (-10^9 ~ 10^9)
- 용액들의 특성값은 모두 다르다.

<출력>
0에 가장 가까운 용액을 만들어내는 두 용액의 특성값을 출력.
- 특성값의 오름차순
- 두 개 이상일 경우에는 그 중 아무것이나 하나 출력.

<풀이>
정렬
양쪽 끝에서부터 투 포인터.
 */

public class Problem2470 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int answerLeft = 0;
        int answerRight = 0;

        Arrays.sort(arr);

        int left = 0;
        int right = arr.length - 1;
        int absMin = Integer.MAX_VALUE;

        while (left < right) {
            int sum = arr[left] + arr[right];

            if (Math.abs(sum) < absMin) {
                absMin = Math.abs(sum);
                answerLeft = arr[left];
                answerRight = arr[right];
            }

            if (sum == 0) {
                break;
            } else if (sum < 0) {
                left++;
            } else {
                right--;
            }
        }

        System.out.print(answerLeft + " " + answerRight);
    }
}