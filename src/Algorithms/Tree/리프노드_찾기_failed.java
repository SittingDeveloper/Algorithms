package Algorithms.Tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 1068
public class 리프노드_찾기_failed {

    static ArrayList<Integer> Graph[];
    static boolean Visited[];
    static int N, deleteNode;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        Graph = new ArrayList[N];
        for (int i = 0; i < N; i++) {
            Graph[i] = new ArrayList<>();
        }
        Visited = new boolean[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        /*int root = Integer.parseInt(st.nextToken());

        for (int i = 1; i < N; i++) {
            int node = Integer.parseInt(st.nextToken());
            Graph[i].add(node);
            Graph[node].add(i);
        }*/

        int root = 0;
        for (int i = 0; i < N; i++) {
            int node = Integer.parseInt(st.nextToken());
            if (node != -1) {
                Graph[i].add(node);
                Graph[node].add(i);
            } else
                root = i;
        }

        deleteNode = Integer.parseInt(br.readLine());

        if (deleteNode == 0) {
            System.out.println(0);
            System.exit(0);
        }

        /*for (int i = 0; i < Graph.length; i++) {
            System.out.println("Graph[" + i + "] : " + Graph[i]);
        }*/

        bfs(root);

    }

    static void bfs(int startNode) {

        Visited[startNode] = true;

        Queue<Integer> q = new LinkedList<>();
        q.add(startNode);

        int parent[] = new int[N + 1];

        int leafNode = 0;
//        ArrayList arr_leafNode = new ArrayList();

        while (!q.isEmpty()) {

            boolean is_leaf = false;
            // curr : parent
            int curr = q.poll();

            // next : child
            for (int next : Graph[curr]) {
                if (Visited[next] == false && next != deleteNode) {
                    q.add(next);
                    Visited[next] = true;
                    is_leaf = true;
                    parent[next] = curr;
                }
            }

            if (is_leaf == false) {
                leafNode++;
//                arr_leafNode.add(curr);
            }

        }

        System.out.println(leafNode);

        /*System.out.println("리프노드의 개수 : " + leafNode);
        System.out.println("리프노드 - ");
        for (int i = 0; i < arr_leafNode.size(); i++) {
            System.out.print(arr_leafNode.get(i) + " ");
        }*/
    }

}
