package Algorithms.Search.BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 2468
public class 안전영역 {

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

            // max : 물의 높이를 100까지 구할 필요 없이 다 잠길 때 까지의 가장 큰 높이인 max 까지만
            for (int j = 0; j < N; j++) {
                Graph[i][j] = Integer.parseInt(st.nextToken());
                max = Math.max(Graph[i][j], max);
            }

        }
        // Graph 값 저장 및 max 구하는 부분

        // 물의 높이는 0 부터 시작 ( 비가 안내리는 경우 포함 )
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

            // Math.max(n1,n2) n1과 n2를 비교하여 큰 수를 저장
            result = Math.max(maxSafeArea, result);

        }

        System.out.println(result);

    }

    // 현재 물의 높이도 같이 파라미터로 넘겨줘야함
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
