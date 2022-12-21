package Algorithms.DataStructure.SlidingWindow;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class DNA_Password {

    static int checkArr[];
    static int curArr[];
    static int checkSecret;

    // 12891
    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(bf.readLine());

        // 전체 문자열 길이
        int S = Integer.parseInt(st.nextToken());

        // 비밀번호로 사용할 부분 문자열 길이
        int P = Integer.parseInt(st.nextToken());

        // 결과값
        int Result = 0;

        // 입력받은 문자열을 저장할 char 배열 A
        char A[] = new char[S];

        /* 체크해야할 글자의 개수가 4개('A, C, G, T')이므로 크기는 4 */
        // 비밀번호 체크 배열
        checkArr = new int[4];

        // 현재 상태 배열
        curArr = new int[4];

        // 유효한 비밀번호인지 체크 (checkState == 4 ) 판단해 결괏값(Result++) 없데이트
        checkSecret = 0;

        A = bf.readLine().toCharArray();

        st = new StringTokenizer(bf.readLine());

        // 비밀번호 체크 배열 입력
        for (int i = 0; i < 4; i++) {
            checkArr[i] = Integer.parseInt(st.nextToken());

            /* 비밀번호 체크 배열에서 0개 이상이 등장해야 한다는 조건.
            만족하는 값이 없더라도 checkSecret++ 해줌.*/
            if (checkArr[i] == 0) {
                checkSecret++;
            }

        }

        // 초기 P 부분 문자열 처리 부분
        for (int i = 0; i < P; i++) {
            Add(A[i]);
        }

        if (checkSecret == 4) {
            Result++;
        }

        // 슬라이딩 윈도우 처리 부분
        for (int i = P; i < S; i++) {
            int j = i - P;
            Add(A[i]);
            Remove(A[j]);
            if (checkSecret == 4) {
                Result++;
            }
        }

        System.out.println(Result);
        bf.close();
    }

    private static void Add(char c) {

        switch (c) {

            case 'A':
                curArr[0]++;
                if (curArr[0] == checkArr[0]) {
                    checkSecret++;
                }
                break;

            case 'C':
                curArr[1]++;
                if (curArr[1] == checkArr[1]) {
                    checkSecret++;
                }
                break;

            case 'G':
                curArr[2]++;
                if (curArr[2] == checkArr[2]) {
                    checkSecret++;
                }
                break;

            case 'T':
                curArr[3]++;
                if (curArr[3] == checkArr[3]) {
                    checkSecret++;
                }
                break;

        }
    }

    private static void Remove(char c) {
        switch (c) {

            case 'A':
                if (curArr[0] == checkArr[0]) {
                    checkSecret--;
                }
                curArr[0]--;
                break;

            case 'C':
                if (curArr[1] == checkArr[1]) {
                    checkSecret--;
                }
                curArr[1]--;
                break;

            case 'G':
                if (curArr[2] == checkArr[2]) {
                    checkSecret--;
                }
                curArr[2]--;
                break;

            case 'T':
                if (curArr[3] == checkArr[3]) {
                    checkSecret--;
                }
                curArr[3]--;
                break;

        }
    }

}
