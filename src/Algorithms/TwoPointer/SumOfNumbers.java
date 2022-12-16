package Algorithms.TwoPointer;

import java.util.Scanner;

public class SumOfNumbers {

    // 2018
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        int N = scan.nextInt();

        int start_index = 1;
        int end_index = 1;

        // count를 1로 초기화 하는 이유는 입력한 수 (N이 15라면 숫자 15만 뽑을 경우의 수가 있기 때문에)
        int count = 1;
        int sum = 1;

        while (end_index != N) {
            // 합과 입력값이 같을 때의 경우의 수를 count++ 해준다
            if (sum == N) {
                count++;
                end_index++;
                sum += end_index;
            }

            // sum보다 N이 작다면 그 뒤에 수를 추가하기 위해 end_index++ 을 한 뒤 sum += end_index로 합을 더한다
            else if (sum < N) {
                end_index++;
                sum += end_index;
            }

            // sum이 N보다 크다면 앞에 수를 제거하기 위해 sum -= start_point를 하고 시작 지점을 한단계 올려주기 위해 start_index++
            else if (sum > N) {
                sum -= start_index;
                start_index++;
            }
        }

        System.out.println(count);
    }

}
