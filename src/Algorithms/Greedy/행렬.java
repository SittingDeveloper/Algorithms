package Algorithms.Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 1080
public class 행렬 {

    static int Graph_A[][];
    static int Graph_B[][];

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int count = 0;

        // 계속되서 업데이트될 Graph_A
        Graph_A = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String curr = st.nextToken();
            for (int j = 0; j < M; j++) {
                Graph_A[i][j] = curr.charAt(j) - '0';
            }
        }

        // Graph_A와 비교되는, 변하지 않는 Graph_B
        Graph_B = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String curr = st.nextToken();
            for (int j = 0; j < M; j++) {
                Graph_B[i][j] = curr.charAt(j) - '0';
            }
        }

        for (int i = 0; i < N - 2; i++) {
            for (int j = 0; j < M - 2; j++) {

                // 하나라도 값이 맞지 않다면 3*3 행렬 뒤집기
                if (Graph_A[i][j] != Graph_B[i][j]) {

                    // +1회 변경이 일어났음
                    count++;

                    // 3 * 3 행렬로 비교,
                    int curr_x = i + 2;
                    int curr_y = j + 2;

                    for (int m = i; m <= curr_x; m++) {
                        for (int l = j; l <= curr_y; l++) {
                            if (Graph_A[m][l] == 1) {
                                Graph_A[m][l] = 0;
                            } else {
                                Graph_A[m][l] = 1;
                            }
                        }
                    }

                }

            }
        }

        boolean is_Same = true;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (Graph_A[i][j] != Graph_B[i][j]) {
                    is_Same = false;
                }
            }
        }

        if (is_Same) {
            System.out.println(count);
        } else {
            System.out.println("-1");
        }

    }

}
