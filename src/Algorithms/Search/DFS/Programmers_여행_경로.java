package Algorithms.Search.DFS;

import java.util.ArrayList;
import java.util.Collections;

public class Programmers_여행_경로 {


    static ArrayList<String> list = new ArrayList<>();
    static boolean Visited[];
    static String tickets[][] = {{"ICN", "SFO"}, {"ICN", "ATL"}, {"SFO", "ATL"}, {"ATL", "ICN"}, {"ATL","SFO"} };

    public static void main(String[] args) {
        for (String s : solution(tickets)) {
            System.out.print(s + " ");
        }
    }

    static public String[] solution(String[][] tickets) {

        Visited = new boolean[tickets.length];

        // depth, now, next;
        dfs(0, "ICN", "ICN");

        // 모든 경로를 정렬
        Collections.sort(list);

        // for (String s : list) {
        //     System.out.print(s + " ");
        // }

        // 첫 번째 경로를 잘라서 리턴
        return list.get(0).split(" ");

    }

    static void dfs(int depth, String now, String path) {

        // 사용한 티켓의 수가 전체 티켓의 수와 같아진 경우
        if (depth == tickets.length) {
            list.add(path);
            return;
        }

        // 티켓 배열을 순회
        for (int i = 0 ; i < tickets.length ; i++) {
            // 티켓을 아직 사용하지 않았고 해당 티켓의 출발지가 현재 위치와 같은 경우
            if (Visited[i] == false && now.equals(tickets[i][0])) {
                // 티켓을 사용하고 이동
                Visited[i] = true;
                dfs(depth +1, tickets[i][1], path + " " + tickets[i][1]);
                Visited[i] = false;
            }
        }

    }

}
