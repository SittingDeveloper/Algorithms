package DFS_BFS.Algorithms.DFS;

import java.util.Scanner;

public class DFS_1 {

    static final int MAX_N = 10;
    static int N, E; // N = 노드의 수 , E = 간선의 수
    static int[][] Graph = new int[MAX_N][MAX_N];

    // 방문 여부
    static boolean[] Visited = new boolean[MAX_N];

    // DFS는 재귀함수를 사용한다
    static void dfs(int node) {

        // 방문한 노드를 true로 변경
        Visited[node] = true;

        // 방문한 노드를 출력
        System.out.print(node + " ");

        /*
        다음 노드가 있는지 확인하고 재귀함수 실행
        !Visited[next] : 방문하지 않았고
        !Graph[node][next] != 0 : 간선이 존재한다면
        */
        for (int next = 0; next < N; ++next) {
            if(!Visited[next] && Graph[node][next] != 0)
                dfs(next);
        }
    }

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        // 노드 수 입력
        N = scan.nextInt();

        // 간선 수 입력
        E = scan.nextInt();

        for (int i = 0; i < E; i++) {
            int u = scan.nextInt();
            int v = scan.nextInt();

            // u, v 노드 사이에 간선이 존재한다, 간선의 방향을 지정하지 않았기 때문에 역순으로도 1을 해줌.
            Graph[u][v] = Graph[v][u] = 1;
        }

        dfs(0);

    }
}
