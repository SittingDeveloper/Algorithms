package Algorithms.DataStructure.Queue;

import java.util.Collections;
import java.util.PriorityQueue;

public class Programmers_야근지수 {

    static int works[] = {4, 3, 3};
    static int n = 4;

    public static void main(String[] args) {
        long answer = 0;

        // 우선순위 큐 채워 넣음
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 0 ; i < works.length ; i++) {
            pq.add(works[i]);
        }

        // 우선순위 큐 전체의 합이 n 보다 작은 경우 야근 X, 0 출력
        if (pq.stream().mapToInt(e -> e).sum() < n ){
            System.out.println(0);
            System.exit(0);
        }

        int temp = 0;
        while(n > 0) {
            temp = pq.poll();
            temp--;
            pq.add(temp);
            n--;
        }

        while (!pq.isEmpty()) {
            temp = pq.poll();
            answer += Math.pow(temp, 2);
        }

        System.out.println(answer);

    }
}
