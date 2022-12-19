package Important;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 11659
public class SumOfPart_4 {

    public static void main(String[] args) throws IOException {

        // 입력 최소시간을 맞추기 위해 BufferedReader 사용
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        // StringTokenizer 를 사용하여 입력
        StringTokenizer stringtokenizer = new StringTokenizer(bufferedReader.readLine());

        // 첫 번째 토큰 삽입
        int ElementCount = Integer.parseInt(stringtokenizer.nextToken());

        // 두 번째 토큰 삽입
        int PartSumCount = Integer.parseInt(stringtokenizer.nextToken());

        // stringtokenizer 다시 입력 ( 이전 값은 사라짐 )
        stringtokenizer = new StringTokenizer(bufferedReader.readLine());

        // 합배열은 indexOfArray 방지를 위해 +1 해줘야함
        long S[] = new long[ElementCount + 1];

        /* 합배열 저장하는 부분, 공식 : S[i] = S[i-1] + A[i] */
        // 합 배열 S[] 에 위 stringtokenizer 에서 받은 값으로 넣어줌, i = 1 부터 라는거 주의
       for (int i = 1; i < S.length; i++) {
            S[i] = S[i - 1] + Integer.parseInt(stringtokenizer.nextToken());
        }

       /* 구간합, 공식 : S[j] - S[i-1] */
        for (int q = 0; q < PartSumCount; q++) {
            stringtokenizer = new StringTokenizer(bufferedReader.readLine());

            int i = Integer.parseInt(stringtokenizer.nextToken());
            int j = Integer.parseInt(stringtokenizer.nextToken());

            System.out.println(S[j] - S[i - 1]);
        }

    }

}
