package Algorithms.DP;

public class Programmers_정수_삼각형 {

    static int triangle[][] = {{7}, {3, 8}, {8, 1, 0}, {2, 7, 4, 4}, {4, 5, 2, 6, 5}};

    public static void main(String[] args) {

        System.out.println(solution(triangle));

    }

    static public int solution(int[][] triangle) {
        int[][] dp = new int[triangle.length][triangle.length];
        dp[0][0] = triangle[0][0];

        int answer = 0;

        for (int i = 1 ; i < triangle.length ; i++) {

            for (int j = 0 ; j < triangle.length ; j++) {

                // 가장 왼쪽 값
                if ( j == 0 ) {
                    dp[i][j] = dp[i-1][j] + triangle[i][j];
                }

                // 가장 오른쪽 값
                else if (i == j) {
                    dp[i][j] = dp[i-1][j-1] + triangle[i][j];
                }

                else if(i > j) {
                    dp[i][j] = Math.max(dp[i-1][j-1] + triangle[i][j], dp[i-1][j] + triangle[i][j]);
                }

            }
        }

        // Graph Test
        /*for (int i = 0 ; i < triangle.length ; i++) {
            for (int j = 0 ; j < triangle.length ; j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }*/

        for (int i = 0; i < triangle.length; i++) {
            answer = Math.max(answer, dp[triangle.length - 1][i]);
        }

        return answer;
    }

}
