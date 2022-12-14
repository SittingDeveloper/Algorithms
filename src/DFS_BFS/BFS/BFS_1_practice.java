package DFS_BFS.BFS;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BFS_1_practice {

    static final int MAX_N = 10;
    static int E, N;
    static int Graph[][] = new int[MAX_N][MAX_N];

    static void bfs(int node) {

        boolean visited[] = new boolean[MAX_N];
        visited[node] = true;

        Queue<Integer> myQueue = new LinkedList<>();
        myQueue.add(node);

        while (!myQueue.isEmpty()) {

            int curr = myQueue.remove();
            System.out.print(curr + " ");

            for (int next = 0; next < N; next++) {

                if (visited[next] == false && Graph[next][curr] == 1) {
                    visited[next] = true;
                    myQueue.add(next);
                }

            }
        }
    }

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        E = scan.nextInt();
        N = scan.nextInt();

        for (int i = 0; i < E; i++) {
            int u = scan.nextInt();
            int v = scan.nextInt();

            Graph[u][v] = Graph[v][u] = 1;
        }

        bfs(0);

    }

}
