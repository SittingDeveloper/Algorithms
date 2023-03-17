package Algorithms.DataStructure.SumOfPart;

public class Programmers_파괴되지_않은_건물 {


    static int sum[][];
    static int N, M;

    static int board[][] = {{5, 5, 5, 5, 5}, {5, 5, 5, 5, 5}, {5, 5, 5, 5, 5}, {5, 5, 5, 5, 5}};
    static int skill[][] = {{1, 0, 0, 3, 4, 4}, {1, 2, 0, 2, 3, 2}, {2, 1, 0, 3, 1, 2}, {1, 0, 1, 3, 3, 1}};
    public static void main(String[] args) {
        System.out.println(solution(board, skill));
    }

    static public int solution(int[][] board, int[][] skill) {

        /*
        행렬모양의 게임맵.. 인접행렬 사용
        내구도를 가진 건물이 각 칸마다 하나씩 있음 ..
        적이 건물을 공격하면 내구도가 감소되고 0 이하가 되면 파괴됨 ..
        아군은 회복스킬을 사용해서 건물들의 내구도를 높일 수 있음.. 파괴된 건물도 복구 가능..
        */

        int answer = 0;
        N = board.length;
        M = board[0].length;

        // 누적합을 저장할 sum[][] 배열
        sum = new int[N + 1][M + 1];

        // skill(type, r1 ,c1 ,r2 ,c2 ,degree)
        // sum 을 2가지 방향(상하, 좌우)에 대해 합산(현재값 + 이전값), 전체적인 합산 결과를 갱신
        for (int[] s : skill) {
            int y1 = s[1], x1 = s[2];
            int y2 = s[3], x2 = s[4];
            int degree = s[5] * (s[0] == 1 ? -1 : 1);

            // r1, c1, r2, c2에 대한 4개의 위치에 값을 갱신
            sum[y1][x1] += degree;
            sum[y1][x2 + 1] += (degree * -1);
            sum[y2 + 1][x1] += (degree * -1);
            sum[y2 + 1][x2 + 1] += degree;
        }

        partSum();

        // 살아남은 건물확인
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (board[i][j] + sum[i][j] > 0)
                    answer++;
            }
        }

        return answer;
    }

    // 누적합 계산
    private static void partSum() {

        // 상하 누적합
        for (int y = 1; y < N; y++) {
            for (int x = 0; x < M; x++) {
                sum[y][x] += sum[y - 1][x];
            }
        }

        // 좌우 누적합
        for (int x = 1; x < M; x++) {
            for (int y = 0; y < N; y++) {
                sum[y][x] += sum[y][x - 1];
            }
        }
    }


}
