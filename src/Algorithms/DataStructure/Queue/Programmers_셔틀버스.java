package Algorithms.DataStructure.Queue;

import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Programmers_셔틀버스 {

    public static void main(String[] args) {
        int n = 2;
        int t = 10;
        int m = 2;
        String timetable[] = {"09:10", "09:09", "08:00"};

        System.out.println(solution(n, t, m, timetable));

    }

    static public String solution(int n, int t, int m, String[] timetable) {
        String answer = "";

        /*
        셔틀 출발은 09:00시
        n : 운행횟수
        t : 셔틀 운행 간격
        m : 한 셔틀에 탈 수 있는 최대 크루 수
        timetable : 크루들이 버스정류장에 도착하는 시간
        */

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        StringTokenizer st;
        for (int i = 0; i < timetable.length; i++) {
            st = new StringTokenizer(timetable[i], ":");
            int hour = Integer.parseInt(st.nextToken());
            int minute = Integer.parseInt(st.nextToken()) + (hour * 60);

            // 탑승자들을 전원 우선순위큐에 add
            pq.add(minute);
        }

        int startTime = 540; // 09:00
        int lastTime = 0; // 막차

        // 버스에 타고있는 인원
        int onBus = 0;

        // 버스 운행 횟수 만큼 반복
        for (int i = 0; i < n; i++) {

            onBus = 0;

            // 현재 운행하는 버스
            while (!pq.isEmpty()) {
                int currentTime = pq.peek();
                if (currentTime <= startTime && onBus < m) {
                    pq.poll();
                    onBus++;
                    lastTime = currentTime - 1;
                } else {
                    break;
                }
            }
            startTime += t;
        }

        if (onBus < m) {
            lastTime = startTime - t;
        }

        // 시간데이터에 맞게끔 포맷팅
        String hour = String.format("%02d", lastTime / 60);
        String minute = String.format("%02d", lastTime % 60);

        answer = hour + ":" + minute;

        return answer;
    }


}
