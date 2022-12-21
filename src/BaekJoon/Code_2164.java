package BaekJoon;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

public class Code_2164 {

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

            queue.poll();

            queue.add(queue.poll());

        }

        bw.write(queue.poll() +"");

        bw.flush();
        bw.close();

    }

}
