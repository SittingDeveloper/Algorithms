package Algorithms.Sort.QuickSort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class NumberOfK {

    // 11004

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
        int pl = S;
        int pr = E;
        int pivot = A[(pl + pr) / 2]; // 피벗은 각 끝의 커서의 중간 값을 선택

        do {

            // A[pl] 값이 pivot 보다 큰 수 탐색
            while (A[pl] < pivot) {
                pl++;
            }

            // A[pr] 값이 pivot 보다 작은 수 탐색
            while (A[pr] > pivot) {
                pr--;
            }

            // pl <= pr : swap
            if (pl <= pr) {
                swap(A, pl++, pr--);
            }
        } while (pl <= pr);

        /* 정렬 끝난 후 나누어진 두개의 그룹에 데이터 수를 체크 */

        // S 가 pr 보다 작으면 그룹의 수가 1개 이상이기 때문에 다시 정렬
        if (S < pr) {
            quickSort(A, S, pr);
        }

        // pl이 E 보다 작으면 그룹의 수가 1개 이상이기 때문에 다시 정렬
        if (pl < E) {
            quickSort(A, pl, E);
        }

    }

}
