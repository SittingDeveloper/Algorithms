package Algorithms.Search.ParametricSearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

// 2512
public class 예산 {

    /*
    파라메트릭 서치를 활용하기 위해 주어진 최적화 문제를 결정 문제로 바꿔 풀이해보자.
    최적화 문제: 정해진 총액(M)이하에서 최대 예산을 받기 위해서 설정해야 하는 최대의 특정 정수 상한액(K)은 얼마인가?
    결정 문제  : 정해진 총액(M)이하에서 최대 예산은 특정 정수 상한액(K)이하가 되도록 할 수 있는가? (Yes or No)
    * */

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 예산 신청 지역 수
        int N = Integer.parseInt(br.readLine());

        // 각 지역 예산 신청 금액
        StringTokenizer st = new StringTokenizer(br.readLine());
        ArrayList<Integer> arr = new ArrayList<>();

        int startParameter = 0;
        int endParameter = -1;

        for (int i = 0; i < N; i++) {
            arr.add(Integer.parseInt(st.nextToken()));

            // right 범위만 알고 있으면 Sort 할 필요 없음 ( 파라메트릭 서치의 특징 )
            endParameter = Math.max(arr.get(i), endParameter);
        }

        // 총 예산
        int M = Integer.parseInt(br.readLine());

        while (startParameter <= endParameter) {

            int midParameter = (startParameter + endParameter) / 2;
            long budget = 0;

            for (int i = 0; i < N; i++) {
                if (arr.get(i) < midParameter) {
                    budget += arr.get(i);
                } else {
                    budget += midParameter;
                }
            }

            // target > midValue
            if (budget <= M) {
                startParameter = midParameter + 1;
            } else {
                endParameter = midParameter - 1;
            }

        }

        System.out.println(endParameter);

    }

}
