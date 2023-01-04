package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Code_2751 {

    // https://yunmap.tistory.com/entry/%EC%95%8C%EA%B3%A0%EB%A6%AC%EC%A6%98-Java%EB%A1%9C-%EA%B5%AC%ED%98%84%ED%95%98%EB%8A%94-%EC%89%AC%EC%9A%B4-Merge-Sort-%EB%B3%91%ED%95%A9-%EC%A0%95%EB%A0%AC-%ED%95%A9%EB%B3%91-%EC%A0%95%EB%A0%AC


    public static int[] A;
    public static int[] tmp;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        A = new int[N];
        tmp = new int[N];

        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(br.readLine());
        }

        mergeSort(0, A.length - 1);

        for (int i = 0; i < N; i++) {
            sb.append(A[i]).append("\n");
        }

        System.out.println(sb);

    }

    static void mergeSort(int startPoint, int endPoint) {

        if (startPoint < endPoint) {

            int middlePoint = (startPoint + endPoint) / 2;
            mergeSort(startPoint, middlePoint);
            mergeSort(middlePoint + 1, endPoint);

            int firstPoint = startPoint;
            int secondPoint = middlePoint + 1;
            int idx = firstPoint;

            while (firstPoint <= middlePoint || secondPoint <= endPoint) {

                if (secondPoint > endPoint || (firstPoint <= middlePoint && A[firstPoint] < A[secondPoint])) {
                    tmp[idx++] = A[firstPoint++];
                } else {
                    tmp[idx++] = A[secondPoint++];
                }

            }

            for (int i = startPoint; i <= endPoint; i++) {
                A[i] = tmp[i];
            }

        }
    }

}
