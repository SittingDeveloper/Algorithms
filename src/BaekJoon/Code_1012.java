package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Code_1012 {

    static int Graph[][];
    static boolean Visited[][];
    static int M, N;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        for (int testCase = 0; testCase < T; testCase++) {

            st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());

            Graph = new int[M][N];
            Visited = new boolean[M][N];

            for (int i = 0; i < K; i++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());

                Graph[x][y] = 1;
            }

            int earthWarm = 0;

            for (int i = 0; i < M; i++) {
                for (int j = 0; j < N; j++) {

                    // 간선이 있고 방문한 적이 없는 지 확인
                    if (Graph[i][j] == 1 && Visited[i][j] == false) {
                        bfs(i, j);
                        earthWarm++;
                    }

                }
            }

            sb.append(earthWarm + "\n");

        }
        System.out.println(sb);

    }

    static void bfs(int startX, int startY) {

        Visited[startX][startY] = true;

        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{startX, startY});

        // 상하좌우
        int dx[] = {0, 0, -1, 1};
        int dy[] = {-1, 1, 0, 0};

        while (!q.isEmpty()) {

            int[] curr = q.poll();

            for (int i = 0; i < 4; i++) {
                int x = curr[0] + dx[i];
                int y = curr[1] + dy[i];

                if (x < 0 || x >= M || y < 0 || y >= N) {
                    continue;
                }

                if (Graph[x][y] == 1 && Visited[x][y] == false) {
                    q.add(new int[]{x, y});
                    Visited[x][y] = true;
                }

            }

        }

    }

}
