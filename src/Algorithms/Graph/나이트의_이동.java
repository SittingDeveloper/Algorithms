package Algorithms.Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 7562
public class 나이트의_이동 {

    // 방문한 노드
    static boolean Visited[][];

    // Depth를 그리는 그래프
    static int Depth[][];

    static int I;
    static int find_x, find_y;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        // 테스트 케이스
        int testCase = Integer.parseInt(br.readLine());

        for (int T = 0; T < testCase; T++) {

            // 체스판 한 변의 길이
            I = Integer.parseInt(br.readLine());

            Visited = new boolean[I][I];
            Depth = new int[I][I];

            // 체스가 처음으로 놓이는 좌표
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            // 목표 좌표
            st = new StringTokenizer(br.readLine());
            find_x = Integer.parseInt(st.nextToken());
            find_y = Integer.parseInt(st.nextToken());


            // 처음으로 놓이는 좌표와 목표 좌표가 같다면 탐색하지 않음
            if (u == find_x && v == find_y) {
                sb.append(Depth[find_x][find_y] + "\n");
                continue;
            }

            bfs(u, v);

            /*
            3
            8
            0 0
            7 0
            * */
            /*for (int i = 0; i < I; i++) {
                for (int j = 0; j < I; j++) {
                    System.out.print(Depth[i][j] + " ");
                }
                System.out.println();
            }*/

            sb.append(Depth[find_x][find_y] + "\n");
        }

        System.out.println(sb);

    }

    static void bfs(int startX, int startY) {

        Visited[startX][startY] = true;
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{startX, startY});

        // 나이트 이동 경로
        int dx[] = {1, 2, 2, 1, -1, -2, -1, -2};
        int dy[] = {-2, -1, 1, 2, -2, -1, 2, 1};

        while (!q.isEmpty()) {

            int curr[] = q.poll();

            boolean find = false;

            for (int i = 0; i < 8; i++) {

                int x = curr[0] + dx[i];
                int y = curr[1] + dy[i];

                if (x < 0 || x >= I || y < 0 || y >= I) {
                    continue;
                }

                // Depth 배열 값 입력
                if (Visited[x][y] == false) {

                    q.add(new int[]{x, y});
                    Visited[x][y] = true;
                    Depth[x][y] = Depth[curr[0]][curr[1]] + 1;

                    // 목표 좌표를 찾으면 종료
                    if (x == find_x && y == find_y) {
                        find = true;
                        break;
                    }

                }

            }

            if (find == true) {
                break;
            }

        }
    }
    
}
