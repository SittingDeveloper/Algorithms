package Algorithms.Search.BFS;

import java.util.*;
import java.io.*;

// BFS 탐색
// https://school.programmers.co.kr/learn/courses/30/lessons/1844
public class Programmers_게임_맵_최단거리 {

    static boolean visited[][];
    static int maps[][] = {{1, 0, 1, 1, 1}, {1, 0, 1, 0, 1}, {1, 0, 1, 1, 1}, {1, 1, 1, 0, 1}, {0, 0, 0, 0, 1}};

    static int dx[] = {0, 0, 1, -1};
    static int dy[] = {1, -1, 0, 0};

    public static void main(String[] args) {

        int answer = 0;
        visited = new boolean[maps.length][maps[0].length];

        bfs(0, 0);

        if (maps[maps.length - 1][maps[0].length - 1] == 1) {
            answer = -1;
        } else {
            answer = maps[maps.length - 1][maps[0].length - 1];
        }

        System.out.println(answer);

    }

    static void bfs(int startX, int startY) {

        visited[startX][startY] = true;

        Queue<Move> q = new LinkedList<>();
        q.add(new Move(startX, startY));

        while(!q.isEmpty()) {

            Move now = q.poll();
            int nowX = now.x;
            int nowY = now.y;

            for (int i = 0 ; i < 4 ; i++) {

                int nextX = nowX + dx[i];
                int nextY = nowY + dy[i];

                if (nextX < 0 || nextY < 0 || nextX >= maps.length || nextY >= maps[0].length) {
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
        int x;
        int y;
        Move (int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

}
