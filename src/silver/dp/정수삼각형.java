package silver.dp;

/*
꼭대기에서 바닥까지 이어지는 경로
숫자의 합이 가장 큰 경우

이동:
대각선 오른쪽 or 왼쪽

<입력>
삼각형의 정보가 담긴 배열
- 높이: (1 ~ 10^2)
- 숫자: (0 ~ 10^4)

<출력>
거쳐간 숫자의 최댓값

<풀이>
DP
7
3 8
8 1 0
2 7 4 4
4 5 2 6 5  [4][4]

*/

class 정수삼각형 {
    public int solution(int[][] triangle) {
        int[][] dp = new int[501][501];

        dp[0][0] = triangle[0][0];
        int h = triangle.length;
        for (int i = 1; i < h; i++) {
            dp[i][0] = dp[i-1][0] + triangle[i][0];
            dp[i][i] = dp[i-1][i-1] + triangle[i][i];
        }

        for (int i = 2; i < h; i++) {
            for (int j = 1; j < i; j++) {
                dp[i][j] = Math.max(dp[i-1][j-1], dp[i-1][j]) + triangle[i][j];
            }
        }

        int answer = 0;
        for (int i = 0; i < h; i++) {
            answer = Math.max(answer, dp[h-1][i]);
        }

        return answer;
    }
}