package Algorithms.DP.LIS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 11053
public class 가장_긴_증가하는_부분수열 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int A[] = new int[N];
        int dp[] = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0 ; i < N ; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        /*for (int i = 0 ; i < N ; i++) {
            dp[i] = 1;
            for (int j = 0 ; j < i ; j++) {
                if (A[j] < A[i] && dp[i] < dp[j] + 1) {
                    dp[i] = dp[j] + 1;
                }
            }
        }*/

        // 메모이제이션
        for (int i = 0 ; i < N ; i++) {
            dp[i] = 1;
            for (int j = 0 ; j < i ; j++) {
                if(A[j] < A[i] && dp[i] < dp[j] + 1) {
                    dp[i] = dp[j] + 1;
                }
            }
        }

        int max = 0;
        for (int i = 0 ; i < dp.length ; i++) {
            max = Math.max(dp[i], max);
        }

        System.out.println(max);

    }
}
