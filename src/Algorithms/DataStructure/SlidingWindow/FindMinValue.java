package Algorithms.DataStructure.SlidingWindow;

import java.io.*;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class FindMinValue {

    // 11003
    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        // 출력을 버퍼에 넣고 한 번에 출력하기 위해 BufferedWriter 사용
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(bf.readLine());

        int N = Integer.parseInt(st.nextToken()); // 입력 개수
        int L = Integer.parseInt(st.nextToken()); // 슬라이딩 윈도우 크기

        Deque<Node> myDeque = new LinkedList<>(); // 덱 선언

        st = new StringTokenizer(bf.readLine());

        for (int i = 0; i < N; i++) {
            int now = Integer.parseInt(st.nextToken()); // 현재 값을 now 에 저장

            // 새로운 값이 들어올 때 마다 정렬 대신 현재 수 보다 큰 값을 덱에서 제거해 시간 복잡도를 줄임
            // 덱 안에 요소가 존재하고 마지막 value 가 현재 들어온 값 보다 클 때 마지막 값 삭제 ( 작은 값이 들어가야하니까 )
            while (!myDeque.isEmpty() && myDeque.getLast().value > now) {
                myDeque.removeLast();
            }

            // 값, 인덱스 추가
            myDeque.addLast(new Node(now, i));

            // 슬라이딩 윈도우 범위에서 벗어난 값은 덱에서 제거
            if (myDeque.getFirst().index <= i - L) {
                myDeque.removeFirst();
            }

            bw.write(myDeque.getFirst().value + " ");

        }
        bw.flush();
        bw.close();
    }

    static class Node {

        int value;
        int index;

        Node(int value, int index) {
            this.value = value;
            this.index = index;
        }

    }

}
