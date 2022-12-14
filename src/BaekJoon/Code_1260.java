package BaekJoon;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Code_1260 {

    static int N, E, V;
    static boolean dfs_visited[] = new boolean[1001];
    static int Graph[][] = new int[1001][1001];

    static void dfs(int node) {

        dfs_visited[node] = true;

        System.out.print(node + " ");

        for (int next = 0; next <= N; ++next) {
            if (dfs_visited[next] == false && Graph[next][node] == 1) {
                dfs(next);
            }
        }

    }

    static void bfs(int node) {

        boolean[] bfs_visited = new boolean[1001];
        bfs_visited[node] = true;

        Queue<Integer> myQueue = new LinkedList<>();
        myQueue.add(node);

        while (!myQueue.isEmpty()) {
            int curr = myQueue.remove();
            System.out.print(curr + " ");

            for (int next = 0; next <= N; ++next) {
                if (bfs_visited[next] == false && Graph[curr][next] == 1) {
                    bfs_visited[next] = true;
                    myQueue.add(next);
                }
            }

        }

    }

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        N = scan.nextInt();
        E = scan.nextInt();
        V = scan.nextInt();

        for (int i = 0; i < E; i++) {
            int u = scan.nextInt();
            int a = scan.nextInt();

            Graph[u][a] = Graph[a][u] = 1;
        }

        dfs(V);
        System.out.println("");
        bfs(V);

    }

}
