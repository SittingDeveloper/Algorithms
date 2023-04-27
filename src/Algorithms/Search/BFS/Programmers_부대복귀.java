package Algorithms.Search.BFS;

import java.util.*;

public class Programmers_부대복귀 {

    public static void main(String[] args) {

        int n = 5;
        int roads[][] = {{1, 2}, {1, 4}, {2, 4}, {2, 5}, {4, 5}};
        int sources[] = {1, 3, 5};
        int destination = 5;


        Solution solution = new Solution();

        for (int temp : solution.solution(n, roads, sources, destination)) {
            System.out.print(temp + " ");
        }

    }

    static class Solution {

        ArrayList<Integer> Graph[];
        boolean Visited[];
        int depth[];

        public int[] solution(int n, int[][] roads, int[] sources, int destination) {
            int[] answer = new int[sources.length];

            Graph = new ArrayList[n + 1];
            for (int i = 0 ; i < Graph.length ; i++) {
                Graph[i] = new ArrayList<>();
            }
            Visited = new boolean[n+1];
            depth = new int[n+1];

            for (int i = 0 ; i < roads.length ; i++) {
                int u = roads[i][0];
                int v = roads[i][1];

                Graph[u].add(v);
                Graph[v].add(u);
            }

            // for (int i = 1 ; i < Graph.length ; i++) {
            //     System.out.println("Graph[" + i + "] : " + Graph[i]);
            // }

            bfs(destination);

            for (int i = 1 ; i < depth.length ; i++) {
                if (Visited[i] == false) {
                    depth[i] = -1;
                }
            }

            for (int i = 0 ; i < sources.length ; i++) {
                answer[i] = depth[sources[i]];
            }

            return answer;
        }

        void bfs (int destination) {

            Queue<Integer> q = new LinkedList<>();
            Visited[destination] = true;

            q.add(destination);

            while (!q.isEmpty()) {

                int cur = q.poll();
                // System.out.println(cur);

                for (int next : Graph[cur]) {
                    if (Visited[next] == false) {
                        Visited[next] = true;
                        q.add(next);
                        depth[next] = depth[cur] + 1;
                    }
                }

            }

        }

    }

}
