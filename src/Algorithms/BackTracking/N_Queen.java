package Algorithms.BackTracking;

// 8*8 체스판에서 퀸 8개를 서로 영역을 침범하지 않는 선에서 둘 수 있는 경우의 수는 92회.
public class N_Queen {

    static int N; // 체스판의 크기
    static int[] col; // 퀸이 배치된 열의 위치를 저장하는 배열
    static int cnt; // 퀸의 개수

    public static void main(String[] args) {
        N = 8; // 8 x 8 체스판
        col = new int[N + 1];

        dfs(1); // DFS 호출
        System.out.println(cnt); // 해의 개수 출력
    }

    // DFS 함수
    public static void dfs(int row) {
        if (row > N) { // 모든 행에 퀸을 배치했으면
            cnt++; // 해의 개수 증가
            return;
        }

        for (int i = 1; i <= N; i++) { // i번째 열에 퀸을 배치하는 경우를 탐색
            col[row] = i; // i번째 열에 퀸을 배치
            if (isPossible(row)) { // 현재 상태가 가능한 상태인지 확인
                dfs(row + 1); // 다음 행으로 이동
            }
        }
    }

    // 현재 상태가 가능한 상태인지 확인하는 함수
    public static boolean isPossible(int row) {
        for (int i = 1; i < row; i++) {
            // 같은 열이거나 대각선에 있는 경우
            if (col[i] == col[row] || Math.abs(col[i] - col[row]) == row - i) {
                return false;
            }
        }
        return true;
    }

}
