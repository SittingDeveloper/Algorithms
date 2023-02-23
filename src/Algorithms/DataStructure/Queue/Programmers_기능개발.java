package Algorithms.DataStructure.Queue;

import java.io.*;
import java.util.*;

public class Programmers_기능개발 {

    public static void main(String[] args) {

//        int progresses[] = {93, 30, 55};
//        int speeds[] = {1, 30, 5};

        int progresses[] = {95, 90, 99, 99, 80, 99};
        int speeds[] = {1, 1, 1, 1, 1, 1};

        ArrayList<Integer> arr = new ArrayList<>();

        /*
         * 93, 30, 55
         * 1 , 30, 5
         * 작업1 : 7일
         * 작업2 : 3일
         * 작업3 : 9일
         *
         * 7일째에 (작업1, 작업2) 2가지 기능 배포
         * 9일째에 (작업3) 1가지 기능 배포
         *
         * 94 60 60
         * 95 90 65
         * 96 120 70
         * 97 150 75
         * 98 180 80
         * 99 210 85
         * 100 240 90
         * */

        Queue<Program> q = new LinkedList<>();
        for (int i = 0; i < progresses.length; i++) {
            q.add(new Program(progresses[i], speeds[i]));
        }

        int count;
        while (!q.isEmpty()) {

            count = 0;

            while (q.size() > 0 && q.peek().progress >= 100) {
                q.poll();
                count++;
            }

            if (count != 0) {
                arr.add(count);
            }

            for (int i = 0; i < q.size(); i++) {
                Program temp = q.poll();
                int cur_progress = temp.progress + temp.speed;
                q.add(new Program(cur_progress, temp.speed));
            }


        }

        int answer[] = new int[arr.size()];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = arr.get(i);
        }


    }

    static class Program {
        int progress;
        int speed;

        Program(int progress, int speed) {
            this.progress = progress;
            this.speed = speed;
        }
    }

}
