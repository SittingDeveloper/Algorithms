package Practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static String begin = "hit";
    static String target = "cog";
    static String words[] = {"hot", "dot", "dog", "lot", "log", "cog"};
    static boolean visited[];

    static int value = Integer.MAX_VALUE;

    public static void main(String[] args) {

        visited = new boolean[words.length];

        backTracking(begin, words, 0);

        if (value == Integer.MAX_VALUE) {
            System.out.println(0);
        } else {
            System.out.println(value);
        }

    }

    static void backTracking(String begin, String[] words, int depth) {

        // 1. 종료조건.
        // 같은 단어라면 Back (Return)
        if (begin.equals(target)) {
            value = Math.min(value, depth);
            return;
        }

        // 2. 순환
        for (int i = 0; i < words.length; i++) {
            if (visited[i] == false && check(begin, words[i])) {
                visited[i] = true;
                backTracking(words[i], words, depth + 1);
                visited[i] = false;
            }
        }

    }


    static boolean check(String begin, String target) {

        int count = 0;

        for (int i = 0 ; i < target.length() ; i++) {
            if (begin.charAt(i) == target.charAt(i)) {
                count++;
            }
        }

        if (count == begin.length() - 1) {
            return true;
        } else {
            return false;
        }

    }

}