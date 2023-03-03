package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 개구리1
public class Code_15566 {

    static int N, M;
    static int Lotus[];
    static int Frog[][];
    static int Like[][];
    static int Bridge[][];

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 연꽃 개수
        N = Integer.parseInt(st.nextToken());

        // 연꽃 사이를 연결하는 다리 개수
        M = Integer.parseInt(st.nextToken());

        Frog = new int[N + 1][4];
        Like = new int[N + 1][2];
        Bridge = new int[M][3];

        // 각 개구리의 흥미
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            int food = Integer.parseInt(st.nextToken());
            int hobby = Integer.parseInt(st.nextToken());
            int family = Integer.parseInt(st.nextToken());
            int philosophy = Integer.parseInt(st.nextToken());

            Frog[i][0] = food;
            Frog[i][1] = hobby;
            Frog[i][2] = family;
            Frog[i][3] = philosophy;
        }

        // 개구리들이 각각 선호하는 다리
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            Like[i][0] = A;
            Like[i][1] = B;
        }

        // 연꽃잎을 잇는 다리의 정보
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int Topic = Integer.parseInt(st.nextToken());

            Bridge[i][0] = A;
            Bridge[i][1] = B;
            Bridge[i][2] = Topic;
        }

        Lotus = new int[N + 1];

        dfs(1);

        System.out.println("NO");

    }

    static void dfs(int Location) {

        if (Location > N) {
            for (int i = 0; i < M; i++) {
                //왼쪽 연꽃
                int num1 = Bridge[i][0];
                // 오른쪽 연꽃
                int num2 = Bridge[i][1];
                // 대화 주제
                int topic = Bridge[i][2];

                int frog1 = Lotus[num1];
                int frog2 = Lotus[num2];

                // 선호하는 자리가 같을 경우, 즉 하나일 경우 반드시 그 자리에 위치시켜야하므로 계산 X
                if (Frog[frog1][topic - 1] != Frog[frog2][topic - 1]) {
                    return;
                }
            }

            StringBuilder sb = new StringBuilder();
            sb.append("YES" + "\n");

            for (int i = 1; i <= N; i++) {
                sb.append(Lotus[i] + " ");
            }

            System.out.println(sb);
            System.exit(0);
        } else {
            for (int i = 0; i < 2; i++) {
                if (Lotus[Like[Location][i]] == 0) {
                    Lotus[Like[Location][i]] = Location;
                    dfs(Location + 1);
                    Lotus[Like[Location][i]] = 0;
                }
            }
        }

    }

}