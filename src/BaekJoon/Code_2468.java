package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Code_2468 {

    static int Graph[][];
    static boolean Visited[][];
    static int N;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 결과값 저장
        int result = 0;
        int max = 0;
        N = Integer.parseInt(br.readLine());

        Graph = new int[N][N];

        // =======================================
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < N; j++) {
                Graph[i][j] = Integer.parseInt(st.nextToken());
                max = Math.max(Graph[i][j], max);
            }

        }

        for (int WaterFloor = 0; WaterFloor < max; WaterFloor++) {

            Visited = new boolean[N][N];
            int maxSafeArea = 0;

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (Graph[i][j] > WaterFloor && Visited[i][j] == false) {
                        bfs(i, j, WaterFloor);
                        maxSafeArea++;
                    }
                }
            }

            result = Math.max(maxSafeArea, result);

        }

        System.out.println(result);

    }

    static void bfs(int startX, int startY, int WaterFloor) {

        Visited[startX][startY] = true;

        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{startX, startY});

        int dx[] = {0, 0, -1, 1};
        int dy[] = {-1, 1, 0, 0};

        while (!q.isEmpty()) {

            int curr[] = q.poll();

            for (int i = 0; i < 4; i++) {
                int x = curr[0] + dx[i];
                int y = curr[1] + dy[i];
                if (x < 0 || x >= N || y < 0 || y >= N) {
                    continue;
                }
                if (Graph[x][y] > WaterFloor && Visited[x][y] == false) {
                    q.add(new int[]{x, y});
                    Visited[x][y] = true;
                }
            }
        }

    }

}
