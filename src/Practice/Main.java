package Practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static HashSet<Integer> numberSet = new HashSet<>();
    public static void main(String[] args) throws IOException {
        String numbers = "145";

        recursive("", numbers);

        for (int n : numberSet) {
            System.out.print(n + " ");
        }

    }

    static void recursive(String comb, String other) {

        if (!comb.equals("")) {
            numberSet.add(Integer.parseInt(comb));
        }

        for (int i = 0; i < other.length(); i++) {
            recursive(comb + other.charAt(i), other.substring(0, i) + other.substring(i + 1));
        }

    }

}