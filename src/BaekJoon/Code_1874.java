package BaekJoon;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class Code_1874 {

    public static void main(String[] args) throws IOException {

        Scanner scan = new Scanner(System.in);

        int N = scan.nextInt();

        ArrayList<Character> Symbol = new ArrayList<>();

        int A[] = new int[N];
        for (int i = 0; i < N; i++) {
            A[i] = scan.nextInt();
        }

        boolean isPossible = true;

        Stack<Integer> stack = new Stack<>();

        int num = 1;

        for (int i = 0; i < A.length; i++) {

            int su = A[i];

            if (su >= num) {
                while (su >= num) {
                    stack.push(num++);
                    Symbol.add('+');
                }
                stack.pop();
                Symbol.add('-');
            }
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
