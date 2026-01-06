package bronze.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem5622 {
    private static final int[] DIAL_TIME = {
            3, 3, 3,        // ABC (2번)
            4, 4, 4,        // DEF (3번)
            5, 5, 5,        // GHI (4번)
            6, 6, 6,        // JKL (5번)
            7, 7, 7,        // MNO (6번)
            8, 8, 8, 8,     // PQRS (7번)
            9, 9, 9,        // TUV (8번)
            10, 10, 10, 10  // WXYZ (9번)
    };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String word = br.readLine();

        int totalTime = 0;
        for (char c : word.toCharArray()) {
            totalTime += DIAL_TIME[c - 'A'];
        }

        System.out.print(totalTime);
    }
}
