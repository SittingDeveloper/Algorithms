package Algorithms.DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// 1003
public class 빠른_피보나치_함수 {

    static int dp[];

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int testCase = Integer.parseInt(br.readLine());

        for (int i = 0; i < testCase; i++) {
            int N = Integer.parseInt(br.readLine());

            if (N == 0) {
                sb.append("1 0\n");
                continue;
            }

            dp = new int[N + 1];
            Arrays.fill(dp, -1);
            dp[0] = 0;
            dp[1] = 1;

            // N-1 : 0 호출 횟수 , N : 1 호출 횟수
            sb.append(fibonacci(N - 1) + " " + fibonacci(N) + "\n");

        }

        System.out.println(sb);

    }

    static int fibonacci(int n) {

        if (dp[n] != -1) {
            return dp[n];
        }

        return dp[n] = fibonacci(n - 1) + fibonacci(n - 2);

    }

}
