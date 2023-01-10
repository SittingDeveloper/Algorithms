package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Code_11047 {

    /* Greedy Algorithm : 탐욕 알고리즘 (그리디)
    1. 해 선택     : 현재 상태에서 가장 최선이라고 생각되는 해를 선택한다
    2. 적절성 검사 : 현재 선택한 해가 전체 문제의 제약 조건에 벗어나지 않는지 검사한다
    3. 해 검사    : 현재까지 선택한 해 집합이 전체 문제를 해결할 수 있는지 검사한다. 전체 문제를 해결하지 못한다면 1로 돌아가 같은과정을 반복한다.
    */

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int A[] = new int[N];

        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(br.readLine());
        }

        int token = 0;
        for (int i = N - 1; i >= 0; i--) {
            if (A[i] <= K) {
                token += K / A[i];
                K = K % A[i];
            }
        }

        System.out.println(token);

    }

}
