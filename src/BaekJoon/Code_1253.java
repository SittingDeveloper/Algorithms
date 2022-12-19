package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Code_1253 {

    // 1253
    public static void main(String[] args) throws IOException {

        int Good_Number = 0;
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(bf.readLine());

        StringTokenizer st = new StringTokenizer(bf.readLine());

        long A[] = new long[N];

        for (int i = 0; i < N; i++) {
            A[i] = Long.parseLong(st.nextToken());
        }

        Arrays.sort(A);

        for (int k = 0; k < N; k++) {

            long find = A[k];
            int i = 0 ;
            int j = A.length - 1;

            while (i < j) {

                if (A[i] + A[j] == find) {
                    if (i != k && j != k) {
                        Good_Number++;
                        break;
                    }
                    else if (i == k) {
                        i++;
                    } else if (j == k) {
                        j--;
                    }
                } else if (A[i] + A[j] < find) {
                    i++;
                } else if (A[i] + A[j] > find) {
                    j--;
                }

            }

        }

        System.out.println(Good_Number);

    }

}
