package Algorithms.Another;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 7682

/*

XXXOO.XXX
XOXOXOXOX
OXOXOXOXO
XXOOOXXOX
XO.OX...X
.XXX.XOOO
X.OO..X..
OOXXXOOXO
end

* */
public class 틱택토 {

    static char map[][];

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while (true) {

            String s = br.readLine();
            if (s.equals("end")) {
                break;
            }

            String a = s.substring(0, 3);
            String b = s.substring(3, 6);
            String c = s.substring(6, 9);

            map = new char[3][3];

            for (int i = 0; i < 3; i++) {
                map[0][i] = a.charAt(i);
            }

            for (int i = 0; i < 3; i++) {
                map[1][i] = b.charAt(i);
            }

            for (int i = 0; i < 3; i++) {
                map[2][i] = c.charAt(i);
            }

            /*for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    System.out.print(map[i][j]);
                }
                System.out.println();
            }*/


            if (test(map)) {
                sb.append("valid\n");
            } else {
                sb.append("invalid\n");
            }

        }

        System.out.println(sb);


    }

    static boolean test(char[][] map) {
        int O_Cnt = 0, X_Cnt = 0, Dot_Cnt = 0;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (map[i][j] == 'O') {
                    O_Cnt++;
                } else if (map[i][j] == 'X') {
                    X_Cnt++;
                } else {
                    Dot_Cnt++;
                }
            }
        }

        if (O_Cnt + X_Cnt == 9) {
            if (X_Cnt - 1 != O_Cnt || isValid(map, 'O')) {
                return false;
            } else {
                return true;
            }
        } else {

            // O로 끝나야 한다 ( O가 이긴 경우 )
            if (X_Cnt == O_Cnt) {
                boolean isO = isValid(map, 'O'); // O 빙고가 존재한다면 true
                boolean isX = isValid(map, 'X'); // X 빙고가 존재한다면 true

                // O만 빙고가 존재해야한다, X 빙고가 이미 있다면 이전에 끝났어야함
                if (isO == true && isX == false) {
                    return true;
                } else {
                    return false;
                }

            }

            // X로 끝나야 한다
            else if (X_Cnt == O_Cnt + 1) {
                boolean isO = isValid(map, 'O');
                boolean isX = isValid(map, 'X');

                // X만 빙고가 존재해야한다, O 빙고가 이미 있다면 이전에 끝났어야함
                if (isO == false && isX == true) {
                    return true;
                } else {
                    return false;
                }
            }

        }

        /*System.out.println(O_Cnt);
        System.out.println(X_Cnt);
        System.out.println(Dot_Cnt);*/

        return false;

    }

    static boolean isValid(char[][] map, char c) {
        // 가로
        for (int i = 0; i < 3; i++) {
            if (map[i][0] == c && map[i][1] == c && map[i][2] == c) {
                return true;
            }
        }

        // 세로
        for (int i = 0; i < 3; i++) {
            if (map[0][i] == c && map[1][i] == c && map[2][i] == c) {
                return true;
            }
        }

        // 대각선
        if (map[0][0] == c && map[1][1] == c && map[2][2] == c) {
            return true;
        }
        if (map[0][2] == c && map[1][1] == c && map[2][0] == c) {
            return true;
        }

        return false;

    }

}
