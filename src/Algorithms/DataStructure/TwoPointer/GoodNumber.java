package Algorithms.DataStructure.TwoPointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class GoodNumber {

    // 1253
    public static void main(String[] args) throws IOException {

        // 좋은수 Count
        int Good_Number = 0;
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        // 입력할 수의 개수
        int N = Integer.parseInt(bf.readLine());

        StringTokenizer st = new StringTokenizer(bf.readLine());

        // 입력받은 N개의 개수를 저장하는 배열, 수의 표현범위가 10억이라서 long 표현
        long A[] = new long[N];

        for (int i = 0; i < N; i++) {
            A[i] = Long.parseLong(st.nextToken());
        }

        // 배열 오름차순 정렬
        Arrays.sort(A);

        for (int k = 0; k < N; k++) {

            // find : 찾고자 하는 값
            long find = A[k];
            int i = 0 ;
            int j = A.length - 1;

            while (i < j) {

                if (A[i] + A[j] == find) {
                    // i, j가 k가 아닐 떄 결괏에 반영 및 while 종료
                    if (i != k && j != k) { // find 는 서로 다른 두 수의 합이어야 함
                        Good_Number++;
                        break;
                    }
                    // i, j가 k가 맞을 때 포인터 변경 및 계속 수행하기
                    else if (i == k) {
                        i++;
                    } else if (j == k) {
                        j--;
                    }
                } else if (A[i] + A[j] < find) {
                    i++;
                } else if (A[i] + A[j] > find) {
                    j--;
                }

            }

        }

        System.out.println(Good_Number);

    }

}
