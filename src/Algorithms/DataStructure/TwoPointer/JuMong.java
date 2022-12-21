package Algorithms.DataStructure.TwoPointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class JuMong {

    // 1940
    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(bf.readLine()); // 재료의 개수
        int M = Integer.parseInt(bf.readLine()); // 갑옷이 완성되는 번호의 합

        StringTokenizer st = new StringTokenizer(bf.readLine());

        int A[] = new int[N];

        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(A); // 오름차순 정렬

        int i = 0; // i :  시작점
        int j = A.length - 1; // j : 마지막점
        int count = 0;

        while (i < j) {
            if (A[i] + A[j] < M) {
                i++;
            } else if (A[i] + A[j] > M) {
                j--;
            } else {
                count++;
                i++;
                j--;
            }
        }

        System.out.println(count);
    }

}
