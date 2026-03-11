package silver.implement;

import java.io.*;

/*
모음을 반드시 하나 포함
모음 3개 or 자음 3개 연속은 안된다
같은 글자가 연속으로 두 번 오면 안된다 (ee, oo는 허용)

end가 입력으로 들어오면 테스트 종료.
 */

public class Problem4659 {

    static char[] vowels = {'a', 'e', 'i', 'o', 'u'};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();
        while (true) {
            String str = br.readLine();

            if (str.equals("end")) break;

            boolean isContainsVowel = false;
            if(str.contains("a") || str.contains("e") || str.contains("i")
            || str.contains("o") || str.contains("u")) isContainsVowel = true;

            boolean isOk = true;
            for (int i = 0; i < str.length(); i++) {
                // 모음 3개 혹은 자음 3개 연속 조건 체크
                if (i >= 2) {
                    int cnt = 0;
                    for (int j = 0; j < 5; j++) {
                        if(str.charAt(i-2) == vowels[j]) {
                            cnt++;
                            break;
                        }
                    }
                    for (int j = 0; j < 5; j++) {
                        if(str.charAt(i-1) == vowels[j]) {
                            cnt++;
                            break;
                        }
                    }
                    for (int j = 0; j < 5; j++) {
                        if(str.charAt(i) == vowels[j]) {
                            cnt++;
                            break;
                        }
                    }
                    if (cnt == 0 || cnt == 3) isOk = false;
                }

                // 같은 글자 두 번 연속 체크
                if (i >= 1) {
                    if (str.charAt(i) == 'e' || str.charAt(i) == 'o') continue;
                    else {
                        if(str.charAt(i) == str.charAt(i-1)) isOk = false;
                    }
                }
            }

            sb.append('<').append(str).append("> is ");
            if (!isContainsVowel || !isOk) {
                sb.append("not ");
            }
            sb.append("acceptable.").append('\n');
        }
        System.out.print(sb);

    }
}
