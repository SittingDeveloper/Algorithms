package Algorithms.TopologySort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 줄_세우기 {

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

            /* 진입차수 배열에 인덱스 기준 값 증가  ( v : 연결되는 값 , A -> B ? B++ ) */
            D[v]++;
        }

        // 위상정렬 수행하기
        Queue<Integer> q = new LinkedList<>();
        for (int i = 1; i < D.length; i++) {
            // 진입 차수가 0인 값들을 Queue Add
            if (D[i] == 0) {
                q.add(i);
            }
        }

        while (!q.isEmpty()) {
            int curr = q.poll();

            System.out.print(curr + " ");

            /* Queue 에서 데이터를 poll 한 뒤 해당 노드를 탐색 결과 (sout)에 추가하고,
             해당 노드가 가리키는 노드의 진입 차수를 1씩 감소한다.
             이 때 진입 차수가 0이 된다면 그 노드를 Queue 에 Add 한다 */
            for (int next : Graph[curr]) {
                D[next]--;
                if (D[next] == 0) {
                    q.add(next);
                }
            }
        }

    }

}
