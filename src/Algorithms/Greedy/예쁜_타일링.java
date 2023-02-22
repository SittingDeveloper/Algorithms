package Algorithms.Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// 18230
public class 예쁜_타일링 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        PriorityQueue<Integer> pq1 = new PriorityQueue<>(Collections.reverseOrder());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < A; i++) {
            pq1.add(Integer.parseInt(st.nextToken()));
        }

        PriorityQueue<Integer> pq2 = new PriorityQueue<>(Collections.reverseOrder());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < B; i++) {
            pq2.add(Integer.parseInt(st.nextToken()));
        }

        int sum = 0;

        // 전체 타일의 크기가 홀수일 경우 2 * 1 하나는 반드시 사용
        if (N % 2 == 1) {
            sum += pq1.poll();
            N--;
        }

        while (N != 0) {

            int A_tile = 0;
            int B_tile = 0;
            int A_tile_a = 0;
            int A_tile_b = 0;

            if (pq1.size() >= 2) {
                A_tile_a = pq1.poll();
                A_tile_b = pq1.poll();
                A_tile = A_tile_a + A_tile_b;
            }

            if (!pq2.isEmpty()) {
                B_tile = pq2.poll();
            }

            if (A_tile > B_tile) {
                sum += A_tile;
                N -= 2;
                pq2.add(B_tile);
            } else {
                sum += B_tile;
                N -= 2;
                if (A_tile != 0) {
                    pq1.add(A_tile_a);
                    pq1.add(A_tile_b);
                }
            }

        }

        System.out.println(sum);

    }
}
