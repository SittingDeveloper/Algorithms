package Algorithms.BackTracking;

// 백트래킹 문제
// https://school.programmers.co.kr/learn/courses/30/lessons/87946
public class Programmers_피로도 {

    static int clear = 0;
    static boolean visited[];
    static int[][] dungeons = {{80, 20}, {50, 40}, {30, 10}};

    public static void main(String[] args) {

        int k = 80;

        visited = new boolean[dungeons.length];

        recursive(k, 0);

        System.out.println(clear);

    }

    static void recursive(int tired, int cnt) {
        for (int i = 0 ; i < dungeons.length ; i++) {
            if (visited[i] == false && dungeons[i][0] <= tired) {
                visited[i] = true;
                recursive(tired - dungeons[i][1], cnt+1);
                visited[i] = false;
            }
        }
        clear = Math.max(cnt, clear);
    }

}
