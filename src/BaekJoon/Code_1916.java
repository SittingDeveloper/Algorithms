package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Code_1916 {

    /*
     * N : 도시의 개수  (Vertex)
     * M : 버스의 개수  (Edge)
     * startPoint : 시작점
     * endPoint   : 종료점
     * */
    static int N, M, startPoint, endPoint;
    static ArrayList<Node> Graph[];
    static boolean Visited[];
    static int Distance[];

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        Graph = new ArrayList[N + 1];
        Visited = new boolean[N + 1];
        Distance = new int[N + 1];

        for (int i = 0; i <= N; i++) {
            Graph[i] = new ArrayList<>();
            Distance[i] = Integer.MAX_VALUE;
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            Graph[u].add(new Node(v, w));
        }

        st = new StringTokenizer(br.readLine());
        startPoint = Integer.parseInt(st.nextToken());
        endPoint = Integer.parseInt(st.nextToken());

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(startPoint, 0));
        Distance[startPoint] = 0;

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

        System.out.println(Distance[endPoint]);

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
