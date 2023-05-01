package Algorithms.DataStructure.Stack;

import java.util.*;

public class Programmers_짝지어_제거하기 {

    public static void main(String[] args) {

        Solution solution = new Solution();
        String s = "baabaa";
        System.out.println(solution.solution(s));

    }

    static class Solution
    {

        public int solution(String s)
        {

            Stack<String> stack = new Stack<>();

            stack.push(s.charAt(0)+"");

            for (int i = 1 ; i < s.length() ; i++) {

                String cur = s.charAt(i) + "";

                if ( stack.size() > 0 && stack.peek().equals(cur)) {
                    stack.pop();
                } else {
                    stack.push(cur);
                }

            }

            if (stack.size() == 0 ) {
                return 1;
            } else {
                return 0;
            }

        }
    }

}
