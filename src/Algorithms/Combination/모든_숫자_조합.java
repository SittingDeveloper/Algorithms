package Algorithms.Combination;

import java.io.IOException;
import java.util.HashSet;

public class 모든_숫자_조합 {

    static HashSet<Integer> map = new HashSet<>();

    public static void main(String[] args) throws IOException {

        String numbers = "145";
        recursive("", numbers);

        for (int number : map) {
            System.out.print(number + " ");
        }

    }

    static void recursive(String comb, String other) {

        // 1. 종료 조건
        if (!comb.equals("")) {
            map.add(Integer.parseInt(comb));
        }

        // 2. 재귀 수행
        for (int i = 0 ; i < other.length() ; i++) {
            recursive(comb + other.charAt(i), other.substring(0, i) + other.substring(i + 1));
        }

    }

}
