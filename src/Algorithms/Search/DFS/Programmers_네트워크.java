package Algorithms.Search.DFS;

// 프로그래머스 네트워크, DFS 문제
// https://school.programmers.co.kr/learn/courses/30/lessons/43162
public class Programmers_네트워크 {

    static boolean visited[];
    static int n = 3;
    static int computers[][] = {{1, 1, 0}, {1, 1, 0}, {0, 0, 1}};

    public static void main(String[] args) {

        int answer = 0;

        visited = new boolean[n];

        for (int i = 0 ; i < n ; i++) {
            if (visited[i] == false) {
                answer++;
                dfs(i);
            }
        }

        System.out.println(answer);

    }

    static void dfs(int node){

        visited[node] = true;

//        System.out.println(node);

        for (int next = 0 ; next < n ; next++) {
            if (visited[next] == false && computers[node][next] == 1){
                dfs(next);
            }
        }

    }

}
