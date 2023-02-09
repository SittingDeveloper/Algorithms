package Algorithms.Graph.Bellman_Ford;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 11657
public class 타임머신 { // N : 도시(Node),  M : 버스(Edge)
    static int N, M;

    // *핵심 : 벨만-포드는 엣지 리스트로 구현한다.
    static Edge edges[];

    // 거리 배열
    static long Distance[];

    public static void main(String[] args) throws IOException {

        /*
         * N개의 도시가 있다. 그리고 한 도시에서 출발하여 다른 도시에 도착하는 버스가 M개 있다.
         * 각 버스는 A, B, C로 나타낼 수 있는데, A는 시작도시, B는 도착도시, C는 버스를 타고 이동하는데 걸리는 시간이다.
         * 시간 C가 양수가 아닌 경우가 있다. C = 0인 경우는 순간 이동을 하는 경우, C < 0인 경우는 타임머신으로 시간을 되돌아가는 경우이다.
         * 1번 도시에서 출발해서 나머지 도시로 가는 가장 빠른 시간을 구하는 프로그램을 작성하시오.
         *
         * Hint : 시간 C가 양수가 아닌 경우가 있다 : 다익스트라 사용 불가, 벨만포드 사용해야함
         * */

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        edges = new Edge[M + 1];
        Distance = new long[N + 1];

        // 거리 배열을 충분히 큰 수로 초기화
        Arrays.fill(Distance, Integer.MAX_VALUE);

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            edges[i] = new Edge(u, v, w);
        }

        // 출발 노드의 거리배열을 0으로 초기화
        Distance[1] = 0;

        // 벨만포드 알고리즘 수행
        for (int i = 1; i < N; i++) {
            for (int j = 0; j < M; j++) {
                Edge edge = edges[j];

                /*
                 * Distance[edge.StartNode] != Integer.MAX_VALUE :
                 * 출발노드가 무한대가 아니면서 ( 즉, 이미 방문한 적 있고 )
                 *
                 * Distance[edge.EndNode] > Distance[edge.StartNode] + edge.Cost :
                 * (종료노드값 > 출발노드값 + 에지 가중치) 일 때 종료노드값을 출발노드값 + 에지 가중치로 업데이트
                 * */
                if (Distance[edge.StartNode] != Integer.MAX_VALUE &&
                        Distance[edge.EndNode] > Distance[edge.StartNode] + edge.Cost) {
                    Distance[edge.EndNode] = Distance[edge.StartNode] + edge.Cost;
                }
            }
        }

        boolean myCycle = false;

        // 음수 사이클 확인하기
        for (int i = 0; i < M; i++) {
            Edge edge = edges[i];
            if (Distance[edge.StartNode] != Integer.MAX_VALUE &&
                    Distance[edge.EndNode] > Distance[edge.StartNode] + edge.Cost) {
                myCycle = true;
            }
        }

        // 음의 사이클이 없을 때
        if (!myCycle) {
            for (int i = 2; i <= N; i++) {
                if (Distance[i] == Integer.MAX_VALUE) {
                    System.out.println("-1");
                } else {
                    System.out.println(Distance[i]);
                }
            }
        }

        // 음의 사이클이 있을 때
        else {
            System.out.println("-1");
        }

    }

    static class Edge {

        int StartNode;
        int EndNode;
        int Cost;

        Edge(int StartNode, int EndNode, int Cost) {
            this.StartNode = StartNode;
            this.EndNode = EndNode;
            this.Cost = Cost;
        }

    }

}

