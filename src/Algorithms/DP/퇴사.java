package Algorithms.DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 14501
public class 퇴사 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 근무 일수
        int N = Integer.parseInt(br.readLine());

        // Memoization, 마지막 날을 위해 +1 X, +2
        int DP[] = new int[N + 2];

        // 일 수
        int Day[] = new int[N + 1];

        // 페이
        int Pay[] = new int[N + 1];

        for (int i = 1; i < N + 1; i++) {
            st = new StringTokenizer(br.readLine());
            Day[i] = Integer.parseInt(st.nextToken());
            Pay[i] = Integer.parseInt(st.nextToken());
        }

        /*  점화식
         *  DP[i] = i번 째 날 부터 퇴사날 까지 벌 수 있는 최대 수입, D[0] 부터가 아니라 D[N] 부터 계산해야함
         *
         *  오늘 시작되는 상담을 했을 때 퇴사일 까지 끝나지 않는 경우
         *  DP[i] = DP[i+1],
         *
         *  오늘 시작되는 상담을 했을 때 퇴사일 안에 끝나는 경우
         *  DP[i] = Math.max(DP[i+1], DP[i + Day[i]] + Pay[i]),
         *  */

        for (int i = N; i > 0; i--) {

            // 퇴사 전 까지 끝낼 수 없는 일의 경우
            if (i + Day[i] > N + 1) {
                DP[i] = DP[i + 1];
            }

            // 퇴사 전 까지 끝낼 수 있는 일의 경우
            else {
                // 메모이제이션, [다음날 페이]와 [오늘 페이 + 메모이제이션된 오늘자 까지 합산한 페이]를 비교해서 큰 값을 저장
                DP[i] = Math.max(DP[i + 1], Pay[i] + DP[i + Day[i]]);
            }
        }

        System.out.println(DP[1]);

    }

}