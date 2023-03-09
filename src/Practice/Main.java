package Practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int maps[][] = {{1, 0, 1, 1, 1}, {1, 0, 1, 0, 1}, {1, 0, 1, 1, 1}, {1, 1, 1, 0, 1}, {0, 0, 0, 0, 1}};
    static boolean visited[][];
    static int dx[] = {0, 0, 1, -1};
    static int dy[] = {-1, 1, 0, 0};

    public static void main(String[] args) {

        visited = new boolean[maps.length][maps.length];

        visited[0][0] = true;
        bfs(0, 0);

        System.out.println(maps[maps.length - 1][maps.length - 1]);

    }

    static void bfs(int startX, int startY) {

        Queue<Move> q = new LinkedList<>();
        q.add(new Move(startX, startY));

        while (!q.isEmpty()) {

            Move now = q.poll();
            int nowX = now.x;
            int nowY = now.y;

            for (int i = 0 ; i < 4 ; i++) {
                int nextX = nowX + dx[i];
                int nextY = nowY + dy[i];

                if (nextX < 0 || nextX >= maps.length || nextY < 0 || nextY >= maps.length) {
                    continue;
                }

                if (visited[nextX][nextY] == false && maps[nextX][nextY] == 1) {
                    q.add(new Move(nextX, nextY));
                    maps[nextX][nextY] = maps[nowX][nowY] + 1;
                    visited[nextX][nextY] = true;
                }

            }

        }

    }

    static class Move {
        int x = 0;
        int y = 0;

        Move(int x, int y) {
            this.x =x;
            this.y = y;
        }
    }

}