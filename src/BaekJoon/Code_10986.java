package BaekJoon;

import java.util.Scanner;

public class Code_10986 {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        int N = scan.nextInt();
        int M = scan.nextInt();

        long Arr[] = new long[N];

        long SumArr[] = new long[N+1];

        long SameAnother[] = new long[M];

        long count = 0;

        for (int i = 0; i < N; i++) {
            Arr[i] = scan.nextInt();
        }

        for (int i = 1; i <= N; i++) {
            SumArr[i] = SumArr[i - 1] + Arr[i - 1];
        }

        for (int i = 1; i <= N; i++) {
            SumArr[i] = SumArr[i] % M;
            if (SumArr[i] == 0) {
                count++;
            }
            SameAnother[(int)SumArr[i]]++;
        }

        for (int i = 0; i < SameAnother.length; i++) {
            if (SameAnother[i] > 1) {
                count += (SameAnother[i] * (SameAnother[i] - 1) / 2);
            }
        }

        System.out.println(count);

    }

}
