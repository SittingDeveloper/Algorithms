package Algorithms.HashMap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Programmers_오픈채팅방 {

    public static void main(String[] args) {
        String record[] = {"Enter uid1234 Muzi", "Enter uid4567 Prodo", "Leave uid1234", "Enter uid1234 Prodo", "Change uid4567 Ryan"};

        Solution solution = new Solution();

        for (String s : solution.solution(record)) {
            System.out.println(s);
        }

    }

    static class Solution {
        public String[] solution(String[] record) {
            String[] answer = {};

            HashMap<String, String> map = new HashMap<>();
            ArrayList<User> user = new ArrayList<>();
            StringTokenizer st;

            for (int i = 0 ; i < record.length ; i++) {
                st = new StringTokenizer(record[i]);

                String type = st.nextToken();
                String id = st.nextToken();

                // type : Enter, Leave, Change
                if (type.equals("Enter")){
                    String name = st.nextToken();
                    user.add(new User(type, id));
                    map.put(id, name);
                }
                else if (type.equals("Leave")) {
                    user.add(new User(type, id));
                }
                else {
                    String name = st.nextToken();
                    map.put(id, name);
                }

            }

            answer = new String[user.size()];

            for (int i = 0 ; i < user.size() ; i++) {
                // System.out.println(user.get(i).type + " " + user.get(i).id + " "
                //                    + map.get(user.get(i).id));
                if (user.get(i).type.equals("Enter")) {
                    answer[i] = map.get(user.get(i).id) + "님이 들어왔습니다.";
                } else {
                    answer[i] = map.get(user.get(i).id) + "님이 나갔습니다.";
                }

            }

            return answer;
        }

        class User {
            String type;
            String id;

            User(String type, String id) {
                this.type = type;
                this.id = id;
            }

        }

    }

}
