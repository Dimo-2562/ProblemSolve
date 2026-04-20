package gold.structure.stack;

import java.io.*;

public class Problem9935Later2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine();
        String bomb = br.readLine();

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < input.length(); i++) {
            sb.append(input.charAt(i));

            if (isSameString(sb, bomb)) {
                sb.setLength(sb.length() - bomb.length());
            }
        }

        System.out.print(sb.length() == 0 ? "FRULA" : sb);
    }

    static boolean isSameString(StringBuilder sb, String bomb) {
        int sbLen = sb.length();
        int bombLen = bomb.length();

        if (sbLen < bombLen) return false;

        for (int i = 0; i < bomb.length(); i++) {
            if (sb.charAt(sbLen - bombLen + i) != bomb.charAt(i)) return false;
        }

        return true;
    }
}
