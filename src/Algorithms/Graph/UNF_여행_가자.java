package Algorithms.Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 1976
public class UNF_여행_가자 {

    static int unf[];

    static int find(int v) {

        if (unf[v] == v) {
            return v;
        } else {
            return unf[v] = find(unf[v]);
        }

    }

    static void union(int a, int b) {
        a = find(a);
        b = find(b);
        if (a != b) {
            unf[b] = a;
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 도시의 개수
        int N = Integer.parseInt(br.readLine());

        // 여행 계획에 속한 도시들의 수
        int M = Integer.parseInt(br.readLine());

        unf = new int[N + 1];

        // 가장 첫 unf 배열은 각 인덱스로 초기화, 이후 union 연산을 통해 하나의 루트노트로 병합해감
        for (int i = 1; i < unf.length; i++) {
            unf[i] = i;
        }

        // 인접행렬이 1인 값들이 모두 같은 indexRoute 를 가진다면 이어진 것, 여행 가능
        int Graph[][] = new int[N + 1][N + 1];

        // 그래프 그리기
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                Graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // union
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (Graph[i][j] == 1) {
                    union(i, j);
                }
            }
        }

        st = new StringTokenizer(br.readLine());
        
        // 루트노드를 index로 설정
        int index = find(Integer.parseInt(st.nextToken()));

        // 이후에 올 인덱스의 루트노드가 하나라도 다를 경우 NO 출력
        for (int i = 1; i < M; i++) {
            if (index != find(Integer.parseInt(st.nextToken()))) {
                System.out.println("NO");
                System.exit(0);
            }
        }

        System.out.println("YES");

    }

}
