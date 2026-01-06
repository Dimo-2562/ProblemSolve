package bronze.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.stream.Collectors;

public class Problem10871Retry2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int x = Integer.parseInt(br.readLine().split(" ")[1]);

        String answer = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .filter(num -> num < x)
                .mapToObj(String::valueOf)
                .collect(Collectors.joining(" "));

        System.out.println(answer);
    }
}
