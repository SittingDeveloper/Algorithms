package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Code_11404 {

    // N : 도시의 수(Node) , M : 버스의 수(Edge)
    static int N, M;

    // 가중치 그래프
    static int Graph[][];

    static final int Max_Value = 10000001;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        Graph = new int[N + 1][N + 1];

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (i == j)
                    Graph[i][j] = 0;
                else
                    Graph[i][j] = Max_Value;
            }
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            if (Graph[start][end] > cost) {
                Graph[start][end] = cost;
            }
        }

        for (int k = 1; k <= N; k++) {
            for (int start = 1; start <= N; start++) {
                for (int end = 1; end <= N; end++) {
                    Graph[start][end] = Math.min(Graph[start][end], Graph[start][k] + Graph[k][end]);
                }
            }
        }

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (Graph[i][j] == Max_Value) {
                    System.out.print("0 ");
                } else {
                    System.out.print(Graph[i][j] + " ");
                }
            }
            System.out.println();
        }

    }

}
