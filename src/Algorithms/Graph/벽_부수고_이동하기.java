package Algorithms.Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 벽_부수고_이동하기 {

    static int Graph[][];
    static int Distance[][];
    static boolean Visited[][][];

    static int N, M;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        // 0 0 입력 예외처리
        if ( (N - 1 == 0) && (M - 1 == 0)) {
            System.out.println(1);
            System.exit(0);
        }

        Graph = new int[N][M];
        Distance = new int[N][M];

        // [0] = 파괴한적없음 , [1] = 파괴한적있음
        Visited = new boolean[2][N][M];

        // 그래프 입력
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

        // Graph[0][0] 부터 탐색 시작
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

        // 큐의 마지막 : Crash 여부
        q.add(new int[]{startX, startY, 0});

        // 상하좌우 이동
        int dx[] = {0, 0, -1, 1};
        int dy[] = {-1, 1, 0, 0};

        while (!q.isEmpty()) {

            // curr[0] : x좌표 , curr[1] : y좌표, curr[2] : is_Crash
            int curr[] = q.poll();

            for (int i = 0; i < 4; i++) {
                int x = curr[0] + dx[i];
                int y = curr[1] + dy[i];

                if (x < 0 || x >= N || y < 0 || y >= M) {
                    continue;
                }

                // 벽이 있을 경우
                if (Graph[x][y] == 1) {

                    // 벽을 부수지 않았고, 그 벽을 방문한 적이 없음
                    if (curr[2] == 0 && !Visited[1][x][y]) {

                        Visited[curr[2]][x][y] = true; // 방문 처리
                        Distance[x][y] = Distance[curr[0]][curr[1]] + 1; // Distance 거리 배열 값 입력
                        q.add(new int[]{x, y, 1}); // 벽을 부순 후 큐에 넣음 , 이때부터 curr[2] = 1

                    }
                }

                // 벽이 없을 경우
                else {
                    // 해당 칸을 방문하지 않은 경우
                    if (!Visited[curr[2]][x][y]) {

                        Visited[curr[2]][x][y] = true; // 방문 처리
                        Distance[x][y] = Distance[curr[0]][curr[1]] + 1; // Distance 거리 배열 값 입력
                        q.add(new int[]{x, y, curr[2]});

                    }
                }

                // 도착지점에 도달했다면 출력하고 종료
                if (x == N - 1 && y == M - 1) {
                    System.out.println(Distance[x][y] + 1);
                    System.exit(0);
                }

            }

        }

        System.out.println(-1);

    }

}
