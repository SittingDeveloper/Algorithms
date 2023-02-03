package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Code_2206 {

    static int Graph[][];
    static int Distance[][];
    static boolean Visited[][][];

    static int N, M;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        if ( (N - 1 == 0) && (M - 1 == 0)) {
            System.out.println(1);
            System.exit(0);
        }

        Graph = new int[N][M];
        Distance = new int[N][M];

        Visited = new boolean[2][N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            String S_number = st.nextToken();
            int A[] = new int[S_number.length()];

            for (int k = 0; k < S_number.length(); k++) {
                A[k] = S_number.charAt(k) - '0';
            }

            for (int j = 0; j < M; j++) {
                Graph[i][j] = A[j];
            }
        }

        bfs(0, 0);

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                System.out.print(Distance[i][j] + " ");
            }
            System.out.println();
        }

    }

    static void bfs(int startX, int startY) {

        Visited[0][startX][startY] = true;

        Queue<int[]> q = new LinkedList<>();

        q.add(new int[]{startX, startY, 0});

        int dx[] = {0, 0, -1, 1};
        int dy[] = {-1, 1, 0, 0};

        while (!q.isEmpty()) {

            int curr[] = q.poll();

            for (int i = 0; i < 4; i++) {
                int x = curr[0] + dx[i];
                int y = curr[1] + dy[i];

                if (x < 0 || x >= N || y < 0 || y >= M) {
                    continue;
                }

                if (Graph[x][y] == 1) {

                    if (curr[2] == 0 && !Visited[1][x][y]) {

                        Visited[curr[2]][x][y] = true;
                        Distance[x][y] = Distance[curr[0]][curr[1]] + 1;
                        q.add(new int[]{x, y, 1});

                    }
                }

                else {
                    if (!Visited[curr[2]][x][y]) {

                        Visited[curr[2]][x][y] = true;
                        Distance[x][y] = Distance[curr[0]][curr[1]] + 1;
                        q.add(new int[]{x, y, curr[2]});

                    }
                }

                if (x == N - 1 && y == M - 1) {
                    System.out.println(Distance[x][y] + 1);
                    System.exit(0);
                }

            }

        }

        System.out.println(-1);

    }

}
