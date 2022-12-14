package DFS_BFS.BFS;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BFS_1 {

    /* BFS : Breadth First Search */

    static final int MAX_N = 10;
    static int E, N;
    static int Graph[][] = new int[MAX_N][MAX_N];

    static void bfs(int node) {
        boolean visited[] = new boolean[MAX_N];

        // 자바 자료형중 하나인 Queue. Queue 는 보통 LinkedList 를 사용해야한다.
        Queue<Integer> myQueue = new LinkedList<>();

        // 방문했다는 의미의 true
        visited[node] = true;

        // 큐에 현재 node 삽입
        myQueue.add(node);

        // 큐가 빌 때 까지 무한반복
        while(!myQueue.isEmpty()) {

            // 큐에서 값을 꺼내 임시변수에 저장
            int curr = myQueue.remove();

            System.out.print(curr + " ");

            for (int next = 0; next < N; ++next) {
                if (!visited[next] && Graph[curr][next] != 0) {
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
