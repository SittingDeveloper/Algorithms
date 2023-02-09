package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Code_1753 {

    static ArrayList<Node> Graph[];
    static boolean Visited[];

    static int Distance[];

    static int V, E, K;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        V = Integer.parseInt(st.nextToken());

        E = Integer.parseInt(st.nextToken());

        K = Integer.parseInt(br.readLine());

        Graph = new ArrayList[V + 1];
        Visited = new boolean[V + 1];
        Distance = new int[V + 1];

        for (int i = 0; i < Graph.length; i++) {
            Graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < Distance.length; i++) {
            Distance[i] = Integer.MAX_VALUE;
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            Graph[u].add(new Node(v, w));
        }

        PriorityQueue<Node> pq = new PriorityQueue<>();

        pq.add(new Node(K, 0));
        Distance[K] = 0;

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
                int cost = tmp.Cost;

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

        @Override
        public int compareTo(Node o) {
            return this.Cost - o.Cost;
        }

    }

}
