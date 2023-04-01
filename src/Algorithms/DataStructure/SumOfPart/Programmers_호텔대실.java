package Algorithms.DataStructure.SumOfPart;

import java.util.StringTokenizer;

public class Programmers_호텔대실 {

    public static void main(String[] args) {
        String book_time[][] = { {"15:00", "17:00"}, {"16:40", "18:20"}, {"14:20", "15:20"},
                {"14:10", "19:20"}, {"18:20", "21:20"} };
        System.out.println(solution(book_time));
    }

    static final int MAX_TIME = 1450;
    static final int HOUR = 60;
    static final int CLEAN_TIME = 10;

    static int rooms[] = new int[MAX_TIME];

    static public int solution(String[][] book_time) {
        int answer = 0;

        /*
        누적합 문제,
        시간을 분으로 계산하고 입실 시간과 퇴실 시간을 배열에 기록하여
        누적합을 하면 각 사람들이 겹치는 시간대를 알 수 있음.

        누적합 :
        시작 위치에 1 추가,
        끝 + 1 위치에 -1 추가.,
        누적합 진행, 현재 위치에서 이전 위치의 값을 더하면 됌
        */

        StringTokenizer st;

        for (int i = 0 ; i < book_time.length ; i++) {
            st = new StringTokenizer(book_time[i][0]);
            String inTime = st.nextToken();

            st = new StringTokenizer(book_time[i][1]);
            String outTime = st.nextToken();

            rooms[calTime(inTime)] += 1;
            rooms[calTime(outTime) + CLEAN_TIME] += -1;
        }

        // 누적합
        for (int i = 1 ; i < MAX_TIME ; i++) {
            rooms[i] += rooms[i-1];
            answer = Math.max(answer, rooms[i]);
        }

        return answer;
    }

    static int calTime(String time) {
        StringTokenizer st = new StringTokenizer(time, ":");
        String hour = st.nextToken();
        String minute = st.nextToken();

        return ((Integer.parseInt(hour) * HOUR) + Integer.parseInt(minute));
    }

}