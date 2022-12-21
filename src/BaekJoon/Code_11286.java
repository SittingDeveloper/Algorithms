package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;

public class Code_11286 {

    // 11286 절댓값 힙, 우선순위 큐
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        ArrayList<Integer> arr = new ArrayList<>();

        PriorityQueue<Integer> myQueue = new PriorityQueue<>((o1, o2) -> {

            System.out.println(o1);
            System.out.println(o2);

            int first_abs = Math.abs(o1);
            int second_abs = Math.abs(o2);

            if (first_abs == second_abs)
                return o1 > o2 ? 1 : -1; // 절대 값이 같으면 음수 우선 정렬하기
            else
                return first_abs - second_abs; // 절대값을 기준으로 정렬하기

        });

        for (int i = 0; i < N; i++) {
            int request = Integer.parseInt(br.readLine());
            if (request == 0) {

                if(myQueue.isEmpty())
                    arr.add(0);
                else
                    arr.add(myQueue.poll());
            }
            else
                myQueue.add(request);
        }

        for (int i = 0; i < arr.size(); i++) {
            System.out.println(arr.get(i));
        }


    }

}
