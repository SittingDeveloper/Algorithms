package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Code_7562 {

    static boolean Visited[][];

    // Depth를 그리는 그래프
    static int Depth[][];

    static int I;
    static int find_x, find_y;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int testCase = Integer.parseInt(br.readLine());

        for (int T = 0; T < testCase; T++) {

            I = Integer.parseInt(br.readLine());

            Visited = new boolean[I][I];
            Depth = new int[I][I];

            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            find_x = Integer.parseInt(st.nextToken());
            find_y = Integer.parseInt(st.nextToken());


            if (u == find_x && v == find_y) {
                sb.append(Depth[find_x][find_y] + "\n");
                continue;
            }

            bfs(u, v);

            sb.append(Depth[find_x][find_y] + "\n");
        }

        System.out.println(sb);

    }

    static void bfs(int startX, int startY) {

        Visited[startX][startY] = true;
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{startX, startY});

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

                if (Visited[x][y] == false) {

                    q.add(new int[]{x, y});
                    Visited[x][y] = true;
                    Depth[x][y] = Depth[curr[0]][curr[1]] + 1;

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
