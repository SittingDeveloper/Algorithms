package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Code_1929 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        int A[] = new int[N + 1];

        // 크기가 N + 1 인 배열을 선언한 후 값은 각각의 인덱스값으로 채운다.
        // 1은 소수가 아니므로 2부터.
        for (int i = 2; i <= N; i++) {
            A[i] = i;
        }

        /* 에라토스테네스의 체
        N의 제곱근 까지만 탐색하는 이유 -
        N이 A*B 라고 가정했을 때, a와 b 모두 N의 제곱근 보다 클 수 없다.
        따라서 N의 제곱근까지만 확인해도 전체 범위의 소수를 판별할 수 있다.
        만약 16의 범위까지 소수를 구할 때 16 = 4 * 4 로 이뤄지면 16보다 작은 숫자는 항상 4보다 작은 약수를 갖게 된다는 뜻.
        따라서 4 까지만 확인하고 소수 판별을 진행하면 된다.
        */
        for (int i = 2; i <= Math.sqrt(N); i++) { // 제곱근까지만 수행하기

            // 배수 지우기
            for (int j = i + i; j <= N; j = j + i) {
                A[j] = 0;
            }

        }

        for (int i = M; i <= N; i++) {
            if (A[i] != 0) {
                sb.append(A[i]).append("\n");
            }
        }

        System.out.println(sb);

    }

}
