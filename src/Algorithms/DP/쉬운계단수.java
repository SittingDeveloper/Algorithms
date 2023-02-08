package Algorithms.DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 10844
public class 쉬운계단수 {

    /*
     * 높이에 따른 점화식
     * D[i][0] = D[i-1][1] // H = 0
     * D[i][9] = D[i-1][8] // H = 9
     * D[i][H] = D[i-1][H-1] + D[i-1][H+1]
     * */

    static long mod = 1000000000;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        // N번째 자리 수 까지 올 수 있고 수는 0 ~9 까지 총 10개.
        // dp[자릿수][숫자]
        long dp[][] = new long[N + 1][10];

        // 첫 번째 자릿수는 오른쪽 맨 끝의 자릿수이므로 1개 밖에 없다.
        for (int i = 1; i < 10; i++) {
            dp[1][i] = 1;
        }

        // 두 자릿수 부터 계산 시작
        for (int i = 2; i <= N; i++) {

            for (int j = 0; j < 10; j++) {

                // 0일 경우 뒤에 1만 들어올 수 있다.
                if (j == 0) {
                    dp[i][0] = dp[i - 1][1] % mod;
                }

                // 9일 경우 앞에 8만 들어올 수 있다.
                else if (j == 9) {
                    dp[i][9] = dp[i - 1][8] % mod;
                }

                // 높이가 1~8이면 N-1에서 자신보다 한 단계 위 또는 아래 높이에서 올 수 있다.
                else {
                    dp[i][j] = (dp[i - 1][j - 1] + dp[i - 1][j + 1]) % mod;
                }
            }
        }

        long result = 0;
        for (int i = 0; i < 10; i++) {
            result += dp[N][i];
        }

        System.out.println(result % mod);

    }


}
