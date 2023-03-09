package Practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int clear = 0;
    static boolean visited[];
    static int[][] dungeons = {{80, 20}, {50, 40}, {30, 10}};

    public static void main(String[] args) {

        int k = 80;

        visited = new boolean[dungeons.length];

        recursive(k, 0);

        System.out.println(clear);

    }

    static void recursive(int tired, int depth) {

        for (int i = 0; i < dungeons.length; i++) {
            if (!visited[i] && dungeons[i][0] <= tired) {
                visited[i] = true;
                recursive(tired - dungeons[i][1], depth + 1);
                visited[i] = false;
            }
        }

        clear = Math.max(clear, depth);

    }

}