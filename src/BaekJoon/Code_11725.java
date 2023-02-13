package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Code_11725 {

    static ArrayList<Integer> Graph[];
    static boolean Visited[];
    static int N;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        Visited = new boolean[N + 1];
        Graph = new ArrayList[N + 1];
        for (int i = 0; i < Graph.length; i++) {
            Graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int node1 = Integer.parseInt(st.nextToken());
            int node2 = Integer.parseInt(st.nextToken());

            Graph[node1].add(node2);
            Graph[node2].add(node1);
        }

        /*for (int i = 1; i < Graph.length; i++) {
            System.out.println("Graph[" + i + "] : " + Graph[i]);
        }*/

        bfs(1);

    }

    static void bfs(int startNode) {

        Visited[startNode] = true;

        Queue<Integer> q = new LinkedList<>();
        q.add(startNode);

        int parent[] = new int[N + 1];

        while (!q.isEmpty()) {
            int curr = q.poll();

            for (int next : Graph[curr]) {
                if (Visited[next] == false) {
                    Visited[next] = true;
                    q.add(next);
                    parent[next] = curr;
                }
            }

        }

        // parent[0] == 설정x, parent[1] == 루트노드, 그래서 2번부터
        for (int i = 2; i < parent.length; i++) {
            System.out.println(parent[i]);
        }


    }

}
