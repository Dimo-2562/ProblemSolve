package bronze.bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Problem2501Retry {
    public static void main(String[] args) throws IOException {
        // 입력 받고
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        // 약수 찾아서 각각 리스트에 넣고
        List<Integer> smallList = new ArrayList<>();
        List<Integer> bigList = new ArrayList<>();
        for (int i = 1; i * i <=n; i++){
            if (n % i == 0){
                smallList.add(i);
                if (i != n / i){
                    bigList.add(n / i);
                }
            }
        }

        // 사이즈 체크해서 출력
        if (smallList.size() >= k){
            System.out.print(smallList.get(k-1));
        } else if (smallList.size() + bigList.size() >= k){
            System.out.print(bigList.get(bigList.size() - (k - smallList.size())));
        } else {
            System.out.print(0);
        }
    }
}
