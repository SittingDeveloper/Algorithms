package BaekJoon;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class Code_17298 {

    // 17298
    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(bf.readLine());

        int A[] = new int[N];
        int ans[] = new int[N];

        StringTokenizer st = new StringTokenizer(bf.readLine());

        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        Stack<Integer> myStack = new Stack<>();

        myStack.push(0);

        for (int i = 1; i < N; i++) {

            while (!myStack.isEmpty() && A[myStack.peek()] < A[i]) {
                ans[myStack.pop()] = A[i];
            }
            myStack.push(i);
        }

        while (!myStack.empty()) {
            ans[myStack.pop()] = -1;
        }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        for (int i = 0; i < N; i++) {
            bw.write(ans[i] + " ");
        }

        bw.flush();
        bw.close();

    }

}
