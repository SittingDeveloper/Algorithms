package Algorithms.HashMap;

import java.io.IOException;
import java.util.HashMap;

public class 완주하지_못한_선수 {

    public static void main(String[] args) throws IOException {

        // 참가자 명단
        String[] participant = {"mislav", "stanko", "mislav", "ana"};
        // 완주자 명단
        String[] completion = {"stanko", "ana", "mislav"};

        String answer = "";

        HashMap<String, Integer> hashMap = new HashMap<>();

        // 참가자들을 해쉬맵에 추가 (동명이인 유의해서 = 1 이 아니라 +1)
        for (int i = 0; i < participant.length; i++) {
            int count = 1;
            if (hashMap.containsKey(participant[i])) {
                count = hashMap.get(participant[i]) + 1;
            }
            hashMap.put(participant[i], count);
        }

        // 완주했을 경우 해쉬맵에서 해당 인원 - 1 (
        for (int i = 0; i < completion.length; i++) {
            int count = hashMap.get(completion[i]);
            if (hashMap.containsKey(completion[i])) {
                hashMap.put(completion[i], count - 1);
            }
        }

        for (String key : hashMap.keySet()) {
            int value = hashMap.get(key);
            if (value == 1) {
                answer = key;
                break;
            }
        }

        System.out.println(answer);

    }

}