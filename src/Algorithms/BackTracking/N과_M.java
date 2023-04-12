package Algorithms.BackTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 전형적인 백트래킹 문제
// 15649
public class N과_M {

    static int N, M;

    static boolean Visited[];
    static int answer[];

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); // 1 ~ N 까지
        M = Integer.parseInt(st.nextToken()); // M개로 이루어진 수열

        Visited = new boolean[N + 1];
        answer = new int[M];

        dfs(0);

    }

    static private void dfs(int index) {

        if (index == M) {
            for (int val : answer) {
                System.out.print(val + " ");
            }
            System.out.println();
            return;
        }

        for (int i = 1; i <= N; i++) {

            // 이미 선택한 수 ( 가지 치기, 백트래킹 )
            if (Visited[i]) {
                continue;
            }

            Visited[i] = true;
            answer[index] = i;
            dfs(index + 1);
            Visited[i] = false;

        }

    }

}
