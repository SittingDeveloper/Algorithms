package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Code_2839 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int Sugar = Integer.parseInt(br.readLine());
        int count = 0;

        while (Sugar != 0) {

            if (Sugar % 5 == 0) {
                count += Sugar / 5;
                break;
            } else if (Sugar < 0) {
                System.out.println(-1);
                System.exit(0);
            }

            Sugar -= 3;
            count++;

        }

        System.out.println(count);

    }


}
