package Algorithms.Search.BinarySearch;

import java.util.Arrays;

public class Programmers_입국심사 {

    public static void main(String[] args) {
        int n = 6;
        int times[] = {7, 10};
        System.out.println(solution(n, times));
    }

    static public long solution(int n, int[] times) {

        /*
        입국 심사를 기다리는 N명 ..
        각 입구심사대에는 심사관이 있는데, 심사하는데 걸리는 시간이 다 다름 ..
        처음 모든 심사대는 "비어있음"..
        함 심사대에서는 "한명만 심사 가능" ..
        가장 앞에 서 있는 사람은 비어있는 심사대로 가서 심사를 받음 ..
        ? - 더 빨리 끝나는 심사대가 있으면 기다렸다가 그곳으로 가서 심사를 받을수있음..

        모든사람이 심사를 받는데 걸리는 시간을 최소화
        */

        Arrays.sort(times);

        long startPoint = times[0];
        long endPoint = times[times.length - 1] * (long) n;

        while (startPoint <= endPoint) {
            long midValue = (startPoint + endPoint) / 2;

            // targetValue
            long sum = 0;
            for (int i = 0; i < times.length; i++) {
                sum += midValue / times[i];
            }

            if (sum < n) {
                startPoint = midValue + 1;
            } else {
                endPoint = midValue - 1;
            }

        }

        return startPoint;
    }

}
