package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Code_2252 {

    static ArrayList<Integer> Graph[];

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 학생 수
        int N = Integer.parseInt(st.nextToken());

        // 비교 횟수
        int M = Integer.parseInt(st.nextToken());

        // 진입차수 배열
        int D[] = new int[N + 1];

        Graph = new ArrayList[N + 1];
        for (int i = 0; i < Graph.length; i++) {
            Graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            Graph[u].add(v);

            D[v]++;
        }

        Queue<Integer> q = new LinkedList<>();
        for (int i = 1; i < D.length; i++) {
            if (D[i] == 0) {
                q.add(i);
            }
        }

        while (!q.isEmpty()) {
            int curr = q.poll();

            System.out.print(curr + " ");

            for (int next : Graph[curr]) {
                D[next]--;
                if (D[next] == 0) {
                    q.add(next);
                }
            }
        }

    }

}
