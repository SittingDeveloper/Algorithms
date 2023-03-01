package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Code_1120 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        String A = st.nextToken();
        String B = st.nextToken();

        char A_arr[] = new char[A.length()];
        char B_arr[] = new char[B.length()];

        for (int i = 0; i < A_arr.length; i++) {
            A_arr[i] = A.charAt(i);
        }

        for (int i = 0; i < B_arr.length; i++) {
            B_arr[i] = B.charAt(i);
        }

        int diff = B_arr.length - A_arr.length;

        int min = Integer.MAX_VALUE;

        for (int i = 0; i <= diff; i++) {
            int count = 0;
            for (int j = 0; j < A_arr.length; j++) {
                if (A_arr[j] != B_arr[j + i]) {
                    count++;
                }
            }
            min = Math.min(count, min);
        }

        System.out.println(min);

    }

}
