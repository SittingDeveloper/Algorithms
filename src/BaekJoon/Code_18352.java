package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Code_18352 {

    static ArrayList<Integer> Graph[];
    static int Visited[];
    static int N, M, K, X;

    static List<Integer> answer;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());

        M = Integer.parseInt(st.nextToken());

        K = Integer.parseInt(st.nextToken());

        X = Integer.parseInt(st.nextToken());

        Graph = new ArrayList[N + 1];
        answer = new ArrayList<>();
        Visited = new int[N + 1];

        for (int i = 1; i < Graph.length; i++) {
            Graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            Graph[u].add(v);
        }

        for (int i = 0; i < Visited.length; i++) {
            Visited[i] = -1;
        }

        bfs(X);

        for (int i = 0; i <= N; i++) {
            if (Visited[i] == K) {
                answer.add(i);
            }
        }

        if (answer.isEmpty()) {
            System.out.println(-1);
        } else {
            Collections.sort(answer);
            for (int temp : answer) {
                System.out.println(temp);
            }
        }

    }

    static void bfs(int node) {

        Visited[node]++;

        Queue<Integer> q = new LinkedList<>();
        q.add(node);

        while (!q.isEmpty()) {
            int curr = q.poll();

            for (int next : Graph[curr]) {

                if (Visited[next] == -1) {
                    Visited[next] = Visited[curr] + 1;
                    q.add(next);
                }

            }
        }

    }

}
