package bronze.bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class Problem2501 {
    public static void main(String[] args) throws IOException {
        // 입력 받고
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        // 약수 찾아서 List에 넣고
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                list.add(i);
                if (i != n / i) {
                    list.add(n / i);
                }
            }
        }

        // 정렬
        list.sort(Comparator.comparing(Integer::intValue));

        // 인덱스 위치 출력. 없으면 0 출력
        if (list.size() >= k){
            System.out.print(list.get(k-1));
        } else {
            System.out.print(0);
        }
    }
}
