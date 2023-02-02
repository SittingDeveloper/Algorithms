package Practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class prac {

    static class Node{
        int node;
        int value;

        Node(int node, int value) {
            this.node = node;
            this.value = value;
        }
    }

    static ArrayList<Node> Graph[];
    static ArrayList<Integer> Arr[];

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Graph = new ArrayList[4];
        Arr = new ArrayList[4];

        for (int i = 0; i < Graph.length; i++) {
            Graph[i] = new ArrayList<>();
            Arr[i] = new ArrayList<>();
        }

        int a = 0, b = 1;
        for (int i = 1; i < Graph.length; i++) {
//            Graph[i].add(new Node(a++, b++));
//            System.out.println(i);
            Arr[a++].add(b++);
        }

/*        for (int i = 1; i < Graph.length; i++) {
            System.out.println("Graph[" + i + "] : " + Graph[i].get(0).node + " " + Graph[i].get(0).value);
        }*/

        for (int i = 1; i < Arr.length; i++) {
            System.out.println("Arr[" + i + "] : " + Arr[i]);
        }


    }
}
