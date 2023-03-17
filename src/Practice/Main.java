package Practice;

import java.util.*;

public class Main {

    static int numbers[] = {2, 3, 3, 5};
    public static void main(String[] args) {

        for (int n : solution(numbers)) {
            System.out.print(n + " ");
        }

    }

    static int[] solution(int[] numbers) {
        int[] answer = new int[numbers.length];

        for (int i = 0 ; i < numbers.length ; i++) {
            for (int j = i + 1; j < numbers.length ; j++) {
                if (numbers[j] > numbers[i]) {
                    answer[i] = numbers[j];
                    continue;
                }

            }
        }

        return answer;
    }



}