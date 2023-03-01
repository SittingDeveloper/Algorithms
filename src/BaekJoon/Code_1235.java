package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;

public class Code_1235 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        ArrayList<String> student_number = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            student_number.add(br.readLine());
        }

        // HashSet 크기(중복허용x)와 학생수의 크기를 비교할 계획
        HashSet<String> hashSet = new HashSet<>();

        boolean flag = true;
        int k = 1;
        while (flag) {

            String temp[] = new String[N];
            for (int i = 0; i < student_number.size(); i++) {
                // substring 사용, 해당 index 포함해서 endIndex 까지의 값들을 temp[i]에 저장
                temp[i] = student_number.get(i).substring(student_number.get(i).length() - k);
            }

            // Hashset 추가
            for (String s : temp) {
                hashSet.add(s);
            }

            // HashSet 크기와 학생 수 비교, 같을 경우 번호를 다 자른 경우. while 종료
            if (hashSet.size() == N) {
                flag = false;
            }

            // 번호가 다를 경우 겹치는 수가 존재, 학번을 한자리 수 더 늘림
            else {
                hashSet.clear();
                k++;
            }
        }

        System.out.println(k);

    }

}
