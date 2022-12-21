package Algorithms.Sort.BubbleSort;

import java.io.IOException;
import java.util.Scanner;

public class SortNumbers {
    // Bubble Sort
    // 2750
    public static void main(String[] args) throws IOException {

        Scanner scan = new Scanner(System.in);

        int N = scan.nextInt();

        int A[] = new int[N];
        for (int i = 0; i < N; i++) {
            A[i] = scan.nextInt();
        }

        for (int i = 0; i < N - 1; i++) {
            for (int j = 0; j < N - 1 - i; j++) {
                if (A[j] > A[j + 1]) {
                    int temp = A[j];
                    A[j] = A[j + 1];
                    A[j + 1] = temp;
                }
            }
        }

        for (int i = 0; i < N; i++) {
            System.out.println(A[i]);

        }
    }
}
