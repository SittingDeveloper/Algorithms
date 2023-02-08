package Algorithms.Dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// 1753
public class 최단경로 {

    static ArrayList<Node> Graph[];
    static boolean Visited[];

    // 거리 배열
    static int Distance[];

    static int V, E, K;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // Vertex
        V = Integer.parseInt(st.nextToken());

        // Edge
        E = Integer.parseInt(st.nextToken());

        // Start Node
        K = Integer.parseInt(br.readLine());

        Graph = new ArrayList[V + 1];
        Visited = new boolean[V + 1];
        Distance = new int[V + 1];

        for (int i = 0; i < Graph.length; i++) {
            Graph[i] = new ArrayList<>();
        }

        // Integer.MAX_VALUE (거의 무한 값) 으로 초기화 시켜주어야함
        // 최소값을 기준으로 점점 업데이트해야하기 때문
        for (int i = 0; i < Distance.length; i++) {
            Distance[i] = Integer.MAX_VALUE;
        }

        // 인접리스트 값 입력
        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            // Edge Info
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            // Cost
            int w = Integer.parseInt(st.nextToken());

            Graph[u].add(new Node(v, w));
        }

        // 최소값을 가장 먼저 뽑아내는 우선순위 큐
        PriorityQueue<Node> pq = new PriorityQueue<>();

        pq.add(new Node(K, 0));
        Distance[K] = 0;

        while (!pq.isEmpty()) {
            Node curr = pq.poll();
            int curr_vertex = curr.Vertex;

            // 이미 방문한 적이 있는 노드는 다시 큐에 넣지 않음
            if (Visited[curr_vertex] == true) {
                continue;
            }

            // 방문 처리
            Visited[curr_vertex] = true;

            // 현재 노드와 연결된 인접 리스트 노드를 최소 거리로 업데이트
            for (int i = 0; i < Graph[curr_vertex].size(); i++) {
                Node tmp = Graph[curr_vertex].get(i);
                int next = tmp.Vertex;
                int cost = tmp.Cost;

                // 최소 거리로 Distance 업데이트
                if (Distance[next] > Distance[curr_vertex] + cost) {
                    Distance[next] = Distance[curr_vertex] + cost;
                    pq.add(new Node(next, Distance[next]));
                }
            }
        }

        for (int i = 1; i <= V; i++) {
            if (Visited[i] == true) {
                System.out.println(Distance[i]);
            } else {
                System.out.println("INF");
            }
        }
    }

    static class Node implements Comparable<Node> {
        int Vertex;
        int Cost;

        Node(int Vertex, int Cost) {
            this.Vertex = Vertex;
            this.Cost = Cost;
        }

        // 1  : 크다 x > 0, 현재 개체가 매개 변수 개체보다 큰 경우
        // -1 : 작다 x < 0, 현재 개체가 매개 변수 개체보다 작은 경우
        // 0  : 같다 x == 0, 현재 개체와 매개 변수 개체가 같은 값일 경우
        @Override
        public int compareTo(Node o) {
        /*if (this.Cost > o.Cost)
            return 1;
        else
            return -1;*/
            return this.Cost - o.Cost;
        }

    }


}

