package Algorithms.Greedy;

import java.util.Arrays;

public class Programmers_구명보트 {

    public static void main(String[] args) {
        int people[] = {70,50,80,50};
        int limit = 100;
        System.out.println(solution(people, limit));
    }

    static public int solution(int[] people, int limit) {
        int answer = 0;
        Arrays.sort(people);

        int startIndex = 0;
        int endIndex = people.length - 1;

        while (startIndex <= endIndex) {

            if (people[startIndex] + people[endIndex] <= limit) {
                answer++;
                startIndex++;
                endIndex--;
            } else {
                answer++;
                endIndex--;
            }
        }

        return answer;
    }

}
