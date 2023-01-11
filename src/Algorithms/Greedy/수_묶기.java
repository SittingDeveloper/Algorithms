package Algorithms.Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class 수_묶기 {

    // 1744
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        /* 수의 집합을 1보다 큰 수, 1, 0, 음수 : 총 4가지 유형으로 나누어 저장한다. */
        PriorityQueue<Integer> plusPq = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> minusPq = new PriorityQueue<>();
        int one = 0;
        int zero = 0;

        for (int i = 0; i < N; i++) {

            int target = Integer.parseInt(br.readLine());

            if (target > 1) {
                plusPq.add(target);
            } else if (target < 0) {
                minusPq.add(target);
            } else if (target == 1) {
                one++;
            } else
                zero++;

        }

        int sum = 0;

        // 1보다 큰 수의 집합을 정렬해 최댓값부터 차례대로 곱한 후 더한다.
        // 원소의 개수가 홀 수 일 때 마지막 남은 수는 그대로 더한다.
        while (plusPq.size() >= 2) {
            int data1 = plusPq.poll();
            int data2 = plusPq.poll();

            sum += data1 * data2;
        }
        if (!plusPq.isEmpty()) {
            sum += plusPq.poll();
        }

        // 음수의 집합을 정렬해 최솟값부터 차례대로 곱한 후 더한다.
        // 원소의 개수가 홀 수 일때 수열에 0이 있다면 1개 남는 음수를 0과 곱해 0을 만들고 수열에 0이 없다면 그대로 더한다.
        while (minusPq.size() >= 2) {
            int data1 = minusPq.poll();
            int data2 = minusPq.poll();

            sum += data1 * data2;
        }

        if (!minusPq.isEmpty() && zero == 0) {
            sum += minusPq.poll();
        }

        System.out.println(sum + one);

    }

}
