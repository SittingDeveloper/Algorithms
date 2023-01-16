package Algorithms.Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 18352
public class 특정거리의_도시찾기 {

    static ArrayList<Integer> Graph[];
    static int Visited[];
    static int N, M, K, X;

    // 정답 리스트
    static List<Integer> answer;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 도시의 수 (정점의 개수)
        N = Integer.parseInt(st.nextToken());

        // 도로의 개수 (에지의 개수)
        M = Integer.parseInt(st.nextToken());

        // 거리정보 (에지를 거쳐간 횟수 Counting )
        K = Integer.parseInt(st.nextToken());

        // 출발 도시의 번호 ( 출발 정점 )
        X = Integer.parseInt(st.nextToken());

        Graph = new ArrayList[N + 1];
        answer = new ArrayList<>();
        Visited = new int[N + 1];

        // 인접 리스트의 각 ArrayList 초기화하기
        for (int i = 1; i < Graph.length; i++) {
            Graph[i] = new ArrayList<>();
        }

        // 인접 리스트에 그래프 데이터 저장하기
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            Graph[u].add(v);
        }

        // 방문배열 -1로 초기화
        for (int i = 0; i < Visited.length; i++) {
            Visited[i] = -1;
        }

        // bfs 탐색 실행
        bfs(X);

        // 방문거리가 K인 노드의 숫자를 정답 배열에 더하기
        for (int i = 0; i <= N; i++) {
            /*if (Visited[i] == K) {
                answer.add(i);
            }*/
            System.out.println(Visited[i]);
        }

        // 정답배열 오름차순 정렬해 출력하기
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
