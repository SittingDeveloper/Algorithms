package Algorithms.Greedy;

public class Programmers_가장큰수_구하기 {

    public static void main(String[] args) {
        String number = "1231234";
        int k = 3;

        System.out.println(solution(number, k));
    }

    static public String solution(String number, int k) {
        StringBuilder sb = new StringBuilder();
        int next = 0;
        int index = 0;
        /* 어떤 숫자에서 k개의 수를 제거할 때 얻을 수 있는 가장 큰 수 ?
        ex)
        1924에서 두 개를 제거하면
        19, 12, 14, 92, 94, 24 를 만들 수있다.
        이중 가장 큰 수는 94
        */

        for (int i = 0; i < number.length() - k; i++) {
            int max = 0;

            for (int j = index; j <= i + k; j++) {
                int current = number.charAt(j) - '0';

                if (max < current) {
                    max = current;
                    next = j;
                }

            }

            sb.append(max);
            index = next + 1;

        }

        return sb.toString();
    }

}
