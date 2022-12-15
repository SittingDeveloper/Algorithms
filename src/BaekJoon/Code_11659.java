package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Code_11659 {

    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer stringtokenizer = new StringTokenizer(bufferedReader.readLine());

        int ElementCount = Integer.parseInt(stringtokenizer.nextToken());
        int PartSumCount = Integer.parseInt(stringtokenizer.nextToken());

        long S[] = new long[ElementCount + 1];

        stringtokenizer = new StringTokenizer(bufferedReader.readLine());

        for (int i = 1; i < S.length; i++) {
            S[i] = S[i - 1] + Integer.parseInt(stringtokenizer.nextToken());
        }

        for (int q = 0; q < PartSumCount; q++) {
            stringtokenizer = new StringTokenizer(bufferedReader.readLine());

            int i = Integer.parseInt(stringtokenizer.nextToken());
            int j = Integer.parseInt(stringtokenizer.nextToken());

            System.out.println(S[j] - S[i - 1]);
        }

    }

}
