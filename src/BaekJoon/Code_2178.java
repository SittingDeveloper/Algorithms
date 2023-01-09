package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Code_2178 {

    static int dx[] = {-1, 1, 0, 0}; // 방향배열 - 상하
    static int dy[] = {0, 0, -1, 1}; // 방향배열 - 좌우

    static int N,M;
    static int Graph[][];
    static boolean Visited[][];

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        Graph = new int[N][M];

        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < M; j++) {
                Graph[i][j] = s.charAt(j) - '0';
            }
        }

        Visited = new boolean[N][M];

        Visited[0][0] = true;

        // bfs 탐색 시작
        bfs(0, 0);

        System.out.println(Graph[N-1][M-1]);
    }

    static void bfs(int x, int y) {

        Queue<int[]> q = new LinkedList<>();

        q.add(new int[]{x, y});

        while (q.isEmpty() == false) {

            int now[] = q.poll();
            int nowX = now[0];
            int nowY = now[1];

            for (int i = 0; i < 4; i++) {
                int nextX = nowX + dx[i];
                int nextY = nowY + dy[i];

                if (nextX < 0 || nextY < 0 || nextX >= N || nextY >= M)
                    continue;

                if (Visited[nextX][nextY] || Graph[nextX][nextY] == 0) {
                    continue;
                }
                q.add(new int[]{nextX, nextY});

                Graph[nextX][nextY] = Graph[nowX][nowY] + 1;

                Visited[nextX][nextY] = true;
            }
        }
    }

}
