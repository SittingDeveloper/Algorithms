package Practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) {

        int stones[] = {2, 4, 5, 3, 2, 1, 4, 2, 5, 1};
        int k = 3;

        int left = 1;
        int right = 200000000;

        int max = 0;

        while(left <= right){
            int mid = (left + right) / 2;

            if(!cross(stones, k, mid)) {
                right = mid - 1;
            } else {
                left = mid + 1;
                max = Math.max(max, mid);
            }
        }

        System.out.println(left);

    }

    public static boolean cross(int[] stones, int k, int mid) {
        int cnt = 0;

        for (int stone : stones) {

            // 0보다 작아서 못 건너가면 cnt++
            if (stone - mid < 0) {
                cnt++;
            }

            // 0이상이면 건널 수 있음 -> cnt 0으로 다시 갱신
            else {
                cnt = 0;
            }

            // 못 건너서 쌓인 cnt 의 값이 건널 수 있는 최대 칸 수 k를 넘으면 현재 mid 값으로는 건널 수 없음
            if (cnt == k) {
                return false;
            }

        }

        return true;
    }


}