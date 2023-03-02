package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Code_1182 {

    static int arr[];
    static int N, S;
    static int answer;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); // 정수의 개수
        S = Integer.parseInt(st.nextToken()); // 구하려는 정수의 합
        arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        dfs(0, 0);

        if (S == 0) {
            System.out.println(answer - 1);
        } else {
            System.out.println(answer);
        }

    }

    static void dfs(int depth, int sum) {

        if (depth == N) {
            if (sum == S) {
                answer++;
            }
            return;
        }

        dfs(depth + 1, sum + arr[depth]);
        dfs(depth + 1, sum);
    }

}
