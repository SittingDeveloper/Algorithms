package Algorithms.Another;

public class Programmers_기사단원의_무기 {

    public int solution(int number, int limit, int power) {
        int answer = 0;

        /*
        각 기사에게는 1번부터 number까지 번호가 지정됨 ..
        기사들이 무기를 구매하려함 ..
        각 기사는 자신의 번호의 약수 개수에 해당하는 공격력을 가진 무기를 구매하려함 ..
        단, 공격력이 제한수치보다 크다면 고정된 공격력을 가지는 무기를 구매해야함 ..

        Ex, 15번으로 지정된 기사의 약수가 1, 3, 5, 15 총 "4"개임 ..
        그러므로 공격력 4짜리 무기를 구매해야함 ..
        But, 공격력 제한수치가 3이고
        제한수치를 초과할 경우 사용해야할 무기의 공격력이 2라면
        15번으로 지정된 기사는 공격력 2짜리 무기를 사용해야함 ..
        */

        int common[] = new int[number + 1];

        for (int i = 1; i <= number; i++) {

            int count = 0;

            // 시간초과
            /* for (int j = 1 ; j < i ; j++) {
                 if (i % j == 0) {
                     count++;
                 }
             }*/

            // 약수를 비약적으로 빠르게 구할 수 있는 알고리즘
            for (int j = 1; j * j <= i; j++) {
                if (j * j == i) {
                    count++;
                } else if (i % j == 0) {
                    count += 2;
                }
            }

            if (count > limit) {
                common[i] = power;
            } else {
                common[i] = count;
            }

        }

        for (int i = 1; i < common.length; i++) {
            answer += common[i];
            // System.out.print(common[i] + " ");
        }

        return answer;
    }

}
