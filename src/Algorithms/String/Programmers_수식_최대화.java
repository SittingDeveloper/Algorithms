package Algorithms.String;

import java.util.ArrayList;

public class Programmers_수식_최대화 {

    public static void main(String[] args) {

        long answer = 0;

        String expression = "100-200*300-500+20";
        String condition[][] = {{"*", "+", "-"}, {"*", "-", "+"}, {"-", "*", "+"}, {"-", "+", "*"}, {"+", "*", "-"}, {"+", "-", "*"}};

        ArrayList<String> list = new ArrayList<>();

        int start = 0;

        // 연산자, 숫자를 모두 나누어 list에 저장
        for (int i = 0 ; i < expression.length() ; i++) {
            if (expression.charAt(i) == '-' || expression.charAt(i) == '+' || expression.charAt(i) == '*') {
                list.add(expression.substring(start, i));
                list.add(expression.charAt(i)+"");
                start = i + 1;
            }
        }
        list.add(expression.substring(start));

        // 연산자 우선순위별로 계산
        for (int i = 0 ; i < condition.length ; i++ ){
            ArrayList<String> sub_list = new ArrayList<String>(list);

            for (int k = 0; k < 3; k++) {
                for (int j = 0; j < sub_list.size(); j++) {

                    if (condition[i][k].equals(sub_list.get(j))) {

                        // 연산자가 왔을 때 앞의 값과 뒤의 값을 계산하여 그 자리를 치환, 뒤의 값들을 제거
                        sub_list.set(j - 1, calc( sub_list.get(j - 1), sub_list.get(j), sub_list.get(j + 1) ));
                        sub_list.remove(j);
                        sub_list.remove(j);
                        j--;

                    }
                }
            }

            // 브루트포스
            answer = Math.max(answer, Math.abs(Long.parseLong(sub_list.get(0))));

        }

        System.out.println(answer);

    }

    private static String calc(String num1, String condition, String num2) {

        long n1 = Long.parseLong(num1);
        long n2 = Long.parseLong(num2);

        if (condition.equals("+")) {
            return n1 + n2 + "";
        } else if (condition.equals("-")) {
            return n1 - n2 + "";
        } else {
            return n1 * n2 + "";
        }

    }

}
