package Algorithms.Search.DFS;

public class Programmers_하노이의탑 {

    static int[][] answer;
    static int index = 0;

    public static void main(String[] args) {
        int n = 3;
        solution(n);

        for (int i = 0 ; i < answer.length; i++) {
            System.out.println(answer[i][0] + " " + answer[i][1]);
        }
    }

    static public int[][] solution(int n) {

        answer = new int[(int) Math.pow(2, n) - 1][2];
        // 하노이 탑의 최대 이동 횟수는 2^n - 1
        hanoi(n, 1, 2, 3);

        return answer;
    }

    static void hanoi(int n, int from, int other, int to) {
        if (n == 0) {
            return;
        }

        // n-1 개의 원판을 목적지가 아닌 곳(other)로 이동시킴
        hanoi(n - 1, from, to, other);

        // 마지막 원판을 목적지로 옮김
        answer[index][0] = from;

        // 마지막 원판을 목적지로 옮김
        answer[index++][1] = to;

        // 목적지가 아닌 곳(other)에 옮겨놓았던 원판들을 목적지로 옮김.
        hanoi(n - 1, other, from, to);

    }

}
