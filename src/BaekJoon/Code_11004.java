package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Code_11004 {

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(bf.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(bf.readLine());

        int A[] = new int[N];
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        quickSort(A, 0, N - 1);

        System.out.println(A[K-1]);

    }

    static void swap(int A[], int i, int j) {
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }

    static void quickSort(int A[], int S, int E) {
        int pl = S;
        int pr = E;
        int pivot = A[(pl + pr) / 2];

        do {

            while (A[pl] < pivot) {
                pl++;
            }

            while (A[pr] > pivot) {
                pr--;
            }

            if (pl <= pr) {
                swap(A, pl++, pr--);
            }
        } while (pl <= pr);

        if (S < pr) {
            quickSort(A, S, pr);
        }

        if (pl < E) {
            quickSort(A, pl, E);
        }

    }

}
