package Algorithms.Brute_Force;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 3085
public class 사탕_게임 {

    static int N;
    static char Box[][];
    static int max = -1;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        Box = new char[N][N];

        // 박스 데이터 입력
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String word = st.nextToken();
            for (int j = 0; j < N; j++) {
                Box[i][j] = word.charAt(j);
            }
        }

        // 행
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N - 1; j++) {
                char swap = Box[i][j];
                Box[i][j] = Box[i][j + 1];
                Box[i][j + 1] = swap;

                // max 값 Search 시작
                max = Math.max(search(), max);

                // 원상복구
                swap = Box[i][j];
                Box[i][j] = Box[i][j + 1];
                Box[i][j + 1] = swap;

            }
        }

        // 열
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N - 1; j++) {
                char swap = Box[j][i];
                Box[j][i] = Box[j + 1][i];
                Box[j + 1][i] = swap;

                // max 값 Search 시작
                max = Math.max(search(), max);

                // 원상복구
                swap = Box[j][i];
                Box[j][i] = Box[j + 1][i];
                Box[j + 1][i] = swap;
            }
        }
        System.out.println(max);

    }

    static int search() {

        // 가로
        for (int i = 0; i < N; i++) {
            // cnt == 1 ? 하나도 안이어졌을때 먹을 수 있는 사탕은 해당 인덱스 하나
            int cnt = 1;
            for (int j = 0; j < N - 1; j++) {
                // 현재인덱스 + 다음 인덱스의 값이 같을 경우 먹을 수 있는 사탕의 개수 하나 늘어남
                if (Box[i][j] == Box[i][j + 1]) {
                    cnt++;
                }
                // 현재인덱스 + 다음 인덱스의 값이 다를 경우 연속해서 먹을 수 없음, 1 저장
                else {
                    cnt = 1;
                }
                max = Math.max(max, cnt);
            }
        }

        // 세로
        for (int i = 0; i < N; i++) {
            int cnt = 1;
            for (int j = 0; j < N - 1; j++) {
                if (Box[j][i] == Box[j + 1][i]) {
                    cnt++;
                } else {
                    cnt = 1;
                }
                max = Math.max(max, cnt);
            }
        }

        return max;

    }

}
