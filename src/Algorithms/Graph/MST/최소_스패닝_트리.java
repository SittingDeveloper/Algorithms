package Algorithms.Graph.MST;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// 1197
public class 최소_스패닝_트리 {

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

        /*
         * 최소신장트리의 핵심 이론
         * 1. Edge List 그래프를 구현하고 유니온 파인드 배열 초기화하기
         * 2. 그래프 데이터를 가중치 기준으로 정렬하기
         * 3. 가중치가 낮은 에지부터 연결 시도하기 (find 이후 트리노드가 다르다면 union)
         * 4. 과정3 반복하기 ( for (edge 수 == N - 1) )
         * 5. 총 에지 비용 출력하기
         * */

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());

        // 자동정렬을 위해 우선순위큐 자료구조 선택
        pq = new PriorityQueue<>();

        // unf 배열 초기화
        unf = new int[V + 1];
        for (int i = 1; i < unf.length; i++) {
            unf[i] = i;
        }

        // 큐에 데이터 삽입 ( 자동정렬 )
        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            pq.add(new Edge(start, end, cost));
        }

        // usedEdge == 노드의 개수 - 1
        int usedEdge = 0;

        // 총 비용
        int result = 0;

        while (usedEdge < V - 1) {
            Edge curr = pq.poll();

            // 트리노드가 달라야만 union.
            // 트리노드가 같은 상태에서 union 해버리면 사이클이 생겨버림.
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
