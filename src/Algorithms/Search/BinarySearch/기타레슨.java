package Algorithms.Search.BinarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 기타레슨 {

    // 2343
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int A[] = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < A.length; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        // 최대길이 레슨
        int startIndex = 0;

        // 모든 레슨 길이의 합
        int endIndex = 0;

        for (int i = 0; i < N; i++) {
            if (startIndex < A[i])
                startIndex = A[i];
            endIndex += A[i];
        }

        while (startIndex <= endIndex) {

            // 중간 인덱스
            int middleIndex = (startIndex + endIndex) / 2;

            // 레슨 합
            int sum = 0;

            // 현재 사용한 블루레이 개수
            int count = 0;

            for (int i = 0; i < N; i++) {
                if (sum + A[i] > middleIndex) {
                    count++;
                    sum = 0;
                }
                sum += A[i];
            }

            if (sum != 0) {
                count++;
            }

            if (count > M)
                startIndex = middleIndex + 1;
            else
                endIndex = middleIndex - 1;

        }

        System.out.println(startIndex);

    }

}
