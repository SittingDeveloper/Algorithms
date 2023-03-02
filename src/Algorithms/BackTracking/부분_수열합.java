package Algorithms.BackTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 1182
public class 부분_수열합 {

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

        // 부분 수열 합이 0이라면 S 자체가 포함되어있어서 - 1
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

        // 이번 인덱스 값 포함
        dfs(depth + 1, sum + arr[depth]);

        // 이번 인덱스값 포함 X
        dfs(depth + 1, sum);
    }

}
