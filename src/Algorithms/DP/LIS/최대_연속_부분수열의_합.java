package Algorithms.DP.LIS;

public class 최대_연속_부분수열의_합 {

    public static void main(String[] args) {

        int Arr[] = {-3, 3, 5, -3, -7, 9, -2, 10, -5, -2};

        int cur_sum = Arr[0];
        int max = Arr[0];

        for (int i = 1 ; i < Arr.length ; i++) {
            if (cur_sum + Arr[i] < 0) {
                cur_sum = 0;
            } else {
                cur_sum += Arr[i];
            }

            max = Math.max(cur_sum, max);
        }

        System.out.println(max);

    }

}
