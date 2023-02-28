package Algorithms.Search.BinarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class 캠프가는_영식 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 버스 총 개수
        int T = Integer.parseInt(st.nextToken()); // 인물 도착 시간

        ArrayList<Integer> arr = new ArrayList<>();

        // 모든 배차 간격을 배열에 집어넣음
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int S = Integer.parseInt(st.nextToken()); // 버스 첫 차
            int I = Integer.parseInt(st.nextToken()); // 버스 간격
            int C = Integer.parseInt(st.nextToken()); // 버스 배차 개수
            for (int j = 0; j < C; j++) {
                arr.add(S + I * j);
            }
        }

        Collections.sort(arr);

        int min = 0;

        if (T > arr.get(arr.size() - 1)) {
            System.out.println(-1);
            System.exit(0);
        } else if (T <= arr.get(0) - T) {
            System.out.println(arr.get(0) - T);
            System.exit(0);
        } else {
            int startIndex = 0;
            int endIndex = arr.size() - 1;

            while (startIndex <= endIndex) {

                int midIndex = (startIndex + endIndex) / 2;
                int midValue = arr.get(midIndex);

                if (T < midValue) {
                    endIndex = midIndex - 1;
                } else if (T > midValue) {
                    startIndex = midIndex + 1;
                } else {
                    System.out.println(0);
                    System.exit(0);
                }

            }
            min = arr.get(startIndex) - T;
        }

        System.out.println(min);

    }

}
