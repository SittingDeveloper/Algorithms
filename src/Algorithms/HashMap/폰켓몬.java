package Algorithms.HashMap;

import java.io.IOException;
import java.util.HashMap;

public class 폰켓몬 {

    public static void main(String[] args) throws IOException {

        // 포켓몬의 종류와 수
        int nums[] = {3, 3, 3, 2, 2, 4};

        int answer = 0;

        HashMap<Integer, Integer> maps = new HashMap<>();

        // 해쉬맵의 크기 == 포켓몬의 종류
        /*for (int i = 0; i < nums.length; i++) {
            int count = 1;

            if (maps.containsKey(nums[i])) {
                count = maps.get(nums[i]) + 1;
            }

            maps.put(nums[i], count);
        }*/

        for (int i = 0; i < nums.length; i++) {
            int count = maps.getOrDefault(nums[i], 1);
            maps.put(nums[i], count);
        }

        // 포켓몬의 종류보다 포켓몬 수 / 2 가 더 크다면 포켓몬의 종류를 정답으로 설정
        if (maps.size() < (nums.length / 2)) {
            answer = maps.size();
        } else {
            answer = (nums.length / 2);
        }

        System.out.println(answer);

    }

}
