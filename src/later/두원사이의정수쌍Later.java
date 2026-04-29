package later;

import java.util.*;

/*
하 어렵다...
*/

class 두원사이의정수쌍Later {
    public long solution(int r1, int r2) {
        long answer = 0;

        for (int x = 1; x <= r2; x++) {
            long xx = 1L * x * x;

            long maxY = (long) Math.floor(Math.sqrt(1L * r2 * r2 - xx));
            long minY = 0;

            if (x < r1) {
                minY = (long) Math.ceil(Math.sqrt(1L * r1 * r1 - xx));
            }

            answer += maxY - minY + 1;
        }

        return answer * 4;
    }
}