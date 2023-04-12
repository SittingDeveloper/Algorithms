package Practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) {

        // 참가자 명단
        String[] participant = {"mislav", "stanko", "mislav", "ana"};
        // 완주자 명단
        String[] completion = {"stanko", "ana", "mislav"};

        HashMap<String, Integer> map = new HashMap<>();

        for (int i = 0; i < participant.length; i++) {

            int count = 1;

            if (map.containsKey(participant[i])) {
                count = map.get(participant[i]) + 1;
            }
            map.put(participant[i], count);
        }

        for (int i = 0; i < completion.length; i++) {

            int count = map.get(completion[i]);

            if (map.containsKey(completion[i])) {
                map.put(completion[i], count - 1);
            }

        }

        String answer = "";

        for (String Key : map.keySet()) {
            if (map.get(Key) > 0) {
                answer = Key;
            }
        }

        System.out.println(answer);

    }

}