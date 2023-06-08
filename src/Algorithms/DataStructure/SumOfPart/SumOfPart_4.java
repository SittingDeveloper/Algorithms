package Algorithms.DataStructure.SumOfPart;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 11659
public class SumOfPart_4 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int A[] = new int[N + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i < A.length; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        int S[] = new int[N + 1];
        S[1] = A[1];

        for (int i = 2; i < S.length; i++) {
            S[i] = S[i-1] + A[i];
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            sb.append(S[end] - S[start - 1] + "\n");
        }

        System.out.println(sb);

    }

}
