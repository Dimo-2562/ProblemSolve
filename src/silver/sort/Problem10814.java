package silver.sort;

import java.io.*;
import java.util.*;

public class Problem10814 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        //나이를 오름차순으로 정렬 후, 같으면 입력 순서대로
        List<Person> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            String name = st.nextToken();
            list.add(new Person(num, name));
        }

        Collections.sort(list, (p1, p2) -> p1.age - p2.age);

        StringBuilder sb = new StringBuilder();
        for (Person p : list) {
            sb.append(p.age).append(' ').append(p.name).append('\n');
        }
        System.out.print(sb);
    }
}

class Person {
    int age;
    String name;

    public Person(int age, String name) {
        this.age = age;
        this.name = name;
    }
}
