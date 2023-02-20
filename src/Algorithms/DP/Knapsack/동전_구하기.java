package Algorithms.DP.Knapsack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// 무한 냅색
public class 동전_구하기 {

    /*
    다음과 같이 같이 여러 단위의 동전들이 주어져 있을 때
    거스름돈으로 가장 적은 수의 동전으로 교환해주려면 어떻게 주면 되는가?
    각 단위의 동전은 ★무한정 쓸 수 있다

    - input -
    3
    1 2 5
    15

    - output -
    3
    why? 5, 5, 5 = 3

    */

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 동전의 개수
        int N = Integer.parseInt(br.readLine());

        // 동전의 value 가 작은 값부터 채워넣어야함
        PriorityQueue<Integer> coin = new PriorityQueue<>();

        // 코인 입력
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            coin.add(Integer.parseInt(st.nextToken()));
        }

        // 주어지는 금액
        int target = Integer.parseInt(br.readLine());

        int dp[] = new int[target + 1];

        while (!coin.isEmpty()) {

            int curCoin = coin.poll();
            for (int i = curCoin; i < dp.length; i++) {
                // 점화식
                dp[i] = dp[i - curCoin] + 1;
            }

        }

        System.out.println(dp[target]);


    }

}
