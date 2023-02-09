package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Code_11657 {

    static int N, M;

    static Edge edges[];

    static long Distance[];

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        edges = new Edge[M + 1];
        Distance = new long[N + 1];

        Arrays.fill(Distance, Integer.MAX_VALUE);

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            edges[i] = new Edge(u, v, w);
        }

        Distance[1] = 0;

        for (int i = 1; i < N; i++) {
            for (int j = 0; j < M; j++) {
                Edge edge = edges[j];
                if (Distance[edge.StartNode] != Integer.MAX_VALUE &&
                        Distance[edge.EndNode] > Distance[edge.StartNode] + edge.Cost) {
                    Distance[edge.EndNode] = Distance[edge.StartNode] + edge.Cost;
                }
            }
        }

        boolean myCycle = false;

        for (int i = 0; i < M; i++) {
            Edge edge = edges[i];
            if (Distance[edge.StartNode] != Integer.MAX_VALUE &&
                    Distance[edge.EndNode] > Distance[edge.StartNode] + edge.Cost) {
                myCycle = true;
            }
        }

        if (!myCycle) {
            for (int i = 2; i <= N; i++) {
                if (Distance[i] == Integer.MAX_VALUE) {
                    System.out.println("-1");
                } else {
                    System.out.println(Distance[i]);
                }
            }
        }

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
