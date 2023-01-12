package Algorithms.numberTheory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 1456
public class 거의_소수 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long min = Long.parseLong(st.nextToken());
        long max = Long.parseLong(st.nextToken());

        long A[] = new long[10000001];

        for (int i = 2; i < A.length; i++) {
            A[i] = i;
        }

        for (int i = 2; i <= Math.sqrt(A.length); i++) {

            // 소수가 아니면 넘어감
            if (A[i] == 0) {
                continue;
            }

            for (int j = i + i; j < A.length; j = i + j) {
                A[j] = 0;
            }
        }

        int count = 0;
        for (int i = 2; i < 10000001; i++) {
            if (A[i] != 0) {

                // 현재 소수
                long curr = A[i];

                //곱셈이 long의 범위를 넘어갈 수 있어 이항 정리로 처리
                // A[i] <= max / curr
                while ((double) A[i] <= (double) max / (double) curr) {

                    // A[i] >= min / curr
                    if ((double)A[i] >= (double) min / (double) curr) {
                        count++;
                    }

                    curr *= A[i];

                }
            }
        }
        System.out.println(count);
    }

}
