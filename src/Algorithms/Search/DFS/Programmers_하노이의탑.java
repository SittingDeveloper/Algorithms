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


    /*
     * 기둥 A(from)에서 N개의 원반을 기둥 B(other)를 이용하여 기둥 C(to)로 옮기는 알고리즘.
     * N: 원판의 개수
     * from: 출발지 - A
     * other: 출발지도 목적지도 아닌 곳 - B
     * to: 목적지 - C
     *  1. 기둥 A에서 N-1개의 원반을 기둥 C를 이용하여 기동 B로 옮긴다.
     *  2. 기둥 A에서 1개의 원반을 기둥 C로 옮긴다.
     *  3. 기둥 B에서 N-1개의 원반을 기둥 A를 이용해서 기둥 C로 옮긴다.
     */
    static void hanoi(int n, int from, int other, int to) {
        if (n == 0) {
            return;
        }

        // n-1 개의 원판을 목적지가 아닌 곳(other)로 이동시킴 (두 번째 칸, 중간 지점)
        hanoi(n - 1, from, to, other);

        // 마지막 원판을 목적지로 옮김 ( move from -> to )
        answer[index][0] = from;
        answer[index][1] = to;

        index++;

        // 목적지가 아닌 곳(other)에 옮겨놓았던 원판들을 목적지로 옮김.
        // (두번째 칸에 존재하는 N-1개의 원판을 세번째 칸으로 이동 )
        hanoi(n - 1, other, from, to);

    }

    /*
    *    1                                                                   1
    *    2      ->            ->      1   ->    1       ->            ->     2
    *    3           3  2  1       3  2         2   3        1  2  3         3
    * */

}
