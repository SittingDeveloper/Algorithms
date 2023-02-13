package Algorithms.Graph.Floyd_warshall;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 11404
public class 가장빠른_버스노선_구하기 {

    // N : 도시의 수(Node) , M : 버스의 수(Edge)
    static int N, M;

    // 가중치 그래프
    static int Graph[][];

    static final int Max_Value = 10000001;

    public static void main(String[] args) throws IOException {

        /*
         * 플로이드-워셜
         * 1. 인접행렬 배열을 선언하고 S==E를 0으로, 이외는 무한으로 초기화
         * 2. 최단 거리 배열에 그래프 데이터 저장 D[S][E] = W(가중치)
         * 3. 점화식으로 배열 업데이트
         *   for ( 경유지 K )
         *     for ( 출발노드 S )
         *       for ( 도착노드 E )
         * */

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        Graph = new int[N + 1][N + 1];

        // 1. 인접행렬 배열은 선언하고 S==E를 0으로, 이외는 무한으로 초기화
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (i == j)
                    Graph[i][j] = 0;
                else
                    Graph[i][j] = Max_Value;
            }
        }

        // 2. 최단 거리 배열에 그래프 데이터 저장 D[S][E] = W(가중치)
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            // 값이 덧씌워질 경우 대비, 더 작은 값으로 업데이트
            if (Graph[start][end] > cost) {
                Graph[start][end] = cost;
            }
        }

        // 3. 점화식으로 배열 업데이트
        for (int k = 1; k <= N; k++) {
            for (int start = 1; start <= N; start++) {
                for (int end = 1; end <= N; end++) {
                    /*if (Graph[start][end] > Graph[start][k] + Graph[k][end]) {
                        Graph[start][end] = Graph[start][k] + Graph[k][end];
                    }*/
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
