package Algorithms.Search.DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 2023
public class 신기한_소수 {

    static int N;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        // 일의 자리 소수는 2, 3, 5, 7 이므로 4개의 수에서만 시작
        dfs(2, 1);
        dfs(3, 1);
        dfs(5, 1);
        dfs(7, 1);

    }

    static void dfs(int number, int jarisu) {

        // 소수 출력
        if (jarisu == N) {
            if (isPrime(number)) {
                System.out.println(number);
            }
            return;
        }

        // 1 ~ 9 반복
        for (int i = 1; i < 10; i++) {

            // 짝수라면 소수가 아니므로 더이상 탐색할 필요가 없음 ( 가지치기 )
            if (i % 2 == 0) {
                continue;
            }

            // 소수라면 재귀 함수로 자릿수를 늘림
            if (isPrime(number * 10 + i)) {
                dfs(number * 10 + i, jarisu + 1);
            }

        }
    }

    // 소수 구하기 함수
    static boolean isPrime(int num) {

        // 2 ~ 현재 수 / 2 반복하기
        for (int i = 2; i <= num / 2; i++) {

            // 소수가 아님
            if (num % i == 0) {
                return false;
            }

        }

        // 소수임
        return true;
    }

}
