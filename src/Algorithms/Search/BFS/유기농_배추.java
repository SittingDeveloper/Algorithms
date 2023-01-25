package Algorithms.Search.BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*

1
5 3 6
0 2
1 2
2 2
3 2
4 2
4 0

result = 2
* */

// 1012
public class 유기농_배추 {

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

            // 가로
            M = Integer.parseInt(st.nextToken());

            // 세로
            N = Integer.parseInt(st.nextToken());

            // 배추의 개수
            int K = Integer.parseInt(st.nextToken());

            // 배추밭
            Graph = new int[M][N];

            // 배추밭 방문 여부
            Visited = new boolean[M][N];

            // 배추가 있어야할 위치에 배추 저장
            for (int i = 0; i < K; i++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());

                // 배추 좌표 입력
                Graph[x][y] = 1;
            }
            // ==============================================
            // 입력된 내용 저장

            // 지렁이의 개수
            int earthWarm = 0;

            // 배추밭 탐색
            for (int i = 0; i < M; i++) {
                for (int j = 0; j < N; j++) {

                    // 배추가 존재하고 방문한적이 없는 지 확인
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

        // 방문한 위치를 true로 변경
        Visited[startX][startY] = true;

        // x, y 좌표를 저장할 Queue 배열 생성
        Queue<int[]> q = new LinkedList<>();

        // x, y 좌표를 q에 Push
        q.add(new int[]{startX, startY});

        // 상하좌우
        int dx[] = {0, 0, -1, 1};
        int dy[] = {-1, 1, 0, 0};
        // 배추가 상하좌우에 인접하면 이동할 수 있음
        // 현재 좌표에서 상하좌우 움직이는 좌표를 지정

        // 큐가 비어있으면 더이상 인접한 배추가 없다는 뜻
        while (!q.isEmpty()) {

            // 배추의 위치를 꺼냄
            int[] curr = q.poll();

            // 상하좌우 확인
            for (int i = 0; i < 4; i++) {
                int x = curr[0] + dx[i];
                int y = curr[1] + dy[i];

                // 좌표가 배추밭을 벗어나게되면 다음 좌표를 체크해야한다
                if (x < 0 || x >= M || y < 0 || y >= N) {
                    continue;
                }

                // 상하좌우 좌표에 배추가 있고, 방문하지 않았다면
                if (Graph[x][y] == 1 && Visited[x][y] == false) {
                    q.add(new int[]{x, y});
                    Visited[x][y] = true;
                }

            }

        }

    }

}
