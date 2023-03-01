package Algorithms.Search.BinarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

// 2776
public class 암기왕 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int testCase = Integer.parseInt(br.readLine());

        for (int t = 0; t < testCase; t++) {

            // 수첩1
            int N = Integer.parseInt(br.readLine());
            ArrayList<Integer> arr = new ArrayList<>();
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                arr.add(Integer.parseInt(st.nextToken()));
            }

            Collections.sort(arr);

            // 수첩2
            int M = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < M; i++) {
                sb.append(BinarySearch(Integer.parseInt(st.nextToken()), arr) + "\n");
            }

        }

        System.out.println(sb);

    }

    static int BinarySearch(int target, ArrayList<Integer> arr) {

        int left = 0;
        int right = arr.size() - 1;
        boolean flag = false;

        while (left <= right) {

            int midIndex = (left + right) / 2;
            int midValue = arr.get(midIndex);

            if (midValue > target) {
                right = midIndex - 1;
            } else if (midValue < target) {
                left = midIndex + 1;
            } else {
                flag = true;
                break;
            }

        }

        if (flag == true) {
            return 1;
        } else {
            return 0;
        }

    }

}
