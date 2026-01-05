package string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem2908 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        char[] firstArr = st.nextToken().toCharArray();
        char[] secondArr = st.nextToken().toCharArray();

        swap(firstArr);
        swap(secondArr);

        int first = Integer.parseInt(new String(firstArr));
        int second = Integer.parseInt(new String(secondArr));

        System.out.print(Math.max(first, second));
    }

    private static void swap(char[] arr) {
        char temp = arr[0];
        arr[0] = arr[arr.length - 1];
        arr[arr.length - 1] = temp;
    }
}
