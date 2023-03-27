package Algorithms.String;

public class Programmers_숫자_짝꿍 {

    public static void main(String[] args) {

        String X = "5525";
        String Y = "1255";

        Solution solution = new Solution();
        System.out.println(solution.solution(X, Y));

    }

    static class Solution {
        public String solution(String X, String Y) {

        /*
        두 정수 X, Y의 임의의 자리에서 공통으로 나타나는 정수 k들을 이용하여
        만들 수 있는 가장 큰 정수를 두 수의 짝꿍이라고 한다 ..

        짝꿍이 존재하지 않으면 -1 ..
        XY의 짝궁이 0으로만 구성되어 있다면 짝꿍은 0 ..
        */

            StringBuilder answer = new StringBuilder();

            int Xrr[] = new int[10];
            int Yrr[] = new int[10];

            for (int i = 0 ; i < X.length() ; i++) {
                Xrr[Integer.parseInt(String.valueOf(X.charAt(i)))]++;
            }

            for (int i = 0 ; i < Y.length() ; i++) {
                Yrr[Integer.parseInt(String.valueOf(Y.charAt(i)))]++;
            }

            for (int i = 9 ; i >= 0 ; i--) {
                while(Xrr[i] > 0 && Yrr[i] > 0) {
                    answer.append(i);

                    Xrr[i]--;
                    Yrr[i]--;
                }
            }

            if (answer.toString().equals("")) {
                return "-1";
            } else if (answer.toString().startsWith("0")) {
                return "0";
            } else {
                return answer.toString();
            }

        }
    }

}
