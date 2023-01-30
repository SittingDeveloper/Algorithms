package Algorithms.Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 1976
public class UNF_여행_가자 {

    static int unf[];

    static int find(int v) {

        if (unf[v] == v) {
            return v;
        } else {
            return unf[v] = find(unf[v]);
        }

    }

    static void union(int a, int b) {
        a = find(a);
        b = find(b);
        if (a != b) {
            unf[b] = a;
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        unf = new int[N + 1];

        for (int i = 1; i < unf.length; i++) {
            unf[i] = i;
        }

        // 인접행렬이 1인 값들이 모두 같은 indexRoute 를 가진다면 이어진 것, 여행 가능
        int Graph[][] = new int[N + 1][N + 1];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                Graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (Graph[i][j] == 1) {
                    union(i, j);
                }
            }
        }

        st = new StringTokenizer(br.readLine());
        int index = find(Integer.parseInt(st.nextToken()));

        for (int i = 1; i < M; i++) {
            if (index != find(Integer.parseInt(st.nextToken()))) {
                System.out.println("NO");
                return;
            }
        }

        System.out.println("YES");

    }

}
