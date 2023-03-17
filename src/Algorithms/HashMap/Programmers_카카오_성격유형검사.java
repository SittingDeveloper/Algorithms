package Algorithms.HashMap;


import java.util.HashMap;

public class Programmers_카카오_성격유형검사 {

    public static void main(String[] args) {
        String survey[] = {"AN", "CF", "MJ", "RT", "NA"};
        int choices[] = {5, 3, 2, 7, 5};

        System.out.println(solution(survey, choices));
    }

    public static  String solution(String[] survey, int[] choices) {


        /*
        성격 유형 검사지를 만듦..
        검사는 다음과 같은 4개 지표로 구분 ..
        1 = {R, T}
        2 = {C, F}
        3 = {J, M}
        4 = {A, N}
        성격은 각 지표에서 두 유형중 하나로 결정 ..

        4개의 지표가 있으므로 성격 유형은 총 16가지가 나옮 ..
        예를들어, RFMN, TCMA 등등 ..

        검사지에는 총 n개의 질문이 있고 각 질문에는 7개의 선택지가 있음 ..
        각 질문은 1가지 지표로 성격 유형 점수를 판단함 ..

        4번 지표로 질문을 할 때 답변에 따라 다음과 같은 점수를 받음 ..
        약간 동의   : 어피치(A) 1점
        매우 비동의 : 네오(N) 3점 ..

        매우, 매우 비동의     : 3점
        동의, 비동의          : 2점
        약간 동의, 약간 비동의 : 1점
        모르겠음             : 0점

        검사결과는 모든 질문의 성격 유형 점수를 더하여..
        각 지표에서 더 높은 점수를 받은 성격 유형이 결과로 나옴 ..

        단, 하나의 지표에서 각 성격 유형점수가 같으면 ..
        두 성격 유형 중 사전순으로 빠른 성격 유형을 검사자의 유형이라고 판단함 ..

        survey : 판단하는 지표를 담은 1차원 문자열 배열
        choice : 선택한 선택지
        */

        // key, value
        HashMap<Character, Integer> map = new HashMap<>();

        map.put('R', 0);
        map.put('T', 0);

        map.put('C', 0);
        map.put('F', 0);

        map.put('J', 0);
        map.put('M', 0);

        map.put('A', 0);
        map.put('N', 0);

        for (int i = 0; i < choices.length; i++) {
            char c1 = survey[i].charAt(0);
            char c2 = survey[i].charAt(1);
            Integer value = choices[i];
            // System.out.print(c1 + " " + c2 + " : " + value + "\n");

            if (value == 1) {
                map.put(c1, map.get(c1) + 3);
            } else if (value == 2) {
                map.put(c1, map.get(c1) + 2);
            } else if (value == 3) {
                map.put(c1, map.get(c1) + 1);
            } else if (value == 4) {
                continue;
            } else if (value == 5) {
                map.put(c2, map.get(c2) + 1);
            } else if (value == 6) {
                map.put(c2, map.get(c2) + 2);
            } else if (value == 7) {
                map.put(c2, map.get(c2) + 3);
            }
        }

        String answer = "";

        int R = map.get('R');
        int T = map.get('T');

        int C = map.get('C');
        int F = map.get('F');

        int J = map.get('J');
        int M = map.get('M');

        int A = map.get('A');
        int N = map.get('N');

        if (R > T) {
            answer += "R";
        } else if (R < T) {
            answer += "T";
        } else {
            answer += "R";
        }

        if (C > F) {
            answer += "C";
        } else if (C < F) {
            answer += "F";
        } else {
            answer += "C";
        }

        if (J > M) {
            answer += "J";
        } else if (J < M) {
            answer += "M";
        } else {
            answer += "J";
        }

        if (A > N) {
            answer += "A";
        } else if (A < N) {
            answer += "N";
        } else {
            answer += "A";
        }

        return answer;
    }

}
