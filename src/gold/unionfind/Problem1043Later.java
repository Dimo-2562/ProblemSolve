package gold.unionfind;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem1043Later {

    static int[] parent, rank;
    public static void main(String[] args) throws IOException {
        // 연결 그래프.

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        init(n);

        st = new StringTokenizer(br.readLine());
        int truthNum = Integer.parseInt(st.nextToken());
        int[] truthPerson = new int[truthNum];
        for (int i = 0; i < truthNum; i++) {
            truthPerson[i] = Integer.parseInt(st.nextToken());
        }
        for (int i = 1; i < truthNum; i++) {
            union(truthPerson[0], truthPerson[i]);
        }

        int[][] parties = new int[m][];
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int cnt = Integer.parseInt(st.nextToken());
            parties[i] = new int[cnt];
            for (int j = 0; j < cnt; j++) {
                parties[i][j] = Integer.parseInt(st.nextToken());
            }
            for (int j = 1; j < cnt; j++) {
                union(parties[i][0], parties[i][j]);
            }
        }

        int ans = 0;
        for (int i = 0; i < m; i++) {
            boolean canLie = true;

            if (truthPerson.length > 0) {
                if (find(parties[i][0]) == find(truthPerson[0])) {
                    canLie = false;
                }
            }

            if (canLie) ans++;
        }

        System.out.print(ans);

    }

    static void init(int n) {
        parent = new int [n + 1];
        rank = new int [n + 1];
        for (int i = 1; i <= n; i++) parent[i] = i;
    }

    static int find(int x) {
        if (parent[x] != x) parent[x] = find(parent[x]);
        return parent[x];
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
}
