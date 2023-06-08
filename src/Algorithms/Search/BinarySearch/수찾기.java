package Algorithms.Search.BinarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 1920
public class 수찾기 {

    static int arr[];

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        // 배열
        int N = Integer.parseInt(br.readLine());
        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        // 찾을 배열
        int M = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < M; i++) {
            int target = Integer.parseInt(st.nextToken());

            sb.append(binarySearch(target) + "\n");

        }
        System.out.println(sb);

    }

    static int binarySearch(int target) {

        int left = 0;
        int right = arr.length - 1; // 인덱스로 탐색하니까 -1 하지 빙신아

        while (left <= right) {

            int mid = (left + right) / 2;
            int midValue = arr[mid];

            if (midValue < target) {
                left = mid + 1;
            } else if (midValue > target) {
                right = mid - 1;
            } else {
                return 1; // 찾음
            }

        }

        return 0; // 못찾음
    }

}
