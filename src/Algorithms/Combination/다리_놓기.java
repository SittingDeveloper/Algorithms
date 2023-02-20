package Algorithms.Combination;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 1010
public class 다리_놓기 {

    static long dp[][];

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int testCase = Integer.parseInt(br.readLine());

        dp = new long[30][30];

        for (int i = 0; i < testCase; i++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());
            
            // 이 문제는 r n 위치 바뀌어있었음
            sb.append(dfs(r, n) + "\n");
        }

        System.out.println(sb);

    }

    static long dfs(int n, int r) {

        if (dp[n][r] != 0) {
            return dp[n][r];
        }

        // 메모이제이션 사용하려면 return dp[n][r] = dfs(...) 이렇게 return해야함
        if (n == r || r == 0) {
            return 1;
        } else {
            return dp[n][r] = dfs(n - 1, r - 1) + dfs(n - 1, r);
        }

    }


}
