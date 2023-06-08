package Algorithms.Search.DFS;

import java.util.ArrayList;

public class Programmers_모음사전 {

    public static void main(String[] args) {

        String word = "AAAAE";

        Solution solution = new Solution();
        System.out.println(solution.solution(word));

    }

    static class Solution {

        String arr[]; // A E I O U
        ArrayList<String> list; // 만들어지는 문자열을 담을 리스트

        public int solution(String word) {
            int answer = 0;

            arr = new String[]{"A", "E", "I", "O", "U"};
            list = new ArrayList<>();

            recursive("", 0);

            for (int i = 0 ; i < list.size() ; i++) {

                if (list.get(i).equals(word)) {
                    answer = i;
                    break;
                }

            }

            return answer;
        }

        public void recursive(String str, int depth) {

            list.add(str);

            if (depth == 5) {
                return;
            }

            for (int i = 0 ; i < arr.length ; i++) {
                recursive(str + arr[i], depth + 1);
            }

        }

    }

}
