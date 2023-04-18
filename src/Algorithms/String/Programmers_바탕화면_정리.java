package Algorithms.String;

public class Programmers_바탕화면_정리 {

    public static void main(String[] args) {

        String wallpaper[] = {"..........", ".....#....", "......##..", "...##.....", "....#....."};

        Solution solution = new Solution();

        for (int temp : solution.solution(wallpaper)) {
            System.out.print(temp + " ");
        }
    }

    static class Solution {
        public int[] solution(String[] wallpaper) {
            int[] answer = new int[4];

            int Graph[][] = new int[wallpaper.length][wallpaper[0].length()];

            int startX = Integer.MAX_VALUE;
            int startY = Integer.MAX_VALUE;
            int endX = -1;
            int endY = -1;

            for (int i = 0 ; i < wallpaper.length ; i++) {
                for (int j = 0 ; j < wallpaper[0].length() ; j++) {
                    String tempChar = wallpaper[i].charAt(j) + "";
                    if (tempChar.equals(".")) {
                        Graph[i][j] = 0;
                    } else {
                        Graph[i][j] = 1;
                    }
                }
            }

            for (int i = 0 ; i < Graph.length ; i++) {
                for (int j = 0 ; j < wallpaper[0].length() ; j++) {
                    System.out.print(Graph[i][j]);
                }
                System.out.println();
            }

            // i 중 1이 가장 먼저 , j가 가장 먼저 나온곳이 Drag 시작점
            // i 중 1이 가장 늦게 , j가 가장 늦게 나온곳이 Drag 끝점
            for (int i = 0 ; i < wallpaper.length ; i++) {
                for (int j = 0 ; j < wallpaper[0].length() ; j++) {
                    if(Graph[i][j] == 1) {
                        startX = Math.min(startX, i);
                        startY = Math.min(startY, j);
                        endX = Math.max(endX, i);
                        endY = Math.max(endY, j);
                    }
                }
            }

            answer[0] = startX;
            answer[1] = startY;
            answer[2] = ++endX;
            answer[3] = ++endY;

            return answer;
        }
    }

}
