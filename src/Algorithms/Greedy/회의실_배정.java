package Algorithms.Greedy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

// 1931
public class 회의실_배정 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt(); // 회의의 수 입력
        List<Meeting> meetings = new ArrayList<>(); // 회의 정보를 담을 리스트 생성

        for (int i = 0; i < n; i++) {

            int start = scanner.nextInt();
            int end = scanner.nextInt();

            meetings.add(new Meeting(start, end));
        }

        Collections.sort(meetings); // 회의 시간을 종료 시간을 기준으로 오름차순 정렬

        int count = 0;
        int prevEndTime = 0;

        for (int i = 0 ; i < n ; i++) {
            int curStart = meetings.get(i).start;
            int curEnd = meetings.get(i).end;

            if (prevEndTime <= curStart) {
                prevEndTime = curEnd;
                count++;
            }

        }

        System.out.println(count);

    }
}

class Meeting implements Comparable<Meeting> {
    int start; // 시작 시간
    int end; // 끝나는 시간

    public Meeting(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    public int compareTo(Meeting o) { // 시작 시간을 기준으로 정렬하기 위한 compareTo 메소드 구현

        if (this.end == o.end) {
            return this.start - o.start;
        }

        return this.end - o.end;
    }

}
