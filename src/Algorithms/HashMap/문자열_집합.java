package Algorithms.HashMap;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class 문자열_집합 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 문자열의 개수
        int N = Integer.parseInt(st.nextToken());
        // 검사해야하는 문자열들
        int M = Integer.parseInt(st.nextToken());

        HashMap<String, Integer> hashMap = new HashMap<>();
        String arr[] = new String[N];

        for (int i = 0; i < N; i++) {
            int count = 1;
            arr[i] = br.readLine();

            // 같은 문자열이 있을 경우엔 아래 조건 추가
            /*if (hashMap.containsKey(arr[i])) {
                count = hashMap.get(arr[i]) + 1;
            }*/

            hashMap.put(arr[i], count);
        }

        /*for (String key : hashMap.keySet()) {
            int value = hashMap.get(key);
            System.out.println("Key : [" + key + "]\nvalue : [" + value + "]\n");
        }*/

        int result = 0;
        for (int i = 0; i < M; i++) {
            String s = br.readLine();
            if (hashMap.containsKey(s)) {
                result++;
            }
        }

        System.out.println(result);

    }

}
