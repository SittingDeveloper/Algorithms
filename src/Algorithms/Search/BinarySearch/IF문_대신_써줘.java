package Algorithms.Search.BinarySearch;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 19637
public class IF문_대신_써줘 {

    static ArrayList<Type> list;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        // N : 칭호의 개수 ,  M : 캐릭터 개수
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        // Type 형 클래스 list 선언
        list = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            String name = st.nextToken();
            int value = Integer.parseInt(st.nextToken());

            list.add(new Type(name, value));
        }

        for (int i = 0; i < M; i++) {
            int target = Integer.parseInt(br.readLine());
            String s = BinarySearch(target);

            sb.append(s + "\n");
        }

        System.out.println(sb);

    }

    // 이진탐색 시작
    static String BinarySearch(int target) {

        // 시작점은 0, 종료점은 리스트(칭호)의 개수
        int start = 0;
        int end = list.size();

        int mid;

        while (start <= end) {
            mid = (start + end) / 2;
            if (list.get(mid).value < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        // target 이 속하는 마지막인덱스 다음이 정답 칭호
        return list.get(end + 1).name;
    }

    static class Type {
        String name;
        int value;

        Type(String name, int value) {
            this.name = name;
            this.value = value;
        }

    }

}
