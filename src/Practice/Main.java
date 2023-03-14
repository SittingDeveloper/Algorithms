package Practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    // 열
    static int m = 4;
    // 행
    static int n = 4;

    // 못지나가는 위치
    static int puddles[][] = {{3,2}, {2,4}};

    public static void main(String[] args) {
        int dp[][] = new int[n][m];
        for (int[] puddle : puddles) {
            dp[puddle[1] - 1][puddle[0] - 1] = -1;
        }

        for (int i = 0 ; i < n ; i++) {
            for (int j = 0 ; j < m ; j++) {

                // 연못 넘어가기
                if(dp[i][j] == -1) {
                    dp[i][j] = 0;
                    continue;
                }

                // 가로 채우기
                if(i == 0) {
                    dp[i][j] = 1;
                }

                // 세로 채우기
                else if (j == 0) {
                    dp[i][j] = 1;
                }

                // 중간 빈 칸 채우기
                else {

                    if (dp[i-1][j] == -1) { // 위에 물차있는 경우
                        dp[i][j] = dp[i][j - 1] % 1000000007;
                    }
                    else if (dp[i][j-1] == -1) { // 왼쪽에 물차있는 경우
                        dp[i][j] = dp[i-1][j] % 1000000007;
                    }
                    else { // 위, 왼 모두 물이 없을 경우
                        dp[i][j] = dp[i-1][j] + dp[i][j-1] % 1000000007;
                    }

                }

            }
        }


         for (int i = 0 ; i < n ; i++) {
             for (int j = 0 ; j < m ; j++) {
                 System.out.printf("%2d" + " ", dp[i][j]);
             }
             System.out.println();
         }

        System.out.println(dp[n-1][m-1] % 1000000007);
    }

}