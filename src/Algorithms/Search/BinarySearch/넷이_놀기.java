package Algorithms.Search.BinarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 2121
public class 넷이_놀기 {

    static int N;
    static ArrayList<Point> p_arr;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 점의 개수
        N = Integer.parseInt(br.readLine());

        // 구하려는 사각형의 가로와 세로
        st = new StringTokenizer(br.readLine());
        int width = Integer.parseInt(st.nextToken());
        int height = Integer.parseInt(st.nextToken());

        p_arr = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            p_arr.add(new Point(x, y));
        }

        Collections.sort(p_arr);

        int Rectangle = 0;
        for (int i = 0; i < N; i++) {
            int x = p_arr.get(i).x;
            int y = p_arr.get(i).y;
            int cnt = 0;

            if (binarySearch(x, y + height)) {
                cnt++;
            }
            if (binarySearch(x + width, y)) {
                cnt++;
            }
            if (binarySearch(x + width, y + height)) {
                cnt++;
            }

            if (cnt == 3) {
                Rectangle++;
            }
        }

        System.out.println(Rectangle);

    }

    static boolean binarySearch(int x, int y) {

        int leftIndex = 0;
        int rightIndex = N - 1;

        boolean flag = false;

        while (leftIndex <= rightIndex) {

            int midIndex = (leftIndex + rightIndex) / 2;

            // 찾으려는 값 (x,y) 값을 발견하면 true return
            if (p_arr.get(midIndex).x == x && p_arr.get(midIndex).y == y) {
                return true;
            }

            // (x,y) == (0, 3), midValue = (2 , 0)
            // 찾으려는 x값이 midIndex 의 x값 보다 크거나 ||
            // 찾으려난 x값과 midIndex 의 x값과 같고 &&
            // midIndex 의 y값이 찾으려난 y값 보다 작다면 (target > mid, left = mid + 1)
            if (p_arr.get(midIndex).x < x || (p_arr.get(midIndex).x == x && p_arr.get(midIndex).y < y)) {
                leftIndex = midIndex + 1;
            }

            // 반대의 경우 (target < mid, right = mid - 1)
            else {
                rightIndex = midIndex - 1;
            }

        }

        return flag;
    }

    static class Point implements Comparable<Point> {
        int x;
        int y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        // x값이 같을때는 y 오름차순 정렬, 기본적으로는 x를 기준으로 오름차순 정렬.
        @Override
        public int compareTo(Point o){
            if (this.x == o.x) {
                return this.y - o.y;
            }
            else {
                return this.x - o.x;
            }
        }

    }

}
