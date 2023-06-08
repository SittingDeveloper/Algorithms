package Algorithms.Search.BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


// 2178
public class 미로탐색 {

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

        // 미로 입력에 공백이 존재하지 않으므로 String 으로 받고 한 글자씩 Graph 삽입
        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < M; j++) {
                Graph[i][j] = s.charAt(j) - '0';
            }
        }

        Visited = new boolean[N][M];

        // 0,0 부터 탐색 시작, 방문했으니 true 설정
        Visited[0][0] = true;

        // bfs 탐색 시작
        bfs(0, 0);

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                System.out.print(Graph[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println(Graph[N-1][M-1]);
    }

    static void bfs(int x, int y) {

        // 이동 가능한 칸들의 인덱스를 저장할 큐를 선언. (x,y)쌍의 int 형 배열을 저장
        Queue<int[]> q = new LinkedList<>();

        // 넘겨받은 x,y를 int 형 배열로 만들어 큐에 삽입
        q.add(new int[]{x, y});

        // 큐가 비어있지 않다면 반복
        while (q.isEmpty() == false) {

            // 큐에서 원소 하나를 꺼내 각각 인덱스를 nowX, nowY 에 저장한다.
            int now[] = q.poll();
            int nowX = now[0];
            int nowY = now[1];

            // (nowX,nowY)를 기준으로 상하좌우를 확인해서 이동 가능한 인덱스가 있다면 그 인덱스를 큐에 저장
            for (int i = 0; i < 4; i++) {
                int nextX = nowX + dx[i];
                int nextY = nowY + dy[i];

                if (nextX < 0 || nextY < 0 || nextX >= N || nextY >= M)
                    continue;

                if (Visited[nextX][nextY] || Graph[nextX][nextY] == 0) {
                    continue;
                }
                q.add(new int[]{nextX, nextY});

                // 그 인덱스의 값을 현재 인덱스(nowX, nowY)값 보다 1 큰 값으로 설정
                Graph[nextX][nextY] = Graph[nowX][nowY] + 1;

                // 그 인덱스의 방문체크를 true 로 설정.
                Visited[nextX][nextY] = true;
            }
        }
    }

}
