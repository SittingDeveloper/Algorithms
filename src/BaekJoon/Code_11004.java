package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Code_11004 {

    /*
    * https://hyunipad.tistory.com/92
    * */

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
        int leftPoint = S;
        int rightPoint = E;
        int pivot = A[(leftPoint + rightPoint) / 2]; // 피벗은 각 끝의 커서의 중간 값을 선택

        do {

            while (A[leftPoint] < pivot) {
                leftPoint++;
            }

            while (A[rightPoint] > pivot) {
                rightPoint--;
            }

            if (leftPoint <= rightPoint) {
                swap(A, leftPoint++, rightPoint--);
            }

        } while (leftPoint <= rightPoint);

        if (S < rightPoint) {
            quickSort(A, S, rightPoint);
        }

        if (leftPoint < E) {
            quickSort(A, leftPoint, E);
        }

    }

}
