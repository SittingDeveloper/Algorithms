package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class Code_1744 {

    // 1744
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

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

        while (plusPq.size() >= 2) {
            int data1 = plusPq.poll();
            int data2 = plusPq.poll();

            sum += data1 * data2;
        }
        if (!plusPq.isEmpty()) {
            sum += plusPq.poll();
        }

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
