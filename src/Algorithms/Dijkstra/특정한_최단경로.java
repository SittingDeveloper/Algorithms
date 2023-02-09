package Algorithms.Dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// 1504
public class 특정한_최단경로 {

    static int N, E;

    static ArrayList<Node> Graph[];
    static boolean Visited[];
    static int Distance[];

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        Graph = new ArrayList[N + 1];
        Visited = new boolean[N + 1];
        Distance = new int[N + 1];

        for (int i = 0; i < N + 1; i++) {
            Graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            Graph[u].add(new Node(v, w));
            Graph[v].add(new Node(u, w));
        }

        st = new StringTokenizer(br.readLine());
        int v1 = Integer.parseInt(st.nextToken());
        int v2 = Integer.parseInt(st.nextToken());

        int min = Math.min((Dijkstra(1, v1) + Dijkstra(v1, v2) + Dijkstra(v2, N)),
                (Dijkstra(1, v2) + Dijkstra(v2, v1) + Dijkstra(v1, N) ));

        System.out.println(min);
    }

    static int Dijkstra(int startNode, int endNode) {

        for (int i = 0; i < Distance.length; i++) {
            Distance[i] = Integer.MAX_VALUE;
            Visited[i] = false;
        }

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(startNode, 0));
        Distance[startNode] = 0;

        while (!pq.isEmpty()) {

            Node curr = pq.poll();
            int curr_vertex = curr.Vertex;

            if (Visited[curr_vertex] == true) {
                continue;
            }

            Visited[curr_vertex] = true;

            for (int i = 0; i < Graph[curr_vertex].size(); i++) {
                Node tmp = Graph[curr_vertex].get(i);

                int next = tmp.Vertex;
                int Cost = tmp.Cost;

                if (Distance[next] > Distance[curr_vertex] + Cost) {
                    Distance[next] = Distance[curr_vertex] + Cost;
                    pq.add(new Node(next, Distance[next]));
                }
            }
        }

        if (Visited[endNode] == false) {
            System.out.println(-1);
            System.exit(0);
        }

        return Distance[endNode];

    }

    static class Node implements Comparable<Node>{
        int Vertex;
        int Cost;

        Node(int Vertex, int Cost) {
            this.Vertex = Vertex;
            this.Cost = Cost;
        }

        @Override
        public int compareTo(Node node) {
            return this.Cost - node.Cost;
        }

    }

}
