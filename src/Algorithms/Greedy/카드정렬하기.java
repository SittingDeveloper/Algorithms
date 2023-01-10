package Algorithms.Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

// 1715
public class 카드정렬하기 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        // PriorityQueue 는 add 순서 상관없이 (작은 수) 부터 뺌
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int i = 0; i < N; i++) {
            pq.add(Integer.parseInt(br.readLine()));
        }

        int sum = 0;

        while (pq.size() != 1) {

            // 현재 카드의 개수가 가장 작은 묶음 2개를 선택해 합침
            int data1 = pq.remove();
            int data2 = pq.remove();
            sum += data1 + data2;

            // 합친 카드 묶음을 다시 전체 카드 묶음 속에 넣음
            pq.add(data1 + data2);

            // 위 과정을 카드 묶음이 1개만 남을 때 까지 반복함
        }

        System.out.println(sum);

    }

}
