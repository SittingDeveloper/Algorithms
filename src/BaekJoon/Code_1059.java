package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Code_1059 {

    static int S[];

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int L = Integer.parseInt(br.readLine());

        S = new int[L];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < S.length; i++) {
            S[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(S);

        int target = Integer.parseInt(br.readLine());

        for (int i = 0; i < S.length; i++) {
            if (S[i] == target) {
                System.out.println("0");
                System.exit(0);
            }
        }


        int targetIndex = binarySearch(target);

        int left_count = 0;

        int mine_count = 0;

        if (target < S[0]) {
            for (int i = 1; i < target ; i++) {
                for (int j = target; j < S[0]; j++) {
                    left_count++;
                }
            }
        } else {
            for (int i = S[targetIndex] + 1; i < target ; i++) {
                for (int j = target; j <= S[targetIndex + 1] - 1; j++) {
                    left_count++;
                }
            }
        }

        for (int i = target; i < S[targetIndex + 1] - 1; i++) {
            mine_count++;
        }

        int result = left_count + mine_count;
        System.out.println(result);

        /*
        *
        * int targetIndex = binarySearch(target);
        int left_count = (target - S[targetIndex] - 1) * (S[targetIndex + 1] - target);
        int right_count = (S[targetIndex + 1] - target) - 1;

        int result = left_count + right_count;
        if (result < 0) {
            result = 0;
        }
        System.out.println(result);
        * */

    }

    static int binarySearch(int target) {

        int startIndex = 0;
        int endIndex = S.length - 1;

        while (startIndex <= endIndex) {

            int midIndex = (startIndex + endIndex) / 2;
            int midValue = S[midIndex];

            if (midValue < target) {
                startIndex = midIndex + 1;
            } else {
                endIndex = midIndex - 1;
            }

        }

        return endIndex;

    }


}
