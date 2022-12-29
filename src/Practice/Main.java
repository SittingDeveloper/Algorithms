package Practice;

import java.io.*;
import java.util.*;

public class Main {

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

    // S, E는 각 커서의 시작점
    static void quickSort(int A[], int S, int E) {
        int leftPoint = S;
        int rightPoint = E;
        int pivot = A[(leftPoint + rightPoint) / 2]; // 피벗은 각 끝의 커서의 중간 값을 선택

        do {

            // A[leftPoint] 값이 pivot 보다 작다면 다음 인덱스 탐색 leftPoint ++
            while (A[leftPoint] < pivot) {
                leftPoint++;
            }

            // A[rightPoint] 값이 pivot 보다 크다면 다음 인덱스 탐색 rightPoint --
            while (A[rightPoint] > pivot) {
                rightPoint--;
            }

            // leftPoint <= rightPoint : swap
            if (leftPoint <= rightPoint) {
                swap(A, leftPoint++, rightPoint--);
            }

        } while (leftPoint <= rightPoint);

        /* 정렬 끝난 후 나누어진 두개의 그룹에 데이터 수를 체크 */

        // S 가 rightPoint 보다 작으면 그룹의 수가 1개 이상이기 때문에 다시 정렬
        if (S < rightPoint) {
            quickSort(A, S, rightPoint);
        }

        // leftPoint E 보다 작으면 그룹의 수가 1개 이상이기 때문에 다시 정렬
        if (leftPoint < E) {
            quickSort(A, leftPoint, E);
        }

    }

}