package gold.unionfind;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem1043Retry {
    static int[] parent, rank;

    static int find(int n) {
        if (parent[n] != n) parent[n] = find(parent[n]);
        return parent[n];
    }

    static void union(int a, int b) {
        a = find(a);
        b = find(b);

        if (a == b) return;
        if (rank[a] < rank[b]) {
            int tmp = a;
            a = b;
            b = tmp;
        }
        parent[b] = a;
        if (rank[a] == rank[b]) rank[a]++;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        // 초기화
        parent = new int[n + 1];
        rank = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            parent[i] = i;
        }

        st = new StringTokenizer(br.readLine());
        int truthNum = Integer.parseInt(st.nextToken());
        int[] truthPerson = new int[truthNum];
        for (int i = 0; i < truthNum; i++) {
            truthPerson[i] = Integer.parseInt(st.nextToken());
        }

        // 진실을 아는 사람 한 그룹으로 합치기
        for (int i = 1; i < truthNum; i++) {
            union(truthPerson[0], truthPerson[i]);
        }

        int[][] partyPerson = new int[m][];
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int partyNum = Integer.parseInt(st.nextToken());
            partyPerson[i] = new int[partyNum];
            for (int j = 0; j < partyNum; j++) {
                partyPerson[i][j] = Integer.parseInt(st.nextToken());
            }

            // 파티 사람들 합치기.
            for (int j = 1; j < partyNum; j++) {
                union(partyPerson[i][0], partyPerson[i][j]);
            }
        }

        int answer = 0;
        for (int i = 0; i < m; i++) {
            boolean canLie = true;

            if (truthNum > 0) {
                if (find(partyPerson[i][0]) == find(truthPerson[0]))
                    canLie = false;
            }

            if (canLie) answer++;
        }
        System.out.print(answer);

    }
}
