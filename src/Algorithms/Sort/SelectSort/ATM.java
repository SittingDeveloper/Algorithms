package Algorithms.Sort.SelectSort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ATM {

    // 11399
    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());

        // 기본 배열
        int A[] = new int[N];

        // 합배열
        int S[] = new int[N];

        // 한 줄에 숫자 다 입력받기
        StringTokenizer st = new StringTokenizer(bf.readLine());

        // 기본 배열에 st token 넣기
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        // index 시작은 1 부터
        for (int i = 1; i < N; i++) { // 삽입정렬

            // 삽입 인덱스 위치
            int insert_point = i;

            // 삽입 인덱스 값
            int insert_value = A[i];

            // 뒤에서부터 반복하기
            for (int j = i - 1; j >= 0; j--) {

                // 배열값이 삽입 인덱스 값보다 작다면 삽입 인덱스 위치를 배열값의 인덱스 위치보다 + 1을 해주고 break
                if (A[j] < A[i]) {
                    insert_point = j + 1;
                    break;
                }

                // 찾는 배열 인덱스 위치가 0이 되면 insert_point 를 0으로 초기화
                if (j == 0) {
                    insert_point = 0;
                }
            }

            // 삽입을 위해 삽입 위치에서 i 까지 데이터를 한 칸씩 뒤로 밀기
            for (int j = i; j > insert_point; j--) {
                A[j] = A[j - 1];
            }

            // 삽입 위치에 현재 데이터 삽입하기
            A[insert_point] = insert_value;

        }

        // 합배열 만들기 공식
        S[0] = A[0];
        for (int i = 1; i < N; i++) {
            S[i] = S[i - 1] + A[i];
        }

        // 합배열 총합 구하기
        int sum = 0;
        for (int i = 0; i < N; i++) {
            sum += S[i];
        }

        System.out.println(sum);

    }

}
