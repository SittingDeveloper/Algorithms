package Algorithms.Combination;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//11050
public class 이항계수_구하기_1 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int DP[][] = new int[N + 1][N + 1];

        for (int i = 0; i < N + 1; i++) {
            DP[i][1] = i; // i 개 중에 1개 선택은 i개
            DP[i][0] = 1; // i 개 중에 1개도 선택하지 않는 경우의 수는 1개
            DP[i][i] = 1; // i 개에서 모두 선택하는 경우의 수는 1개
        }

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j < i; j++) {
                DP[i][j] = DP[i - 1][j - 1] + DP[i - 1][j];
            }
        }

        System.out.println(DP[N][K]);
    }

}
