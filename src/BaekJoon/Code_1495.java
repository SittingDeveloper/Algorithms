package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Code_1495 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 곡 개수
        int N = Integer.parseInt(st.nextToken());

        // 시작 볼륨
        int S = Integer.parseInt(st.nextToken());

        // 볼륨의 맥스 사이즈
        int M = Integer.parseInt(st.nextToken());

        int result = -1;

        // 메모이제이션
        int d[] = new int[M + 1];

        // 각 곡이 시작하기 전에 줄 수 있는 볼륨의 차이 배열
        int V[] = new int[N + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            V[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < d.length; i++) {
            d[i] = -1;
        }

        d[S] = 0;

        // V : 볼륨배열
        for (int i = 1; i < V.length; i++) {

            // 바꾼 뒤 볼륨 저장할 ArrayList
            List<Integer> changer = new ArrayList<>();

            for (int j = 0; j < d.length; j++) {

                /* 다음 볼륨을 구하기 위해 현재 시점의 곡 순서에서 이전 시점에 불린 (곡d[x] = 현재시점 - 1) 의 정보를 통해 구한다 */
                if (d[j] == i - 1) {
                    int minus = j - V[i - 1];
                    int plus = j + V[i - 1];

                    if (minus >= 0) {
                        changer.add(minus);
                    }
                    if (plus <= M) {
                        changer.add(plus);
                    }
                }
            }

            for (int k : changer) {
                System.out.println(k);
                d[k] = i;
            }

        }

        // 최고값을 result 저장
        for (int i = 0; i < d.length; i++) {
            if (d[i] == N) {
                result = Math.max(i, result);
            }
        }

        System.out.println(result);

    }

}
