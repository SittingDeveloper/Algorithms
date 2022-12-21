package Algorithms.DataStructure.Stack;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class StackSequence {

    public static void main(String[] args) throws IOException {

        Scanner scan = new Scanner(System.in);

        // 수의 개수 입력
        int N = scan.nextInt();

        // + , - 기호를 담을 ArrayList
        ArrayList<Character> Symbol = new ArrayList<>();

        // 배열 저장
        int A[] = new int[N];
        for (int i = 0; i < N; i++) {
            A[i] = scan.nextInt();
        }

        boolean isPossible = true;

        // 스택 자료형 선언
        Stack<Integer> stack = new Stack<>();

        // 수열의 시작은 1부터라고 문제에 표기되어 있음
        int num = 1;

        for (int i = 0; i < A.length; i++) {

            int su = A[i];

            // 입력받은 수열이 num 보다 크다면 입력받은 수열이 나올 때 까지 num ++하면서 push
            if (su >= num) {
                while (su >= num) {
                    stack.push(num++);
                    Symbol.add('+');
                }
                // push가 끝났다면 pop을 한번 해줘야한다
                stack.pop();
                Symbol.add('-');
            }
            // 입력받은 수열이 num보다 작다면 pop 진행, pop한 값과 su가 같지 않다면 진행되지 않으므로 반복문 종료
            else {
                int n = stack.pop();
                if (n != su) {
                    System.out.println("NO");
                    isPossible = false;
                    break;
                }
                Symbol.add('-');
            }

        }

        if (isPossible) {
            for (int i = 0; i < Symbol.size(); i++) {
                System.out.println(Symbol.get(i));
            }
        }


    }

}
