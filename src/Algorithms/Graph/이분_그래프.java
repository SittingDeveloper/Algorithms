package Algorithms.Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 1707
public class 이분_그래프 {

    static ArrayList<Integer> Graph[];
    static boolean Visited[];
    static int V, E;

    static int[] check;
    static boolean IsEven;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int testCase = 0; testCase < T; testCase++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            V = Integer.parseInt(st.nextToken());
            E = Integer.parseInt(st.nextToken());

            Graph = new ArrayList[V + 1];
            Visited = new boolean[V + 1];
            check = new int[V + 1];
            IsEven = true;

            for (int i = 0; i < Graph.length; i++) {
                Graph[i] = new ArrayList<>();
            }

            for (int i = 0; i < E; i++) {
                st = new StringTokenizer(br.readLine());

                int u = Integer.parseInt(st.nextToken());
                int v = Integer.parseInt(st.nextToken());

                Graph[u].add(v);
                Graph[v].add(u);
            }

            /*for (int i = 1; i <= V; i++) {
                System.out.println("Graph[" + i + "] : " + Graph[i]);
            }*/

            for (int i = 1; i <= V; i++) {
                if (IsEven) {
                    bfs(i);
                } else
                    break;
            }

            if (IsEven) {
                sb.append("YES\n");
            } else {
                sb.append("NO\n");
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

                    // 인접합 노드는 같은 집합이 아니므로 이전 노드와 다른 집합으로 처리하기
                    check[next] = (check[curr] + 1) % 2;

                    Visited[next] = true;
                    q.add(next);

                } else if (check[curr] == check[next]) {
                    IsEven = false;
                }

            }

        }

    }

}
