package Practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 물품의 수
        int N = Integer.parseInt(st.nextToken());
        // 가방이 버틸 수 있는 무게
        int K = Integer.parseInt(st.nextToken());

        Item item[] = new Item[N];
        for (int i = 0; i < item.length; i++) {
            st = new StringTokenizer(br.readLine());
            int weight = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());
            item[i] = new Item(weight, value);
        }

        // 디버깅과 동시에 예외터지는 버그
       int DP[] = new int[K + 1];
        for (int i = 0; i < item.length; i++) {

            int curr_weight = item[i].weight;
            int curr_value = item[i].value;

            for (int j = K; j >= curr_weight; j--) {
                DP[j] = Math.max(DP[j - curr_weight] + curr_value, DP[j]);
            }

        }

        System.out.println(DP[K]);

    }

    static class Item {
        int weight;
        int value;

        Item(int weight, int value) {
            this.weight = weight;
            this.value = value;
        }
    }

}