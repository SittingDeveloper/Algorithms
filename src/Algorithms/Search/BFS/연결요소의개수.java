package Algorithms.Search.BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 11724, 단순 연결요소 개수
public class 연결요소의개수 {

    static boolean Visited[];
    static int Graph[][];
    static int N, M;

    public static void main(String[] args) throws IOException {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        Visited = new boolean[N + 1];
        Graph = new int[N + 1][N + 1];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            Graph[u][v] = Graph[v][u] = 1;
        }

        int count = 0;
        for (int i = 1; i <= N; i++) {
            if (Visited[i] == false) {
                count++;
                bfs(i);
            }
        }

        System.out.println(count);

    }

    static void bfs(int node) {

        Visited[node] = true;
        Queue<Integer> q = new LinkedList<>();

        q.add(node);

        while (!q.isEmpty()) {

            int curr = q.poll();

            for (int next = 1; next <= N; next++) {
                if (Graph[curr][next] == 1 && Visited[next] == false) {
                    Visited[next] = true;
                    q.add(next);
                }
            }

        }

    }

}
