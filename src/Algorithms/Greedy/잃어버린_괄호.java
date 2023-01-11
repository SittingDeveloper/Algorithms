package Algorithms.Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 1541
public class 잃어버린_괄호 {

    static int answer = 0;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        StringTokenizer st = new StringTokenizer(s, "-");

        // 가장 앞에 있는 값만 더한다
        answer += mySum(st.nextToken());

        // 뒷부분은 더한 값을 뺌
        while (st.hasMoreTokens()) {
            answer -= mySum(st.nextToken());
        }

        System.out.println(answer);
    }

    // 나뉜 그룹의 더하기 연산 수행 함수
    static int mySum(String s) {

        int sum = 0;

        StringTokenizer st = new StringTokenizer(s, "+");

        while (st.hasMoreTokens()) {
            sum += Integer.parseInt(st.nextToken());
        }

        return sum;
    }


}
