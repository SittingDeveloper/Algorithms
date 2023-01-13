package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Code_1747 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int A[] = new int[10000001];

        for (int i = 2; i < A.length; i++) {
            A[i] = i;
        }

        for (int i = 2; i <= Math.sqrt(A.length); i++) {

            if (A[i] == 0) {
                continue;
            }

            for (int j = i + i; j < A.length; j = i + j) {
                A[j] = 0;
            }

        }

        int minResult = 0;
        int reverseNumber = 0;
        StringBuilder sb = new StringBuilder();

        for (int i = N; i < A.length; i++) {

            // 소수일 때
            if (A[i] != 0 ) {

                sb.append(A[i]);
                reverseNumber = Integer.parseInt(sb.reverse().toString());
                sb.setLength(0);

                if (A[i] == reverseNumber) {
                    minResult = reverseNumber;
                    break;
                }

            }

        }

        System.out.println(minResult);

    }

}
