package Algorithms.DataStructure.SumOfPart;

import java.util.Scanner;

public class AnotherSum {

    // 10986

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        int N = scan.nextInt();
        int M = scan.nextInt();

        // 포현 범위때문에 long 을 사용해야함

        // 일반 배열을 선언하는 Arr
        long Arr[] = new long[N];

        // 합배열을 넣을 SumArr
        long SumArr[] = new long[N+1];

        // 나머지가 같은 것들 인덱스 배열 cnt
        long SameAnother[] = new long[M];

        // result
        long count = 0;

        // 일반 배열을 먼저 입력
        for (int i = 0; i < N; i++) {
            Arr[i] = scan.nextInt();
        }

        // 일반 배열을 통하여 합배열을 만듦, 어차피 O(N)
        for (int i = 1; i <= N; i++) {
            SumArr[i] = SumArr[i - 1] + Arr[i - 1];
        }

        // 합배열에서 M의 나머지를 구하고 나머지가 0일 경우 count++, M 그 자체로 구간합이 같다는 의미
        for (int i = 1; i <= N; i++) {
            SumArr[i] = SumArr[i] % M;
            if (SumArr[i] == 0) {
                count++;
            }
            // 나머지가 같은 인덱스를 구함
            SameAnother[(int)SumArr[i]]++;
        }

         /*
         nCr 조합 공식을 사용해야함.
         N = 5, M =3 , arr = [ 1, 2, 3, 1, 2 ] 의 경우 합배열 % M(3)의 경우 1 0 0 1 0 발생.
         0이 3개, 1이 2개이므로 3C2, 2C2 (우측 2는 고정, 같은 2개의 원소를 뽑는거니까)
         3C2 : 3 * 2 * 1 / 2 * 1 = 3 ( 3! / 2! )
         2C2 : 2 * 1 / 2 * 1 =  1 ( 2! / 2! )
         합배열을 구하는 곳에서 % M == 0 인것들을 더한 3과
         위 공식에서 나온 3, 1 을 각각 더하여 3 + 3 + 1 = 7 성립
         nC2조합 코드 공식은 ( C[i] * (C[i] - 1) / 2 )
         */
        for (int i = 0; i < SameAnother.length; i++) {
            if (SameAnother[i] > 1) {
                count += (SameAnother[i] * (SameAnother[i] - 1) / 2);
            }
        }

        System.out.println(count);

    }

}
