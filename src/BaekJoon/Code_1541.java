package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Code_1541 {

    static int answer = 0;

    // 1541
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        StringTokenizer st = new StringTokenizer(s, "-");

        answer += mySum(st.nextToken());

        while (st.hasMoreTokens()) {
            answer -= mySum(st.nextToken());
        }

        System.out.println(answer);
    }

    static int mySum(String s) {

        int sum = 0;

        StringTokenizer st = new StringTokenizer(s, "+");

        while (st.hasMoreTokens()) {
            sum += Integer.parseInt(st.nextToken());
        }

        return sum;
    }


}
