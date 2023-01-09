package Algorithms.Search.BinarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 1920
public class 수찾기 {

    static int A[];
    static int tmp[];

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        A = new int[N];
        tmp = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        mergeSort(0, N - 1);

        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        // 이진탐색
        for (int i = 0; i < M; i++) {
            int target = Integer.parseInt(st.nextToken());

            int startIndex = 0;
            int endIndex = A.length - 1;
            boolean find = false;

            while (startIndex <= endIndex) {
                int midIndex = (startIndex + endIndex) / 2;
                int midValue = A[midIndex];

                if (midValue > target) {
                    endIndex = midIndex - 1;
                } else if (midValue < target) {
                    startIndex = midIndex + 1;
                } else {
                    find = true;
                    break;
                }
            }

            if (find == true) {
                System.out.println(1);
            } else
                System.out.println(0);

        }

    }

    static void mergeSort(int startPoint, int endPoint) {

        if (startPoint < endPoint) {

            int middlePoint = (startPoint + endPoint) / 2;
            mergeSort(startPoint, middlePoint);
            mergeSort(middlePoint + 1, endPoint);

            int firstPartition = startPoint;
            int secondPartition = middlePoint + 1;
            int idx = startPoint;

            while (firstPartition <= middlePoint || secondPartition <= endPoint) {

                if (secondPartition > endPoint || firstPartition <= middlePoint && A[firstPartition] < A[secondPartition]) {
                    tmp[idx++] = A[firstPartition++];
                } else
                    tmp[idx++] = A[secondPartition++];
            }

            for (int i = startPoint; i <= endPoint; i++) {
                A[i] = tmp[i];
            }

        }

    }

}
