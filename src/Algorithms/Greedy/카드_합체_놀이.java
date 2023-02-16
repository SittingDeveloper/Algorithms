package Algorithms.Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// 15903
public class 카드_합체_놀이 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // N : 카드의 개수, M : 카드를 합치는 횟수
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        // 처음에 List 정렬했다가 틀림. 가장 앞 두 수만 필요하므로 PQ가 최적.
        PriorityQueue<Long> pq = new PriorityQueue<>();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            pq.add(Long.parseLong(st.nextToken()));
        }

        // 가장 앞 두 정수를 poll 하여 합한 뒤 pq에 두번 저장.
        for (int i = 0; i < M; i++) {
            long firstMin = pq.poll();
            long secondMin = pq.poll();
            long sum = firstMin + secondMin;
            pq.add(sum);
            pq.add(sum);
        }

        long totalSum = 0;
        while (!pq.isEmpty()) {
            totalSum += pq.poll();
        }

        System.out.println(totalSum);

    }

}
