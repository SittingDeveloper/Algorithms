package Algorithms.DP;

public class Programmers_등굣길 {

    public static void main(String[] args) {

        // 열
        int m = 4;
        // 행
        int n = 4;
        // 못지나가는 위치
        int puddles[][] = {{3,2}, {2,4}};

        System.out.println(solution(m,n,puddles));

    }

    static public int solution(int m, int n, int[][] puddles) {

        int dp[][] = new int[n][m];
        for (int[] puddle : puddles) {
            dp[puddle[1] - 1][puddle[0] - 1] = -1;
        }

        dp[0][0] = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {

                // 연못 넘어가기
                if (dp[i][j] == -1) {
                    dp[i][j] = 0;
                    continue;
                }

                if (i != 0) {
                    dp[i][j] += dp[i - 1][j] % 1000000007;
                }

                if (j != 0) {
                    dp[i][j] += dp[i][j - 1] % 1000000007;
                }

            }
        }


         for (int i = 0 ; i < n ; i++) {
             for (int j = 0 ; j < m ; j++) {
                 System.out.printf("%2d" + " ", dp[i][j]);
             }
             System.out.println();
         }

        return dp[n - 1][m - 1] % 1000000007;
    }

}
