package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Code_11726 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        /*
         * D[N] = 2 * N 직사각형을 채우는 경우의 수
         * D[N]을 구하고 싶을 때 D[N-1] 이나 D[N-2]가 구해져 있다고 가정,
         * D[N]과 D[N-1] & D[N-2]의 인과관계를 생각하고 나서 D[N-1] & D[N-2]를 구하는 것이
         * 점화식을 쉽게 구하는 요령
         *
         * D[N-1] -> D[N] 으로 갈 수 있는 방법은 D[N-1] 에서 한 칸만 더 채운 형태.
         * D[N-2] -> D[N] 으로 갈 수 있는 방법은 가로로 눕히는 방법 하나. 세로로 세운 형태는 D[N-1]에 포함됨.
         *
         * 즉, 점화식은 D[N] = (D[N-1] + D[N-2])
         * D[N] : 길이 N으로 만들 수 있는 타일의 경우의 수
         * */

        long D[] = new long[N + 1];

        D[1] = 1;
        D[2] = 2;

        for (int i = 3; i < D.length; i++) {
            D[i] = (D[i - 1] + D[i - 2]) % 10007;
        }

        System.out.println(D[N]);

    }

}
