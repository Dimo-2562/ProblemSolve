package silver.sort;

import java.util.*;
import java.io.*;

public class Problem10825Retry {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        List<Student1> students = new ArrayList<>();
        while (n-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            int korean = Integer.parseInt(st.nextToken());
            int english = Integer.parseInt(st.nextToken());
            int math = Integer.parseInt(st.nextToken());
            students.add(new Student1(name, korean, english, math));
        }

        Collections.sort(students, (s1, s2) -> {
            if (s1.korean != s2.korean) return s2.korean - s1.korean;
            if (s1.english != s2.english) return s1.english - s2.english;
            if (s1.math != s2.math) return s2.math - s1.math;
            return s1.name.compareTo(s2.name);
        });

        StringBuilder sb = new StringBuilder();
        for (Student1 s : students) {
            sb.append(s.name).append('\n');
        }
        System.out.print(sb);
    }
}

class Student1 {
    String name;
    int korean;
    int english;
    int math;

    public Student1 (String name, int korean, int english, int math) {
        this.name = name;
        this.korean = korean;
        this.english = english;
        this.math = math;
    }
}