package Practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*
n : 4
m : 6
k : 9
u[] = { 1,2,3,1,1,2 }
v[] = { 2,3,4,4,3,4 }
I[] = { 3,3,3,3,1,2}
* */


public class Main {

    static int n, m, k;
    static int u[];
    static int v[];
    static int I[];

    static int parent[];
    static ArrayList<Edge> edges;

    public static void main(String[] args) {

        n = 4;
        m = 6;
        k = 9;

        u = new int[]{1,2,3,1,1,2};
        v = new int[]{2,3,4,4,3,4};
        I = new int[]{3,3,3,3,1,2};

        edges = new ArrayList<>();

        for (int i = 0 ; i < m ; i++) {
            int start = u[i];
            int end = v[i];
            int weight = I[i];

            edges.add(new Edge(start, end, weight));
        }

        System.out.println(binarySearch());

    }

    public static int binarySearch() {
        int left = 0;
        int right = 10000000;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (check(mid)) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return right;
    }

    public static boolean check(int mid) {
        parent = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            parent[i] = i;
        }
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        for (Edge edge : edges) {
            if (edge.weight >= mid) {
                pq.offer(edge);
            }
        }

        ArrayList<Integer> selectedEdges = new ArrayList<>();

        while (!pq.isEmpty()) {
            Edge edge = pq.poll();
            if (find(edge.u) != find(edge.v)) {
                union(edge.u, edge.v);
                selectedEdges.add(edge.weight);
            }
        }

        for (int i=2; i<=n; i++) {
            if (find(i) != find(1)) return false;
        }

        Collections.sort(selectedEdges);

        int sum = 0;

        for (int i=0; i<selectedEdges.size(); i++) {
            sum += selectedEdges.get(i);

            if (i == n-2) break;
        }

        return sum <= k;
    }

    public static void union(int a, int b) {
        a = find(a);
        b = find(b);
        if (a < b) parent[b] = a;
        else parent[a] = b;
    }

    public static int find(int x) {
        if (x == parent[x]) return x;
        return parent[x] = find(parent[x]);
    }

    static class Edge implements Comparable<Edge> {
        int u;
        int v;
        int weight;

        public Edge(int u, int v, int weight) {
            this.u = u;
            this.v = v;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge o) {
            return this.weight - o.weight;
        }
    }

}