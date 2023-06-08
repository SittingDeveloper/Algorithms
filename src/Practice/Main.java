package Practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long a = Long.parseLong(st.nextToken());
        long b = Long.parseLong(st.nextToken());

        long[] fibonacciNumbers = new long[10000];

        fibonacciNumbers[0] = 1;
        fibonacciNumbers[1] = 1;

        for (int i = 2; i < fibonacciNumbers.length; i++) {
            fibonacciNumbers[i] = fibonacciNumbers[i - 1] + fibonacciNumbers[i - 2];
        }

        long sum = 0;
        for (int i = 0; i < fibonacciNumbers.length; i++) {
            if (fibonacciNumbers[i] >= a && fibonacciNumbers[i] <= b) {
                sum += fibonacciNumbers[i];
            }
        }

        // Print the number of Fibonacci numbers and the sum.
        System.out.println(sum);
    }

}
