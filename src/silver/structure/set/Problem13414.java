package silver.structure.set;

import java.io.*;
import java.util.*;

public class Problem13414 {
    public static void main(String[] args) throws IOException {
        // 중복 허용 X. 순서 유지
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int k = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken());

        Set <String> students = new LinkedHashSet<>();
        for (int i = 0; i < l; i++) {
            String studentNum = br.readLine();
            students.remove(studentNum);
            students.add(studentNum);
        }

        int cnt = 0;
        StringBuilder sb = new StringBuilder();
        for (String num : students) {
            if (cnt == k) break;

            sb.append(num).append('\n');
            cnt++;
        }

        System.out.print(sb);

    }
}
