package Algorithms.Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 1325
public class 효율적인_해킹 {
    static ArrayList<Integer> Graph[];
    static boolean Visited[];
    static int N, M;

    static int answer[];

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        Graph = new ArrayList[N + 1];
        answer = new int[N + 1];

        for (int i = 0; i < Graph.length; i++) {
            Graph[i] = new ArrayList<>();
        }

        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            Graph[u].add(v);
        }

        /*for (int i = 1; i <= N; i++) {
            System.out.println("Graph[" + i + "] :" + Graph[i]);
        }

        int maxSize = 0;
        int maxIndex = 0;

        for (int i = 1; i <= N; i++) {
            if (maxSize < Graph[i].size()) {
                maxSize = Graph[i].size();
                maxIndex = i;
            }
        }*/

        for (int i = 1; i <= N; i++) {
            Visited = new boolean[N + 1];
            bfs(i);
        }

        int maxVal = 0;
        for (int i = 1; i <= N; i++) {
            maxVal = Math.max(maxVal, answer[i]);
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 1; i <= N; i++) {
            if (answer[i] == maxVal) {
                sb.append(i + " ");
            }
        }
        System.out.println(sb);
    }

    static void bfs(int node) {

        Visited[node] = true;

        Queue<Integer> q = new LinkedList<>();
        q.add(node);

        while (!q.isEmpty()) {

            int curr = q.poll();

            for (int next : Graph[curr]) {
                if (Visited[next] == false) {
                    Visited[next] = true;
                    answer[next]++;
                    q.add(next);
                }
            }

        }

    }

}
