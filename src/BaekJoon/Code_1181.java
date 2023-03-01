package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Code_1181 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        ArrayList<String> tmp = new ArrayList<>();
        ArrayList<Word> arr = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            String word = br.readLine();
            if (!tmp.contains(word)) {
                tmp.add(word);
            }
        }

        for (String s : tmp) {
            arr.add(new Word(s));
        }


        Collections.sort(arr);

        for (int i = 0; i < arr.size(); i++) {
            System.out.println(arr.get(i).word);
        }


    }

    static class Word implements Comparable<Word> {
        String word;

        Word(String word) {
            this.word = word;
        }

        @Override
        public int compareTo(Word o) {

            // 길이가 같다면 사전순으로 정렬
            if (this.word.length() == o.word.length()) {
                return this.word.compareTo(o.word);
            }
            // 기본적으로 길이 순으로 정렬
            return this.word.length() - o.word.length();
        }

    }


}
