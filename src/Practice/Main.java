package Practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String args[]) throws Exception {

        String s = "baabaa";

        int answer = 0;

        Stack<String> stack = new Stack<>();

        stack.push(s.charAt(0)+"");

        for (int i = 1 ; i < s.length() ; i++) {

            String cur = s.charAt(i) + "";

            if ( stack.size() > 0 && stack.peek().equals(cur)) {
                System.out.println("Eqauls");
                stack.pop();
            } else {
                System.out.println("Not Equals");
                stack.push(cur);
            }

        }

    }

}