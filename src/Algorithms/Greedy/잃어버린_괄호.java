package Algorithms.Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 1541
public class 잃어버린_괄호 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), "-");

        // 가장 앞에 있는 값만 더한다
        int sum = mySum(st.nextToken());

        // 뒤에 나오는 합은 뺸다
        while (st.hasMoreTokens()) {
            sum -= mySum(st.nextToken());
        }

        System.out.println(sum);

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
