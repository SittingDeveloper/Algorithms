package Algorithms.Graph.Floyd_warshall;

public class Programmers_순위 {

    // 위상정렬문제인줄 알았는데 플로이드 워셜문제였음
    public static void main(String[] args) {
        int n = 5;
        int results[][] = {{4,3}, {4,2}, {3,2}, {1,2}, {2,5}};
        System.out.println(solution(n, results));
    }

    public static int solution(int n, int[][] results) {
        int answer = 0;
        int Graph[][] = new int[n + 1][n + 1];

        for (int i = 0; i < results.length; i++) {
            int u = results[i][0];
            int v = results[i][1];
            Graph[u][v] = 1; // win
            Graph[v][u] = -1; // lose
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                for (int k = 1; k <= n; k++) {
                    if (Graph[i][j] == 1 && Graph[j][k] == 1) {
                        Graph[i][k] = 1;
                        Graph[k][i] = -1;
                    }
                    if (Graph[i][j] == -1 && Graph[j][k] == -1) {
                        Graph[i][k] = -1;
                        Graph[k][i] = 1;
                    }
                }
            }
        }


        for (int i = 1; i <= n; i++) {
            int cnt = 0;
            for (int j = 1; j <= n; j++) {
                if (Graph[i][j] != 0) {
                    cnt++;
                }
            }
            if (cnt == n - 1)
                answer++;
        }


        return answer;
    }

}
