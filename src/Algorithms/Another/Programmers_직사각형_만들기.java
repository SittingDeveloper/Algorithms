package Algorithms.Another;

// 직사각형 만들기
public class Programmers_직사각형_만들기 {

    public static void main(String[] args) {

//        int v[][] = {{1, 4}, {3, 4}, {3, 10}};
        int v[][] = {{1, 1}, {2, 2}, {1, 2}};

        int answer[] = new int[2];

        answer[0] = v[0][0] ^ v[1][0] ^ v[2][0];
        answer[1] = v[0][1] ^ v[1][1] ^ v[2][1];

        System.out.println(answer[0] + " " + answer[1]);

    }

}
