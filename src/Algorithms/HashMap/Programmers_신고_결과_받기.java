package Algorithms.HashMap;

import java.util.*;

public class Programmers_신고_결과_받기 {

    public static void main(String[] args) {

        String id_list[] = {"muzi", "frodo", "apeach", "neo"};
        String report[] = {"muzi frodo", "apeach frodo", "frodo neo", "muzi neo", "apeach muzi"};
        int k = 2;
        Solution solution = new Solution();

        for (int temp : solution.solution(id_list, report, k)) {
            System.out.print(temp + " ");
        }

    }

    static class Solution {
        public ArrayList<Integer> solution(String[] id_list, String[] report, int k) {
            ArrayList<Integer> answer = new ArrayList<>();

            // 신고자 , 피신고자 순으로 map 저장
            HashMap<String,Integer> map = new HashMap<>();

            for (int i = 0 ; i < report.length ; i++) {
                StringTokenizer st = new StringTokenizer(report[i]);

                String reporter = st.nextToken();
                String reported = st.nextToken();

                map.put(reporter + " " + reported, map.getOrDefault(reporter + " " + reported, 0) + 1);
            }

            // 피신고자의 이름, 신고당한 횟수를 map 저장
            HashMap<String, Integer> result = new HashMap<>();
            for (String temp : map.keySet()) {
                // System.out.println(temp + " " + map.get(temp));
                StringTokenizer st = new StringTokenizer(temp);
                st.nextToken();
                String user = st.nextToken();
                result.put(user, result.getOrDefault(user, 0) + 1);
            }

            // k 이상의 피신고자의 이름과 신고당한 횟수를 저장
            ArrayList<String> checked = new ArrayList<>();
            for (String temp : result.keySet()) {
                if (result.get(temp) >= k) {
                    checked.add(temp);
                }
            }

            // ans : 정답 map
            HashMap<String, Integer> ans = new HashMap<>();
            // checked 안에 frodo, neo 있음
            for (String temp : map.keySet()) {
                StringTokenizer st = new StringTokenizer(temp);

                String reporter = st.nextToken();
                String reported = st.nextToken();

                // System.out.println(reporter + " " + reported);
                // k 이상 신고당한 전적을 가진 피신고자가 있다면 신고자에게 메시지++
                if (checked.contains(reported)) {
                    ans.put(reporter, ans.getOrDefault(reporter, 0) + 1);
                    // System.out.println(reporter + " " + reported);
                }

            }

            for (int i = 0 ; i < id_list.length ; i++) {

                if (ans.get(id_list[i]) == null) {
                    answer.add(0);
                } else {
                    answer.add(ans.get(id_list[i]));
                }

            }

            return answer;
        }
    }

}
