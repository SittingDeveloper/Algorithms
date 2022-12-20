package BaekJoon;

import Algorithms.SlidingWindow.FindMinValue;

import java.io.*;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Code_11003 {

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(bf.readLine());

        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());

        Deque<Node> myDeque = new LinkedList<>();

        st = new StringTokenizer(bf.readLine());

        for (int i = 0; i < N; i++) {
            int now = Integer.parseInt(st.nextToken());

            while (!myDeque.isEmpty() && myDeque.getLast().value > now) {
                myDeque.removeLast();
            }

            myDeque.addLast(new Node(now, i));

            if (myDeque.getFirst().index <= i - L) {
                myDeque.removeFirst();
            }

            bw.write(myDeque.getFirst().value + " ");

        }
        bw.flush();
        bw.close();
    }

    static class Node {

        int value;
        int index;

        Node(int value, int index) {
            this.value = value;
            this.index = index;
        }

    }

}
