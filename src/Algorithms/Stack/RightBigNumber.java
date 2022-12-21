package Algorithms.Stack;

import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

public class RightBigNumber {

    // 17298
    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        // 수의 개수
        int N = Integer.parseInt(bf.readLine());

        int A[] = new int[N]; // 수열 배열
        int ans[] = new int[N]; // 정답 배열

        StringTokenizer st = new StringTokenizer(bf.readLine());

        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        Stack<Integer> myStack = new Stack<>();

        // 처음에는 항상 스택이 비어있으므로 최초 값을 Push
        myStack.push(0);

        for (int i = 1; i < N; i++) {

            /*
             * !myStack.isEmpty() : 스택이 비어있지 않다
             * A[myStack.peek()] < A[i] : 현재 수열이 스택 top 인덱스가 가리키는 수열보다 큰 경우 (오른쪽에 있는 경우)
             * */
            while (!myStack.isEmpty() && A[myStack.peek()] < A[i]) {
                // 정답 배열에 오큰수를 현재 수열로 저장
                ans[myStack.pop()] = A[i];
            }
            // 신규 데이터 Push
            myStack.push(i);
        }

        while (!myStack.empty()) {
            // 반복문을 다 돌고 나왔는데 스택이 비어있지 않다면 빌 때 까지
            ans[myStack.pop()] = -1;
            // 스택에 쌓인 index 에 -1을 넣음
        }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        for (int i = 0; i < N; i++) {
            bw.write(ans[i] + " ");
        }

        bw.flush();
        bw.close();

    }

}
