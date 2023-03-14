package Algorithms.DP;

public class Programmers_N으로_표현 {

    static int min = Integer.MAX_VALUE;
    static int N = 5;
    static int number = 12;

    public static void main(String[] args) {


        System.out.println(solution(N, number));

    }

    static public int solution(int N, int number) {
        int answer = 0;

        // depth, sum
        dfs(0, 0);

        if (min == Integer.MAX_VALUE) {
            return -1;
        }

        return min;
    }

    static public void dfs(int depth, int sum) {
        if (depth > 8) {
            return;
        }

        if (sum == number) {
            min = Math.min(min, depth);
            return;
        }

        int temp = 0;
        for (int i = 0; i < 8; i++) {
            if (depth + i < 8) {
                temp = temp * 10 + N;
                dfs(depth + i + 1, sum + temp);
                dfs(depth + i + 1, sum - temp);
                dfs(depth + i + 1, sum / temp);
                dfs(depth + i + 1, sum * temp);
            }
        }

    }


}
