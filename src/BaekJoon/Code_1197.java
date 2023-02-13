package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;


public class Code_1197 {

    static int unf[];
    static PriorityQueue<Edge> pq;

    static int find(int v) {

        if (unf[v] == v) {
            return v;
        } else {
            return unf[v] = find(unf[v]);
        }

    }

    static void union(int a, int b) {
        a = find(a);
        b = find(b);

        if (a != b) {
            unf[b] = a;
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());

        pq = new PriorityQueue<>();

        unf = new int[V + 1];
        for (int i = 1; i < unf.length; i++) {
            unf[i] = i;
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            pq.add(new Edge(start, end, cost));
        }

        int usedEdge = 0;

        int result = 0;

        while (usedEdge < V - 1) {
            Edge curr = pq.poll();

            if (find(curr.start) != find(curr.end)) {
                union(curr.start, curr.end);
                result += curr.cost;
                usedEdge++;
            }

        }

        System.out.println(result);

    }

    static class Edge implements Comparable<Edge>{
        int start;
        int end;
        int cost;

        Edge(int start, int end, int cost) {
            this.start = start;
            this.end = end;
            this.cost = cost;
        }

        @Override
        public int compareTo(Edge o) {
            return this.cost - o.cost;
        }

    }

}
