package Practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int testCase = Integer.parseInt(br.readLine());

        for (int t = 0; t < testCase; t++) {

            int N = Integer.parseInt(br.readLine());
            int cost[] = new int[N];
            StringTokenizer st = new StringTokenizer(br.readLine());

            for (int i = 0; i < N; i++) {
                cost[i] = Integer.parseInt(st.nextToken());
            }

            int ans = 0;
            int max = cost[N - 1];

            for (int i = N - 1; i >= 0; i--) {
                if (cost[i] < max) {
                    ans += max - cost[i];
                } else {
                    max = Math.max(cost[i], max);
                }
            }

            sb.append(ans + "\n");

        }

        System.out.println(sb);

    }


}