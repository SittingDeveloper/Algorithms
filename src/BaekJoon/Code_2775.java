package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Code_2775 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();


        for (int i = 0; i < testCase; i++) {
            int n = Integer.parseInt(br.readLine());
            int m = Integer.parseInt(br.readLine());
            int dp[][] = new int[n + 1][m + 1];

            for (int j = 0; j <= m; j++) {
                dp[0][j] = j;
            }

            for (int j = 1; j <= n; j++) {
                dp[j][1] = 1;
            }

            for (int j = 1; j <= n; j++) {
                for (int k = 2; k <= m; k++) {
                    dp[j][k] = dp[j - 1][k] + dp[j][k - 1];
                }
            }

            sb.append(dp[n][m] + "\n");

        }

        System.out.println(sb);

    }

}
