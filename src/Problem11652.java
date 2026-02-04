import java.util.*;
import java.io.*;

public class Problem11652 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Map <Long, Integer> map = new TreeMap<>();
        while (n-- > 0) {
            Long num = Long.parseLong(br.readLine());
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        long max = Long.MIN_VALUE;
        long ans = 0;
        for (Map.Entry<Long, Integer> entry : map.entrySet()){
            if (max < entry.getValue()) {
                max = entry.getValue();
                ans = entry.getKey();
            }
        }

        System.out.print(ans);

    }
}
