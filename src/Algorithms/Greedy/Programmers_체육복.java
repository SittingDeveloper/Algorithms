package Algorithms.Greedy;

import java.util.Arrays;

public class Programmers_체육복 {

    public static void main(String[] args) {

        int n = 5;
        int lost[] = {2, 4};
        int reserve[] = {5};

        System.out.println(Solution(n, lost, reserve));
    }

    public static int Solution(int n, int[] lost, int[] reserve) {
        int answer = n - lost.length;
        Arrays.sort(lost);
        Arrays.sort(reserve);

        //여분이 있는 학생이 도난당한 경우
        for(int i = 0 ; i < lost.length ; i++) {
            for (int j = 0 ; j < reserve.length ; j++) {
                // 자기 자신이 포함되어있는지 체크
                if (lost[i] == reserve[j]) {
                    answer++; // 자신의 옷을 입으면 되니 참여자 수 증가
                    reserve[j] = -1;
                    lost[i] = -1;
                    break;
                }
            }
        }

        //체육복을 빌려주는경우
        for (int i = 0 ; i < lost.length ; i++) {
            for (int j = 0 ; j < reserve.length ; j++) {
                // 잃어버린 사람의 인덱스보다 1 작거나 1 크다면 넘겨줌
                if ((lost[i] - 1 == reserve[j] || lost[i] + 1 == reserve[j])) {
                    answer++;
                    reserve[j] = -1;
                    break;
                }
            }
        }

        return answer;

    }

}
