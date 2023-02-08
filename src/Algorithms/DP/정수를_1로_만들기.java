package Algorithms.DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 정수를_1로_만들기 {

    // 1463
    public static void main(String[] args) throws IOException {

        /*
         * 점화식
         * DP 문제라고 의심된다면 점화식 필수 !!!!
         * DP[i] = i, i 에서 1로 만드는데 걸리는 최소 연산 횟수
         *
         * 1. DP[i] = DP[i-1] + 1,
         * 2. if ([i] % 2 == 0) { min(DP[i], DP[i/2] + 1) }
         * 3. if ([i] % 3 == 0) { min(DP[i], DP[i/3] + 1) }
         *
         * */

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int X = Integer.parseInt(br.readLine());

        // 메모이제이션, DP에 각 인덱스에 맞는 최소 계산 횟수를 저장
        int DP[] = new int[X + 1];

        for (int i = 2; i <= X; i++) {

            // -1 연산을 한 경우
            DP[i] = DP[i - 1] + 1;

            // 2로 나누어 떨어질 때, -1 연산을 한 경우와 나누기 2 연산을 수행한 경우 중 적은 수를 선택
            if (i % 2 == 0) {
                DP[i] = Math.min(DP[i], DP[i / 2] + 1);
            }

            // 3으로 나누어 떨어 질 때, -1 연산을 한 경우와 나누기 3 연산을 수행한 경우 중 적은 수를 선택
            if (i % 3 == 0) {
                DP[i] = Math.min(DP[i], DP[i / 3] + 1);
            }

        }

        System.out.println(DP[X]);

    }

}
