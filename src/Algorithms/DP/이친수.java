package Algorithms.DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 2193
public class 이친수 {

    public static void main(String[] args) throws IOException {

        /*
         * D[i][0] : i 길이에서 끝이 0으로 끝나는 이친수의 개수
         * D[i][1] : i 길이에서 끝이 1로 끝나는 이친수의 개수
         *
         * 점화식
         * D[i][0] = D[i - 1][1] + D[i - 1][0];
         * D[i][1] = D[i - 1][0];
         * */

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        long D[][] = new long[N + 1][2];

        // 이친수는 0으로 시작하지 않기 때문에 한자리 0으로 끝나는 이친수는 없음
        D[1][0] = 0;

        // 1은 이친수
        D[1][1] = 1;

        for (int i = 2; i <= N; i++) {

            // (i - 1 에서 0으로 끝) 개수 + (i - 1에서 1로 끝) 개수
            // Why ? 0은 이전 단계의 0과 1로 끝나는 모든 경우에 붙일 수 있음
            D[i][0] = D[i - 1][1] + D[i - 1][0];

            // ( i - 1에서 0으로 끝) 개수
            // Why ? 1은 이전 단계의 0으로 끝나는 경우만 붙일 수 있음
            D[i][1] = D[i - 1][0];

        }

        System.out.println(D[N][0] + D[N][1]);

    }

}
