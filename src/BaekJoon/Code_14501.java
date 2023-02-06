package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Code_14501 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        int DP[] = new int[N + 2];

        int Day[] = new int[N + 1];

        int Pay[] = new int[N + 1];

        for (int i = 1; i < N + 1; i++) {
            st = new StringTokenizer(br.readLine());
            Day[i] = Integer.parseInt(st.nextToken());
            Pay[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = N; i > 0; i--) {

            // 퇴사 전 까지 끝낼 수 없는 일의 경우
            if (i + Day[i] > N + 1) {
                DP[i] = DP[i + 1];
            }

            else {
                DP[i] = Math.max(DP[i + 1], Pay[i] + DP[i + Day[i]]);
            }
        }

        System.out.println(DP[1]);

    }

}
