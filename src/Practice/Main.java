package Practice;

import java.util.*;

public class Main {

    public static void main(String[] args) {


    }

    public int solution(int n, int[][] results) {
        int answer = 0;
        ArrayList<Integer> Graph[] = new ArrayList[n];
        int D[] = new int[n];

        for (int i = 0; i < Graph.length; i++) {
            int u = results[i][0];
            int v = results[i][1];

            Graph[u].add(v);
        }

        return answer;
    }

}