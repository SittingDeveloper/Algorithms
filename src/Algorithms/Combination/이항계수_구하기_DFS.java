package Algorithms.Combination;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 11050 DFS Version
public class 이항계수_구하기_DFS {

    static int dp[][] = new int[35][35];

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());

        System.out.println(DFS(n, r));

    }

    static private int DFS(int n, int r) {

        if (dp[n][r] != 0) {
            return dp[n][r];
        }

        if (n == r || r == 0) {
            return 1;
        } else {
            return dp[n][r] = DFS(n - 1, r - 1) + DFS(n - 1, r);
        }

    }

}
