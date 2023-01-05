package Algorithms.Search.DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 11724
public class 연결요소의개수 {

    static int MAX_N = 10000;
    static int N, M;
    static int Graph[][] = new int[MAX_N][MAX_N];
    static boolean Visited[] = new boolean[MAX_N];

    static int count = 0;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            Graph[u][v] = Graph[v][u] = 1;

        }

        for (int i = 1; i <= N; i++) {
            if (Visited[i] == false) {
                dfs(i);
                count++;
            }
        }

        System.out.println(count);

    }

    public static void dfs(int node) {

        Visited[node] = true;

        for (int next = 1; next <= N; next++) {

            if (Visited[next] == false && Graph[node][next] == 1) {
                dfs(next);
            }

        }
    }

}
