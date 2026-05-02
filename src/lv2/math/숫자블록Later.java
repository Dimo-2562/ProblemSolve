package lv2.math;

/*
0이 적힌 블록들이 설치된 도로에 다른 숫자가 적힌 블록들을 설치하려고 한다.
블록에 적힌 번호가 n일때 n * 2번째 위치에 설치
그 다음은 n * 3, n * 4, ...
블록은 1이 적힌 숫자부터 1씩 증가시키며 설치

길이가 10^9인 도로, 10^8까지 숫자가 적힌 블록들을 설치 완료했다.
특정 구간에 어떤 블록이 깔려있는지 알아내자.

<입력>
begin, end
- begin, end: 구간 (1 ~ 10^9)
- 둘의 차 (0 ~ 10^3)

<출력>
그 구간에 깔려있는 블록의 숫자 배열

<풀이>
파라미터 서치

풀이 봄 -> 약수 문제(파라미터 서치로 불가)
sqrt

*/

class 숫자블록Later {
    final int LIMIT = 10_000_000;

    public int[] solution(long begin, long end) {
        int len = (int) (end - begin) + 1;
        int[] answer = new int[len];

        for (long num = begin; num <= end; num++) {
            answer[(int)(num - begin)] = solve(num);
        }

        return answer;
    }

    int solve(long num) {
        if (num == 1) return 0;

        int result = 1;

        for (long d = 2; d * d <= num; d++) {
            if (num % d == 0) {
                long pair = num / d;

                if (pair <= LIMIT) {
                    return (int) pair;
                }

                if (d <= LIMIT) {
                    result = (int) d;
                }
            }
        }

        return result;
    }
}
