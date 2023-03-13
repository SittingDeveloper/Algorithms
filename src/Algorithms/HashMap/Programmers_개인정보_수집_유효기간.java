package Algorithms.HashMap;

import java.util.*;
import java.io.*;

public class Programmers_개인정보_수집_유효기간 {

    static HashMap<String, Integer> map = new HashMap<>();

    public static void main(String[] args) {

        String today = "2022.05.19";
        String terms[] = {"A 6", "B 12", "C 3"};
        String privacies[] = {"2021.05.02 A", "2021.07.01 B", "2022.02.19 C", "2022.02.20 C"};

        // 정답 배열을 담을 ArrayList
        ArrayList<Integer> result = new ArrayList<>();

        // 문자열 분리를 위한 StringTokenizer
        StringTokenizer st = new StringTokenizer(today, ".");

        // 현재 날짜를 연 월 일 순으로 끊어서 저장
        int today_year = Integer.parseInt(st.nextToken());
        int today_month = Integer.parseInt(st.nextToken());
        int today_day = Integer.parseInt(st.nextToken());

        // 권한을 HashMap 을 이용해 저장 ( Key : Auth, Value : period )
        for (int i = 0 ; i < terms.length ; i++) {
            st = new StringTokenizer(terms[i], " ");
            String authName = st.nextToken();
            int authMonth = Integer.parseInt(st.nextToken());
            map.put(authName, authMonth);
        }

        // 검사 시작
        for (int i = 0 ; i < privacies.length ; i++) {

            st = new StringTokenizer(privacies[i], "-");

            // 현재 검사하는 날짜
            String cur_today = st.nextToken();
            // 현재 검사하는 권한
            String cur_authName = st.nextToken();

            // 현재 검사하는 날짜 연월일로 나눔
            st = new StringTokenizer(cur_today, ".");
            int cur_year = Integer.parseInt(st.nextToken());
            int cur_month = Integer.parseInt(st.nextToken());
            int cur_day = Integer.parseInt(st.nextToken());

            // 해당 권한의 기간을 가져옴
            int period = map.get(cur_authName);

            // 권한의 기간을 검사하는 날짜 Month 더함
            cur_month += period;

            /* === 조건 따지기 시작 === */
            while (cur_month > 12) {
                cur_year++;
                cur_month -= 12;
            }

            cur_day--;

            if (cur_day <= 0) {
                cur_day = 28;
                cur_month--;
            }
            /* === 조건 따지기 완료 === */

            // 현재 개인정보의 만료일 표기
            System.out.println(cur_year + "." + cur_month + "." + cur_day);

            if (today_year > cur_year) {
                result.add(i + 1);
                continue;
            } else if (today_year == cur_year && today_month > cur_month ) {
                result.add(i + 1);
                continue;
            } else if (today_year == cur_year && today_month == cur_month && today_day > cur_day) {
                result.add(i + 1);
                continue;
            }


        }

        int[] answer = new int[result.size()];

        for (int i = 0 ; i < result.size() ; i++) {
            answer[i] = result.get(i);
        }

        for (int i = 0; i < answer.length; i++) {
            System.out.println(answer[i]);
        }

    }

}
