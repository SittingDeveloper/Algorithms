package Algorithms.Search.DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 11724
public class 연결요소의개수 {

    static boolean Visited[];
    static int Graph[][];

    static int N;
    static int M;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); // 정점의 개수
        M = Integer.parseInt(st.nextToken()); // 간선의 개수
        Visited = new boolean[N+1];
        Graph = new int[N+1][N+1];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            Graph[u][v] = 1;
            Graph[v][u] = 1;
        }


        int answer = 0;
        for (int i = 1; i <= N; i++) {
            if (Visited[i] == false) {
                answer++;
                dfs(i);
            }

        }

        System.out.println(answer);

    }

    static void dfs(int index) {

        Visited[index] = true;

        for (int next = 1; next <= N; next++) {
            if (Visited[next] == false && Graph[index][next] == 1) {
                dfs(next);
            }
        }

    }

}
