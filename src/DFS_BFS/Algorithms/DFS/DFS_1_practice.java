package DFS_BFS.Algorithms.DFS;

import java.util.Scanner;

public class DFS_1_practice {

    static final int MAX_N = 10;

    static int N, E;
    static int Graph[][] = new int[MAX_N][MAX_N];

    static boolean Visited[] = new boolean[MAX_N];

    static void dfs(int node) {

        Visited[node] = true;

        System.out.print(node + ' ');

        for (int next = 0; next < N; ++next) {

            if (Visited[next] == false && Graph[next][node] == 1) {
                dfs(next);
            }

        }

    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        N = scan.nextInt();
        E = scan.nextInt();

        for (int i = 0; i < E; i++) {
            int u = scan.nextInt();
            int v = scan.nextInt();

            Graph[u][v] = Graph[v][u] = 1;
        }

        dfs(0);

    }

}
