package Algorithms.Search.BFS;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

// 프로그래머스 문제, Depth 를 구해야 하는 문제였음
// https://school.programmers.co.kr/learn/courses/30/lessons/49189
public class Programmers_가장_먼_노드 {

    static ArrayList<Integer> Graph[];
    static boolean Visited[];
    static int Distance[];

    public static void main(String[] args) throws IOException {

        int[][] edge = {
                {3, 6},
                {4, 3},
                {3, 2},
                {1, 3},
                {1, 2},
                {2, 4},
                {5, 2}};

        int n = 6;

        Graph = new ArrayList[n + 1];
        Visited = new boolean[n + 1];
        Distance = new int[n + 1];

        for (int i = 1; i < Graph.length; i++) {
            Graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < edge.length; i++) {
            int curr[] = edge[i];

            Graph[curr[0]].add(curr[1]);
            Graph[curr[1]].add(curr[0]);
        }

        bfs(1);

        int maxSize = 0;
        for (int i = 1; i < Distance.length; i++) {
//            System.out.println("Node[" + i + "] : " + Distance[i]);
            maxSize = Math.max(Distance[i], maxSize);
        }

        int count = 0;
        for (int i = 1; i < Distance.length; i++) {
            if (Distance[i] == maxSize) {
                count++;
            }
        }

        System.out.println(count);

    }

    static void bfs (int node) {

        Visited[node] = true;

        Queue<Integer> q = new LinkedList<>();
        q.add(node);

        while (!q.isEmpty()) {
            int curr = q.poll();

            for (int next : Graph[curr]) {
                if (Visited[next] == false) {
                    Visited[next] = true;
                    q.add(next);
                    Distance[next] = Distance[curr] + 1;
                }
            }
        }

    }

}
