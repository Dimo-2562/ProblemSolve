package silver.implement;

import java.io.*;
import java.util.*;

public class Problem4659Retry {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();
        String str;
        while (!(str = br.readLine()).equals("end")) {
            sb.append("<").append(str).append("> is ");
            if (!isPossible(str)) sb.append("not ");
            sb.append("acceptable.").append('\n');
        }
        System.out.println(sb);

    }

    static boolean isPossible(String str) {
        boolean isPossible = false;
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (isVowel(c)) isPossible = true;

            if (i >= 2) {
                boolean v1 = isVowel(c);
                boolean v2 = isVowel(str.charAt(i-1));
                boolean v3 = isVowel(str.charAt(i-2));

                if (v1 == v2 && v2 == v3) {
                    return false;
                }
            }

            if (i >= 1 && c == str.charAt(i-1)) {
                if (c != 'e' && c != 'o') return false;
            }
        }

        return isPossible;
    }

    static boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }
}
