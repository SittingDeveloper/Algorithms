package Algorithms.DataStructure.Queue;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

public class Card2 {

    // 2164
    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(bf.readLine());

        int Result = 0;

        Queue<Integer> queue = new LinkedList<>();

        for (int i = 1; i <= N; i++) {
            queue.add(i);
        }

        while (queue.size() > 1) {

            // 가장 위 카드를 버림
            queue.poll();

            // 가장 앞 카드를 가장 뒤에 삽입
            queue.add(queue.poll());

        }

        bw.write(queue.poll() +"");

        bw.flush();
        bw.close();

    }

}
